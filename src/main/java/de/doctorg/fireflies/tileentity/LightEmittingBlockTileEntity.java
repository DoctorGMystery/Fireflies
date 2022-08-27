package de.doctorg.fireflies.tileentity;

import de.doctorg.fireflies.entity.custom.FireflyEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class LightEmittingBlockTileEntity extends TileEntity implements ITickableTileEntity {
    public LightEmittingBlockTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public LightEmittingBlockTileEntity() {
        this(ModTileEntities.LIGHT_EMITTING_TILE.get());
    }

    public String id = "0";

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putString("id", LightEmittingBlockTileEntity.this.id);
        return super.write(compound);
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        LightEmittingBlockTileEntity.this.id = nbt.getString("id");
        super.read(state, nbt);
    }


    public String getId() {
        return LightEmittingBlockTileEntity.this.id;
    }

    public void setId(String id) {
        LightEmittingBlockTileEntity.this.id = id;
    }

    @Override
    public void tick() {
        BlockPos posMin = this.getPos().down(1).north(1).west(1);
        BlockPos posMax = this.getPos().up(2).south(2).east(2);
        List<FireflyEntity> Entities = this.getWorld().getEntitiesWithinAABB(FireflyEntity.class, new AxisAlignedBB(posMax, posMin));
        for (int i = 0; i < Entities.size(); i++) {
            if (i < Entities.size()) {
                FireflyEntity entity = Entities.get(i);
                if (this.getId() != null) {
                    if (LightEmittingBlockTileEntity.this.getId().equals(entity.getUniqueID().toString())) {
                        if (entity.getLighted() == false) {
                            this.getWorld().setBlockState(this.getPos(), Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }
        }
        if (Entities.isEmpty() || (this.world.getDayTime() < 24000 && this.world.getDayTime() > 23459) || (this.world.getDayTime() > 0 && this.world.getDayTime() < 12542)) {
            this.getWorld().setBlockState(this.getPos(), Blocks.AIR.getDefaultState());
        }
    }
}
