package de.doctorg.fireflies.blockentity;

import de.doctorg.fireflies.entity.custom.FireflyEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class LightEmittingBlockBlockEntity extends BlockEntity{

    public LightEmittingBlockBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.LIGHT_EMITTING_TILE.get(), blockPos, blockState);
    }

    public String id = "0";

    @Override
    public void saveAdditional(CompoundTag nbt) {
        nbt.putString("id", LightEmittingBlockBlockEntity.this.id);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        LightEmittingBlockBlockEntity.this.id = nbt.getString("id");
        super.load(nbt);
    }


    public String getId() {
        return LightEmittingBlockBlockEntity.this.id;
    }

    public void setId(String id) {
        LightEmittingBlockBlockEntity.this.id = id;
    }

    public static void tick(Level level, BlockPos blockPos, BlockState state, LightEmittingBlockBlockEntity blockEntity) {
        BlockPos posMin = blockPos.below(1).north(1).west(1);
        BlockPos posMax = blockPos.above(2).south(2).east(2);
        List<FireflyEntity> Entities = level.getEntitiesOfClass(FireflyEntity.class, new AABB(posMax, posMin));
        for (int i = 0; i < Entities.size(); i++) {
            if (i < Entities.size()) {
                FireflyEntity entity = Entities.get(i);
                if (blockEntity.getId() != null) {
                    if (blockEntity.getId().equals(entity.getUUID().toString())) {
                        if (!entity.getLighted()) {
                            level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
                        }
                    }
                }
            }
        }
        if (Entities.isEmpty() || (level.getDayTime() < 24000 && level.getDayTime() > 23459) || (level.getDayTime() > 0 && level.getDayTime() < 12542)) {
            level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
        }
    }
}
