package de.doctorg.fireflies.entity.custom;

import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.entity.EntityTypes;
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
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

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

    @Override
    public void livingTick() {
        super.livingTick();
        BlockPos oldPos = getBlockPosition();
        /*if (getBlockPosition().down() != getBlockPosition() ||
                getBlockPosition().up() != getBlockPosition() ||
                getBlockPosition().east() != getBlockPosition() ||
                getBlockPosition().south() != getBlockPosition() ||
                getBlockPosition().west() != getBlockPosition() ||
                getBlockPosition().north() != getBlockPosition()) {

            //System.out.println("check change");
            if (!world.isRemote()) {
                BlockPos copyPos = oldPos.add(-1,-1,-1);
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (world.getBlockState(copyPos) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState()) {
                            world.setBlockState(copyPos, Blocks.AIR.getDefaultState());
                            //System.out.println("remove block at" + copyPos);
                        }
                        copyPos = copyPos.add(1,copyPos.getY(),copyPos.getZ());
                        //System.out.println("add 1 to x");
                        //System.out.println(copyPos);
                    }
                    if (copyPos != oldPos.add(oldPos.getX(),oldPos.getY(),3)) {
                        copyPos = copyPos.add(oldPos.getX(),copyPos.getY(),1);
                        //System.out.println("add 1 to z and reset x");
                    }
                    if (copyPos == oldPos.add(oldPos.getX(),oldPos.getY(),3)) {
                        copyPos = copyPos.add(-3, 1, -3);
                        //System.out.println("add 1 to y and reset z and x");
                    }
                }*/
                    if (world.getBlockState(oldPos.down()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.down(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.up()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.up(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.north(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.east()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.east(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.south(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.west()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.west(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.down().west().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.down().west().north(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.down().east().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.down().east().south(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.up().west().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.up().west().north(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.up().west().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.up().west().south(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.down().east().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.down().east().north(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.down().west().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.down().west().south(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.up().west().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.up().west().south(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.up().east().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.up().east().north(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.down().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.down().north(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.down().east()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.down().east(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.down().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.down().south(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.down().west()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.down().west(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.up().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.up().north(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.up().east()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.up().east(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.up().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.up().south(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.up().west()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.up().west(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.east().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.east().north(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.east().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.east().south(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.west().north()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.west().north(), Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(oldPos.west().south()) == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState())
                    {
                        world.setBlockState(oldPos.west().south(), Blocks.AIR.getDefaultState());
                    }


                    /*world.setBlockState(oldPos.north(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.east(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.south(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.west(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.down().west().south(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.down().west().north(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.down().east().south(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.down().east().north(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.up().west().south(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.up().west().north(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.up().east().south(), Blocks.AIR.getDefaultState());
                    world.setBlockState(oldPos.up().east().north(), Blocks.AIR.getDefaultState());*/
                    //System.out.println("remove old");

                if (world.getBlockState(this.getPosition()) == Blocks.AIR.getDefaultState())
                {
                    world.setBlockState(this.getPosition(), ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState());
                    //System.out.println("set new");
                }
            }
        /*}
    }*/

    /*@SubscribeEvent
    public void LightFirefly(PlayerEntity player, World world) {
        BlockPos oldPos = getBlockPosition();
        System.out.println("save Block Pos");
        if (oldPos != this.getPosition()) {
            System.out.println("check change");
            if (!world.isRemote()) {
                world.setBlockState(oldPos, Blocks.AIR.getDefaultState());
                System.out.println("remove old");
                world.setBlockState(this.getPosition(), ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState());
                System.out.println("set new");
            }
        }
    }*/

    private BlockPos getBlockPosition() {
        return this.getPosition();
    }

    public static List Entities;

    @SubscribeEvent
    public static void Test(EntityJoinWorldEvent event) {
        if (event.getEntity().getType() == EntityTypes.FIREFLY.get()) {
            if (event.getEntity().getTags().contains("checked")) {
                System.out.println("Firefly was already checked");
            } else {
                event.getEntity().addTag("checked");
                System.out.println("Firefly spawned");
                System.out.println(event.getEntity().getUniqueID());
            }
        }
    }

    @SubscribeEvent
    public static void RemoveLightOnLeavingWorld(EntityLeaveWorldEvent event) {
        if (event.getEntity().getType() == EntityTypes.FIREFLY.get()) {
            BlockPos localLight = event.getEntity().getPosition();
            event.getWorld().setBlockState(localLight, Blocks.AIR.getDefaultState());
        }
    }
}