package de.doctorg.fireflies.block.custom;

import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.entity.EntityTypes;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.tileentity.ModTileEntities;
import net.minecraft.block.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class lightEmittingBlock extends AirBlock {

    public lightEmittingBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.empty();
    }

    /*@Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        System.out.println("tick");
        List Entities = worldIn.getEntitiesWithinAABB(FireflyEntity.class, new AxisAlignedBB(this.createTileEntity(ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState(), worldIn).getPos().east(-1).down(-1).north(-1), this.createTileEntity(ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState(), worldIn).getPos().east(1).down(1).north(1)));
        System.out.println(Entities);
        System.out.println("tock");
    }*/

    @SubscribeEvent
    public static void ResetBlockIfNoFireflyNearby(BlockEvent event) {
        if (event.getState() == ModBlocks.LIGHT_EMITTING_BLOCK.get().getDefaultState()) {
            BlockPos posMin = event.getPos().down().north().west();
            BlockPos posMax = event.getPos().up().south().east();
            List Entities = event.getWorld().getEntitiesWithinAABB(FireflyEntity.class, new AxisAlignedBB(posMin, posMax));
            if (Entities.isEmpty()) {
                System.out.println(Entities);
                if (!event.getWorld().isRemote()) {
                    event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState(), 1);
                    System.out.println(event.getState());
                }
            }
        }
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
