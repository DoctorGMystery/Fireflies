package de.doctorg.fireflies.tileentity;

import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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
        String  s = this.id;
        compound.putString("id", s);
        return super.write(compound);
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        String s = nbt.getString("id");
        this.id = s;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BlockPos getBlockPos() {
        return pos;
    }

    @Override
    public void tick() {
        if (this.getBlockState() == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState()) {
            BlockPos posMin = this.getPos().down(2).north(2).west(2);
            BlockPos posMax = this.getPos().up(2).south(2).east(2);
            List Entities = this.getWorld().getEntitiesWithinAABB(FireflyEntity.class, new AxisAlignedBB(posMax, posMin));
            if (Entities.isEmpty()) {
                System.out.println(Entities);
                this.getWorld().setBlockState(this.getPos(), Blocks.AIR.getDefaultState(), 1);
                System.out.println(this.getBlockState());
            }
        }
    }
}
