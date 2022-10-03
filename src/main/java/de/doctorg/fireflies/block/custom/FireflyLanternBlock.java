package de.doctorg.fireflies.block.custom;

import de.doctorg.fireflies.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class FireflyLanternBlock extends LanternBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final IntegerProperty NUMBER_OF_FIREFLIES = IntegerProperty.create("number_of_fireflies", 1, 5);

    protected static final VoxelShape SHAPE = VoxelShapes.or(Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D), Block.makeCuboidShape(5.0D, 10.0D, 5.0D, 11.0D, 12.0D, 11.0D), Block.makeCuboidShape(6.0D, 12.0D, 6.0D, 10.0D, 13.0D, 10.0D));

    public FireflyLanternBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(LanternBlock.WATERLOGGED, Boolean.valueOf(false)).with(LanternBlock.HANGING, Boolean.valueOf(false)).with(NUMBER_OF_FIREFLIES, Integer.valueOf(1)));
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.FIREFLY_LANTERN_TILE.get().create();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState superState = super.getStateForPlacement(context);
        CompoundNBT compoundNBT = context.getItem().getTag();
        int number = Integer.valueOf(1);
        if (compoundNBT != null) {
            number = Integer.valueOf(compoundNBT.getInt("NumberOfFireflies"));
        }

        return superState.with(NUMBER_OF_FIREFLIES, number);
    }

    public static void setLITMode(BlockState state, World world, BlockPos pos, Boolean mode) {
        world.setBlockState(pos, state.with(LIT, Boolean.valueOf(mode)), 3);
    }

    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LIT, LanternBlock.WATERLOGGED, LanternBlock.HANGING, NUMBER_OF_FIREFLIES);
    }
}
