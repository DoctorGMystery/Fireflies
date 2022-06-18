package de.doctorg.fireflies.entity.custom;

import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.entity.EntityTypes;
import de.doctorg.fireflies.tileentity.LightEmittingBlockTileEntity;
import de.doctorg.fireflies.tileentity.ModTileEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FireflyEntity extends ParrotEntity {
    public FireflyEntity(EntityType<? extends ParrotEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new FireflyFlyingMovementController(this, 10, false);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH,1.5D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.5D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED,0.2D);

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1,new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(2,new WaterAvoidingRandomWalkingGoal(this,1.0D));
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

    public LightEmittingBlockTileEntity tileEntity;

    @Override
    public void livingTick() {
        super.livingTick();
        BlockPos oldPos = getBlockPosition();

        if (world.getBlockState(oldPos.down()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.down());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.down(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.up()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.up());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.up(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.north());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.north(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.east()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.east());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.east(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.south());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.south(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.west()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.west());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.west(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.down().west().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.down().west().north());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.down().west().north(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.down().east().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.down().east().south());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.down().east().south(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.up().west().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.up().west().north());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.up().west().north(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.up().west().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.up().west().south());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.up().west().south(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.down().east().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.down().east().north());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.down().east().north(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.down().west().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.down().west().south());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.down().west().south(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.up().west().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.up().west().south());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.up().west().south(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.up().east().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.up().east().north());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.up().east().north(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.down().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.down().north());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.down().north(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.down().east()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.down().east());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.down().east(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.down().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.down().south());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.down().south(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.down().west()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.down().west());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.down().west(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.up().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.up().north());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.up().north(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.up().east()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.up().east());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.up().east(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.up().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.up().south());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.up().south(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.up().west()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.up().west());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.up().west(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.east().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.east().north());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.east().north(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.east().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.east().south());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.east().south(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.west().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.east().north());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.west().north(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        if (world.getBlockState(oldPos.west().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
        {
            updateTileEntity(oldPos.west().south());
            if (this.tileEntity != null) {
                if (this.tileEntity.getId() != null) {
                    if (this.tileEntity.getId().equals(this.getUniqueID().toString())) {
                        world.setBlockState(oldPos.west().south(), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }

        if (!world.isDaytime()) {
            if (world.getBlockState(this.getPosition()) == Blocks.AIR.getDefaultState())
            {
                world.setBlockState(this.getPosition(), ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState());
                updateTileEntity(getPosition());
                this.tileEntity.setId(this.getUniqueID().toString());
            }
        }
    }

    private BlockPos getBlockPosition() {
        return this.getPosition();
    }

    public void updateTileEntity(BlockPos pos) {
        if (this.world.getTileEntity(pos) != null) {
            if (this.world.getTileEntity(pos).getType() == ModTileEntities.LIGHT_EMITTING_TILE.get()) {
                this.tileEntity = (LightEmittingBlockTileEntity) this.world.getTileEntity(pos);
            } else {
                this.tileEntity = null;
            }
        }
    }

    /*@SubscribeEvent
    public static void Test(EntityJoinWorldEvent event) {
        if (event.getEntity().getType() == EntityTypes.FIREFLY.get()) {
            if (event.getEntity().getTags().contains("checked")) {
                System.out.println("Firefly was already checked");
            } else {
                event.getEntity().addTag("checked");
                System.out.println("Firefly spawned");
            }
        }
    }*/

    @SubscribeEvent
    public static void removeLightOnLeavingWorld(EntityLeaveWorldEvent event) {
        if (event.getEntity().getType() == EntityTypes.FIREFLY.get()) {
            BlockPos localLight = event.getEntity().getPosition();
            event.getWorld().setBlockState(localLight, Blocks.AIR.getDefaultState());
        }
    }
}