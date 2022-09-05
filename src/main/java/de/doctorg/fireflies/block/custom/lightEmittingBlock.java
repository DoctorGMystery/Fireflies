package de.doctorg.fireflies.block.custom;

import de.doctorg.fireflies.tileentity.ModTileEntities;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class lightEmittingBlock extends AirBlock {

    public lightEmittingBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Deprecated
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.LIGHT_EMITTING_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
