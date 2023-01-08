package de.doctorg.fireflies.block.custom;

import de.doctorg.fireflies.blockentity.LightEmittingBlockBlockEntity;
import de.doctorg.fireflies.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class LightEmittingBlock extends AirBlock implements EntityBlock {

    public LightEmittingBlock(Block.Properties properties) {
        super(properties);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return FireflyLanternBlock.createTickerHelper(type, ModBlockEntities.LIGHT_EMITTING_TILE.get(), LightEmittingBlockBlockEntity::tick);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state) {
        return new LightEmittingBlockBlockEntity(blockPos, state);
    }
}
