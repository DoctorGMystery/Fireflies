package de.doctorg.fireflies.blockentity;

import de.doctorg.fireflies.block.custom.FireflyLanternBlock;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FireflyLanternBlockEntity extends BlockEntity{

    public FireflyLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.FIREFLY_LANTERN_TILE.get(), blockPos, blockState);
    }

    public int lastLightPhase = 0;

    public int lightedTime = 0;

    public int unlightedTime = 0;

    public Boolean isLighted = true;

    @Override
    public CompoundTag save(CompoundTag compound) {
        compound.putInt("lastLightPhase", FireflyLanternBlockEntity.this.lastLightPhase);
        compound.putInt("lightedTime", FireflyLanternBlockEntity.this.lightedTime);
        compound.putInt("unlightedTime", FireflyLanternBlockEntity.this.unlightedTime);
        compound.putBoolean("isLighted", FireflyLanternBlockEntity.this.isLighted);
        return super.save(compound);
    }

    @Override
    public void load(CompoundTag nbt) {
        FireflyLanternBlockEntity.this.lastLightPhase = nbt.getInt("lastLightPhase");
        FireflyLanternBlockEntity.this.lightedTime = nbt.getInt("lightedTime");
        FireflyLanternBlockEntity.this.unlightedTime = nbt.getInt("unlightedTime");
        FireflyLanternBlockEntity.this.isLighted = nbt.getBoolean("isLighted");
        super.load(nbt);
    }

    public void setLighted(Boolean isLighted) {
        FireflyLanternBlockEntity.this.isLighted = isLighted;
    }

    public Integer getUnlightedTime() {
        return FireflyLanternBlockEntity.this.unlightedTime;
    }

    public void setUnlightedTime(Integer NewUnlightedTime) {
        FireflyLanternBlockEntity.this.unlightedTime = NewUnlightedTime;
    }

    public Integer getLightedTime() {
        return FireflyLanternBlockEntity.this.lightedTime;
    }

    public void setLightedTime(Integer NewLightedTime) {
        FireflyLanternBlockEntity.this.lightedTime = NewLightedTime;
    }

    public Integer getLastLightPhase() {
        return FireflyLanternBlockEntity.this.lastLightPhase;
    }

    public void setLastLightPhase(Integer NewLastLightPhase) {
        FireflyLanternBlockEntity.this.lastLightPhase = NewLastLightPhase;
    }

    public static void tick(Level level, BlockPos blockPos, BlockState state, FireflyLanternBlockEntity blockEntity) {
        if (FireflyEntity.checkForPlayerIsNearby(blockPos, level)) {
            if (!level.isClientSide)
            {
                if (!level.isDay()) {
                    if (state.getOptionalValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES).get() == 3) {
                        blockEntity.setLighted(true);
                        FireflyLanternBlock.setLITMode(blockEntity.getBlockState(), level, blockPos, true);
                        blockEntity.setLightedTime(-1);
                        blockEntity.setUnlightedTime(-1);
                    } else {
                        if (blockEntity.getLightedTime() == -1) {
                            blockEntity.setLightedTime(0);
                        }
                        if (blockEntity.getUnlightedTime() == 0 && blockEntity.getLastLightPhase() == 0) {
                            if (state.getOptionalValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES).get() == 1) {
                                blockEntity.setLightedTime((int) ((Math.random() * (22 - 11)) + 11));
                                blockEntity.setLastLightPhase(1);
                            } else if (state.getOptionalValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES).get() == 2) {
                                blockEntity.setLightedTime((int) ((Math.random() * (44 - 22)) + 22));
                                blockEntity.setLastLightPhase(1);
                            }
                        }
                        if (blockEntity.getUnlightedTime() == -1) {
                            blockEntity.setUnlightedTime(0);
                        }
                        if (blockEntity.getLightedTime() == 0 && blockEntity.getLastLightPhase() == 1) {
                            if (state.getOptionalValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES).get() == 1) {
                                blockEntity.setUnlightedTime((int) ((Math.random() * (25 - 10)) + 10));
                                blockEntity.setLastLightPhase(0);
                            } else if (state.getOptionalValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES).get() == 2) {
                                blockEntity.setUnlightedTime((int) ((Math.random() * (12 - 5)) + 5));
                                blockEntity.setLastLightPhase(0);
                            }
                        }
                        if (blockEntity.getLightedTime() != 0) {
                            FireflyLanternBlock.setLITMode(blockEntity.getBlockState(), level, blockPos, true);
                            blockEntity.setLighted(true);
                            blockEntity.setLightedTime(blockEntity.getLightedTime() - 1);
                        }

                        if (blockEntity.getUnlightedTime() != 0) {
                            FireflyLanternBlock.setLITMode(blockEntity.getBlockState(), level, blockPos, false);
                            blockEntity.setLighted(false);
                            blockEntity.setUnlightedTime(blockEntity.getUnlightedTime() - 1);
                        }
                    }
                } else {
                    blockEntity.setLighted(false);
                    FireflyLanternBlock.setLITMode(blockEntity.getBlockState(), level, blockPos, false);
                    blockEntity.setLightedTime(-1);
                    blockEntity.setUnlightedTime(-1);
                }
            }
        }
    }
}
