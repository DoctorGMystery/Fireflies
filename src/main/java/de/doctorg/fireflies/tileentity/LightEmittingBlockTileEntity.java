package de.doctorg.fireflies.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;

public class LightEmittingBlockTileEntity extends TileEntity {
    public LightEmittingBlockTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public LightEmittingBlockTileEntity() {
        this(ModTileEntities.LIGHT_EMITTING_TILE.get());
    }

    public String id;

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
}
