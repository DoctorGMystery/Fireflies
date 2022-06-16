package de.doctorg.fireflies.tileentity;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, FirefliesMod.MOD_ID);

    public static RegistryObject<TileEntityType<LightEmittingBlockTileEntity>> LIGHT_EMITTING_TILE =
            TILE_ENTITIES.register("light_emitting_tile", () -> TileEntityType.Builder.create(
                    LightEmittingBlockTileEntity::new, ModBlocks.LIGHT_EMITTING_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
