package de.doctorg.fireflies.entity.custom;

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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

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
    public Vector3d getLeashStartPosition() {
        return new Vector3d(5.0D, (5.5F * this.getEyeHeight()), (this.getWidth() * 5.4F));
    }

    public boolean InNotFullBlock() {
        return true;
    }
}