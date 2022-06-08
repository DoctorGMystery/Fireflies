package de.doctorg.fireflies.block.custom;

import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.entity.EntityTypes;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import net.minecraft.block.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Random;

public class lightEmittingBlock extends AirBlock {

    public lightEmittingBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.empty();
    }

    /*@Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        List Entities = worldIn.getEntitiesWithinAABB(FireflyEntity.class, new AxisAlignedBB(this.createTileEntity(ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState(), worldIn).getPos().east(-1).down(-1).north(-1), this.createTileEntity(ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState(), worldIn).getPos().east(1).down(1).north(1)));
        System.out.println(Entities);
    }*/
}
