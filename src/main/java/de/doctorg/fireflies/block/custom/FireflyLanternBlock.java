package de.doctorg.fireflies.block.custom;

import de.doctorg.fireflies.blockentity.FireflyLanternBlockEntity;
import de.doctorg.fireflies.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class FireflyLanternBlock extends LanternBlock implements EntityBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final IntegerProperty NUMBER_OF_FIREFLIES = IntegerProperty.create("number_of_fireflies", 1, 3);

    protected static final VoxelShape SHAPE = Shapes.or(Block.box(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D), Block.box(5.0D, 10.0D, 5.0D, 11.0D, 12.0D, 11.0D), Block.box(6.0D, 12.0D, 6.0D, 10.0D, 13.0D, 10.0D));
    private final int color;

    public FireflyLanternBlock(Properties properties, int colorIn) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(LIT, Boolean.valueOf(false)).setValue(HANGING, Boolean.valueOf(false)).setValue(NUMBER_OF_FIREFLIES, Integer.valueOf(1)));
        this.color = colorIn;
    }

    @OnlyIn(Dist.CLIENT)
    public int getColor() {
        return this.color;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.FIREFLY_LANTERN_TILE.get(), FireflyLanternBlockEntity::tick);
    }

    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> p_152133_, BlockEntityType<E> p_152134_, BlockEntityTicker<? super E> p_152135_) {
        return p_152134_ == p_152133_ ? (BlockEntityTicker<A>)p_152135_ : null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state) {
        return new FireflyLanternBlockEntity(blockPos, state);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState superState = super.getStateForPlacement(context);
        CompoundTag compoundTag = context.getItemInHand().getTag();
        int number = Integer.valueOf(1);
        if (compoundTag != null) {
            number = Integer.valueOf(compoundTag.getInt("NumberOfFireflies"));
        }

        if (superState != null) {
            return superState.setValue(NUMBER_OF_FIREFLIES, number);
        }
        return null;
    }

    public static void setLITMode(BlockState state, Level world, BlockPos pos, Boolean mode) {
        world.setBlock(pos, state.setValue(LIT, Boolean.valueOf(mode)), 3);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, LanternBlock.WATERLOGGED, LanternBlock.HANGING, NUMBER_OF_FIREFLIES);
    }
}
