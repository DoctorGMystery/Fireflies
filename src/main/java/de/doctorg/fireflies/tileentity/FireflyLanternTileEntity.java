package de.doctorg.fireflies.tileentity;

import de.doctorg.fireflies.block.custom.FireflyLanternBlock;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class FireflyLanternTileEntity extends TileEntity implements ITickableTileEntity {

    public FireflyLanternTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public FireflyLanternTileEntity() {
        this(ModTileEntities.FIREFLY_LANTERN_TILE.get());
    }

    public int lastLightPhase = 0;

    public int lightedTime = 0;

    public int unlightedTime = 0;

    public Boolean isLighted = true;

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("lastLightPhase", FireflyLanternTileEntity.this.lastLightPhase);
        compound.putInt("lightedTime", FireflyLanternTileEntity.this.lightedTime);
        compound.putInt("unlightedTime", FireflyLanternTileEntity.this.unlightedTime);
        compound.putBoolean("isLighted", FireflyLanternTileEntity.this.isLighted);
        return super.write(compound);
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        FireflyLanternTileEntity.this.lastLightPhase = nbt.getInt("lastLightPhase");
        FireflyLanternTileEntity.this.lightedTime = nbt.getInt("lightedTime");
        FireflyLanternTileEntity.this.unlightedTime = nbt.getInt("unlightedTime");
        FireflyLanternTileEntity.this.isLighted = nbt.getBoolean("isLighted");
        super.read(state, nbt);
    }

    public void setLighted(Boolean isLighted) {
        FireflyLanternTileEntity.this.isLighted = isLighted;
    }

    public Integer getUnlightedTime() {
        return FireflyLanternTileEntity.this.unlightedTime;
    }

    public void setUnlightedTime(Integer NewUnlightedTime) {
        FireflyLanternTileEntity.this.unlightedTime = NewUnlightedTime;
    }

    public Integer getLightedTime() {
        return FireflyLanternTileEntity.this.lightedTime;
    }

    public void setLightedTime(Integer NewLightedTime) {
        FireflyLanternTileEntity.this.lightedTime = NewLightedTime;
    }

    public Integer getLastLightPhase() {
        return FireflyLanternTileEntity.this.lastLightPhase;
    }

    public void setLastLightPhase(Integer NewLastLightPhase) {
        FireflyLanternTileEntity.this.lastLightPhase = NewLastLightPhase;
    }

    @Override
    public void tick() {
        if (FireflyEntity.checkForPlayerIsNearby(this.getPos(), this.world)) {
            if (!world.isRemote)
            {
                if (!world.isDaytime()) {
                    if (getBlockState().get(FireflyLanternBlock.NUMBER_OF_FIREFLIES) == 3) {
                        setLighted(true);
                        FireflyLanternBlock.setLITMode(getBlockState(), world, pos, true);
                        setLightedTime(-1);
                        setUnlightedTime(-1);
                    } else {
                        if (getLightedTime() == -1) {
                            setLightedTime(0);
                        }
                        if (getUnlightedTime() == 0 && getLastLightPhase() == 0) {
                            if (getBlockState().get(FireflyLanternBlock.NUMBER_OF_FIREFLIES) == 1) {
                                setLightedTime((int) ((Math.random() * (22 - 11)) + 11));
                                setLastLightPhase(1);
                            } else if (getBlockState().get(FireflyLanternBlock.NUMBER_OF_FIREFLIES) == 2) {
                                setLightedTime((int) ((Math.random() * (44 - 22)) + 22));
                                setLastLightPhase(1);
                            }
                        }
                        if (getUnlightedTime() == -1) {
                            setUnlightedTime(0);
                        }
                        if (getLightedTime() == 0 && getLastLightPhase() == 1) {
                            if (getBlockState().get(FireflyLanternBlock.NUMBER_OF_FIREFLIES) == 1) {
                                setUnlightedTime((int) ((Math.random() * (25 - 10)) + 10));
                                setLastLightPhase(0);
                            } else if (getBlockState().get(FireflyLanternBlock.NUMBER_OF_FIREFLIES) == 2) {
                                setUnlightedTime((int) ((Math.random() * (12 - 5)) + 5));
                                setLastLightPhase(0);
                            }
                        }
                        if (getLightedTime() != 0) {
                            FireflyLanternBlock.setLITMode(getBlockState(), world, pos, true);
                            setLighted(true);
                            setLightedTime(getLightedTime() - 1);
                        }

                        if (getUnlightedTime() != 0) {
                            FireflyLanternBlock.setLITMode(getBlockState(), world, pos, false);
                            setLighted(false);
                            setUnlightedTime(getUnlightedTime() - 1);
                        }
                    }
                } else {
                    setLighted(false);
                    FireflyLanternBlock.setLITMode(getBlockState(), world, pos, false);
                    setLightedTime(-1);
                    setUnlightedTime(-1);
                }
            }
        }
    }
}
