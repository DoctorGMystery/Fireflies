package de.doctorg.fireflies.entity.custom;

import com.github.alexthe666.citadel.config.biome.BiomeEntryType;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.blockentity.LightEmittingBlockBlockEntity;
import de.doctorg.fireflies.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class FireflyEntity extends Parrot {

    public LightEmittingBlockBlockEntity blockEntity;
    private static final EntityDataAccessor<Boolean> IS_LIGHTED = SynchedEntityData.defineId(FireflyEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> LIGHTED_TIME = SynchedEntityData.defineId(FireflyEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> UNLIGHTED_TIME = SynchedEntityData.defineId(FireflyEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> LAST_LIGHT_PHASE = SynchedEntityData.defineId(FireflyEntity.class, EntityDataSerializers.INT);
    public float ALPHA = 0.0F;
    public int Cooldown = 0;

    public FireflyEntity(EntityType<? extends Parrot> type, Level levelIn) {
        super(type, levelIn);
        this.moveControl = new FlyingMoveControl(this, 10, false);
    }

    public static AttributeSupplier.Builder setCustomAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.5D)
                .add(Attributes.FLYING_SPEED, 0.2D)
                .add(Attributes.MOVEMENT_SPEED, 0.05D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0,new AvoidFluid(this));
        this.goalSelector.addGoal(1,new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(2,new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3,new RandomLookAroundGoal(this));
    }

    @Override
    public int getExperienceReward() {
        return 1 + this.level.random.nextInt(1);
    }

    @Override
    public SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.BEE_LOOP, 0.2F, 1.0F);
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        this.playSound(SoundEvents.BEE_HURT, 1.0F, 1.7F);
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.BEE_DEATH, 0.7F, 2.0F);
        return null;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_LIGHTED, true);
        this.entityData.define(LIGHTED_TIME, 0);
        this.entityData.define(UNLIGHTED_TIME, 0);
        this.entityData.define(LAST_LIGHT_PHASE, 0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(IS_LIGHTED, pCompound.getBoolean("IsLighted"));
        this.entityData.set(LIGHTED_TIME, pCompound.getInt("LightedTime"));
        this.entityData.set(UNLIGHTED_TIME, pCompound.getInt("UnlightedTime"));
        this.entityData.set(LAST_LIGHT_PHASE, pCompound.getInt("LastLightPhase"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("IsLighted", this.entityData.get(IS_LIGHTED));
        pCompound.putInt("LightedTime", this.entityData.get(LIGHTED_TIME));
        pCompound.putInt("UnlightedTime", this.entityData.get(UNLIGHTED_TIME));
        pCompound.putInt("LastLightPhase", this.entityData.get(LAST_LIGHT_PHASE));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.Cooldown == 0) {
            if (checkForPlayerIsNearby(this.blockPosition(), this.level)) {
                if (!level.isClientSide)
                {
                    if (!level.isDay()) {
                        if (getLightedTime() == -1) {
                            setLightedTime(0);
                        }
                        if (getUnlightedTime() == 0 && this.entityData.get(LAST_LIGHT_PHASE) == 0) {
                            setLightedTime((int) ((Math.random() * (22 - 11)) + 11));
                            this.entityData.set(LAST_LIGHT_PHASE, 1);
                        }
                        if (getUnlightedTime() == -1) {
                            setUnlightedTime(0);
                        }
                        if (getLightedTime() == 0 && this.entityData.get(LAST_LIGHT_PHASE) == 1) {
                            setUnlightedTime((int) ((Math.random() * (25 - 10)) + 10));
                            this.entityData.set(LAST_LIGHT_PHASE, 0);
                        }
                        if (getLightedTime() != 0) {
                            if (this.level.getBlockState(this.blockPosition()) == Blocks.AIR.defaultBlockState() || this.level.getBlockState(this.blockPosition()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().defaultBlockState()) {
                                this.level.setBlock(this.blockPosition(), ModBlocks.LIGHT_EMITTING_BLOCK.get().defaultBlockState(), 3);
                                updateTileEntity(this.blockPosition(), this.level);

                                if (this.blockEntity != null) {
                                    this.blockEntity.setId(this.getUUID().toString());
                                }
                            }
                            setLightedTime(getLightedTime() - 1);
                        }

                        if (getUnlightedTime() != 0) {
                            updateTileEntity(this.blockPosition(), this.level);
                            {
                                if (this.blockEntity != null) {
                                    if (this.blockEntity.getId() != null) {
                                        if (this.blockEntity.getId().equals(this.getUUID().toString())) {
                                            level.setBlock(this.blockEntity.getBlockPos(), Blocks.AIR.defaultBlockState(), 3);
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

                    this.setLighted(level.getBlockState(this.blockPosition()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().defaultBlockState() ||
                            (level.getBlockState(this.blockPosition()) == Blocks.AIR.defaultBlockState() && !level.isDay() && this.getLightedTime() != 0));
                    if (level.isDay()) {
                        this.setLighted(false);
                    }
                }
            }
        } else if (this.Cooldown > 0) {
            this.Cooldown -= 1;
            this.setLighted(false);
        }
    }

    public Boolean getLighted() {
        return this.entityData.get(IS_LIGHTED);
    }

    public void setLighted(Boolean lighted) {
        this.entityData.set(IS_LIGHTED, lighted);
    }

    public int getLightedTime() {
        return this.entityData.get(LIGHTED_TIME);
    }

    public void setLightedTime(Integer lightedTime) {
        this.entityData.set(LIGHTED_TIME, lightedTime);
    }

    public int getUnlightedTime() {
        return this.entityData.get(UNLIGHTED_TIME);
    }

    public void setUnlightedTime(Integer unlightedTime) {
        this.entityData.set(UNLIGHTED_TIME, unlightedTime);
    }

    public float getALPHA() {
        return this.ALPHA;
    }

    public void setALPHA(float ALPHA) {
        this.ALPHA = ALPHA;
    }

    public void updateTileEntity(BlockPos pos, Level level) {
        if (level.getBlockEntity(pos) != null) {
            if (level.getBlockEntity(pos).getType() == ModBlockEntities.LIGHT_EMITTING_TILE.get()) {
                blockEntity = (LightEmittingBlockBlockEntity) level.getBlockEntity(pos);
            } else {
                blockEntity = null;
            }
        }
    }

    public static boolean checkForPlayerIsNearby(BlockPos pos, Level level) {
        BlockPos posMax = new BlockPos(pos.getX() + 79, pos.getY() + 200, pos.getZ() + 79);
        BlockPos posMin = new BlockPos(pos.getX() - 79, pos.getY() - 200, pos.getZ() - 79);
        List<Player> players = level.getEntitiesOfClass(Player.class, new AABB(posMax, posMin));
        return !players.isEmpty();
    }

    static class AvoidFluid extends Goal {
        private final FireflyEntity parentEntity;

        AvoidFluid(FireflyEntity parentEntity) {
            this.parentEntity = parentEntity;
        }

        @Override
        public boolean canUse() {
            Block blockAtPosition = this.parentEntity.level.getBlockState(this.parentEntity.blockPosition()).getBlock();
            return blockAtPosition instanceof LiquidBlock;
        }

        public void tick() {
            this.parentEntity.Cooldown = 30;
            this.parentEntity.moveControl.tick();
            Vec3 vector3d = this.parentEntity.getDeltaMovement().add(0, 0.1, 0);
            this.parentEntity.setDeltaMovement(vector3d.x, vector3d.y + 0.05, vector3d.z);
        }
    }

    public static final SpawnBiomeData FIREFLY = new SpawnBiomeData().
            addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_plains", 0).
            addBiomeEntry(BiomeEntryType.BIOME_TAG, true, "forge:is_cold", 0).
            addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_savanna", 1).
            addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_forest", 2).
            addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_jungle", 3).
            addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_swamp", 4);
}