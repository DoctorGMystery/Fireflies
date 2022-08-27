package de.doctorg.fireflies.entity.custom;

import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.entity.EntityTypes;
import de.doctorg.fireflies.tileentity.LightEmittingBlockTileEntity;
import de.doctorg.fireflies.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class FireflyEntity extends ParrotEntity{

    public LightEmittingBlockTileEntity tileEntity;
    private static final DataParameter<Boolean> IS_LIGHTED = EntityDataManager.createKey(FireflyEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> LIGHTED_TIME = EntityDataManager.createKey(FireflyEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> UNLIGHTED_TIME = EntityDataManager.createKey(FireflyEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> LAST_LIGHT_PHASE = EntityDataManager.createKey(FireflyEntity.class, DataSerializers.VARINT);

    public FireflyEntity(EntityType<? extends ParrotEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new FlyingMovementController(this, 10, false);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 1.5D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.2D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.05D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1,new AvoidFluid(this));
        this.goalSelector.addGoal(2,new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(3,new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7,new LookRandomlyGoal(this));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
        return 1 + this.world.rand.nextInt(1);
    }

    @Override
    public SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.ENTITY_BEE_LOOP, 0.2F, 1.0F);
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        this.playSound(SoundEvents.ENTITY_BEE_HURT, 1.0F, 1.7F);
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.ENTITY_BEE_DEATH, 0.7F, 2.0F);
        return null;
    }


    protected void registerData() {
        super.registerData();
        this.dataManager.register(IS_LIGHTED, true);
        this.dataManager.register(LIGHTED_TIME, 0);
        this.dataManager.register(UNLIGHTED_TIME, 0);
        this.dataManager.register(LAST_LIGHT_PHASE, 0);
    }

    @Override
    public void livingTick() {
        super.livingTick();

        if (checkForPlayerIsNearby(this.getPosition(), this.world)) {
            if (!world.isRemote)
            {
                if (!world.isDaytime()) {
                    if (getLightedTime() == -1) {
                        setLightedTime(0);
                    }
                    if (getUnlightedTime() == 0 && this.dataManager.get(LAST_LIGHT_PHASE) == 0) {
                        setLightedTime((int) ((Math.random() * (22 - 11)) + 11));
                        this.dataManager.set(LAST_LIGHT_PHASE, 1);
                    }
                    if (getUnlightedTime() == -1) {
                        setUnlightedTime(0);
                    }
                    if (getLightedTime() == 0 && this.dataManager.get(LAST_LIGHT_PHASE) == 1) {
                        setUnlightedTime((int) ((Math.random() * (25 - 10)) + 10));
                        this.dataManager.set(LAST_LIGHT_PHASE, 0);
                    }
                    if (getLightedTime() != 0) {
                        if (this.world.getBlockState(this.getPosition()) == Blocks.AIR.getDefaultState() || this.world.getBlockState(this.getPosition()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState()) {
                            this.world.setBlockState(this.getPosition(), ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState(), 3);
                            updateTileEntity(this.getPosition(), this.world);

                            if (this.tileEntity != null) {
                                this.tileEntity.setId(this.getUniqueID().toString());
                            }
                        }
                        setLightedTime(getLightedTime() - 1);
                    }

                    if (getUnlightedTime() != 0) {
                        updateTileEntity(this.getPosition(), this.world);
                        if (world.getBlockState(this.getPosition()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                        {
                            if (this.tileEntity != null) {
                                if (this.tileEntity.getId() != null) {
                                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                                        world.setBlockState(this.getPosition(), Blocks.AIR.getDefaultState());
                                    }
                                }
                            }
                        }

                        setUnlightedTime(getUnlightedTime() - 1);
                    }
                } else {
                    setLightedTime(-1);
                    setUnlightedTime(-1);
                }

                this.setLighted(world.getBlockState(this.getPosition()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState() ||
                        (world.getBlockState(this.getPosition()) == Blocks.AIR.getDefaultState() && !world.isDaytime() && this.getLightedTime() != 0));
                if (world.isDaytime()) {
                    this.setLighted(false);
                }
            }
        }
    }

    @SubscribeEvent
    public static void removeLightOnLeavingWorld(EntityLeaveWorldEvent event) {
        if (event.getEntity().world.getBlockState(event.getEntity().getPosition()).getBlock() == ModBlocks.LIGHT_EMITTING_BLOCK.get()) {
            event.getWorld().setBlockState(event.getEntity().getPosition(), Blocks.AIR.getDefaultState());
        }
    }

    public Boolean getLighted() {
        return this.dataManager.get(IS_LIGHTED);
    }

    public void setLighted(Boolean lighted) {
        this.dataManager.set(IS_LIGHTED, lighted);
    }

    public int getLightedTime() {
        return this.dataManager.get(LIGHTED_TIME);
    }

    public void setLightedTime(Integer lightedTime) {
        this.dataManager.set(LIGHTED_TIME, lightedTime);
    }

    public int getUnlightedTime() {
        return this.dataManager.get(UNLIGHTED_TIME);
    }

    public void setUnlightedTime(Integer unlightedTime) {
        this.dataManager.set(UNLIGHTED_TIME, unlightedTime);
    }

    public void updateTileEntity(BlockPos pos, World world) {
        if (world.getTileEntity(pos) != null) {
            if (world.getTileEntity(pos).getType() == ModTileEntities.LIGHT_EMITTING_TILE.get()) {
                tileEntity = (LightEmittingBlockTileEntity) world.getTileEntity(pos);
            } else {
                tileEntity = null;
            }
        }
    }

    public boolean checkForPlayerIsNearby(BlockPos pos, World world) {
        BlockPos posMax = new BlockPos(pos.getX() + 79, pos.getY() + 200, pos.getZ() + 79);
        BlockPos posMin = new BlockPos(pos.getX() - 79, pos.getY() - 200, pos.getZ() - 79);
        List<PlayerEntity> players = world.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(posMax, posMin));
        if (players.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    static class AvoidFluid extends Goal {
        private final FireflyEntity parentEntity;

        AvoidFluid(FireflyEntity parentEntity) {
            this.parentEntity = parentEntity;
        }

        public boolean shouldExecute() {
            Block blockAtPosition = this.parentEntity.world.getBlockState(this.parentEntity.getPosition()).getBlock();
            Block BlockUnderPosition = this.parentEntity.world.getBlockState(this.parentEntity.getPosition().down()).getBlock();
            return BlockUnderPosition == Blocks.WATER ||
                    blockAtPosition == Blocks.WATER ||
                    BlockUnderPosition == Blocks.LAVA ||
                    blockAtPosition == Blocks.LAVA;
        }
        public void tick() {
            float f = this.parentEntity.getJumpUpwardsMotion();
            Vector3d vector3d = this.parentEntity.getMotion();
            this.parentEntity.setMotion(vector3d.x, f, vector3d.z);
        }
    }
}