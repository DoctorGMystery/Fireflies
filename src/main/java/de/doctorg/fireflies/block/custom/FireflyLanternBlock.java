package de.doctorg.fireflies.block.custom;

import de.doctorg.fireflies.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class FireflyLanternBlock extends LanternBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public FireflyLanternBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(LanternBlock.WATERLOGGED, Boolean.valueOf(false)).with(LanternBlock.HANGING, Boolean.valueOf(false)));
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.FIREFLY_LANTERN_TILE.get().create();
    }

    public static void setLITMode(BlockState state, World world, BlockPos pos, Boolean mode) {
        world.setBlockState(pos, state.with(LIT, Boolean.valueOf(mode)), 3);
    }

    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LIT, LanternBlock.WATERLOGGED, LanternBlock.HANGING);
    }
}
