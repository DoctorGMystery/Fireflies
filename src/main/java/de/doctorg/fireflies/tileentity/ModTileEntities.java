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

    public static RegistryObject<TileEntityType<FireflyLanternTileEntity>> FIREFLY_LANTERN_TILE =
            TILE_ENTITIES.register("firefly_lantern_tile", () -> TileEntityType.Builder.create(
                    FireflyLanternTileEntity::new, ModBlocks.FIREFLY_LANTERN.get(), ModBlocks.WHITE_FIREFLY_LANTERN.get(), ModBlocks.ORANGE_FIREFLY_LANTERN.get(), ModBlocks.MAGENTA_FIREFLY_LANTERN.get(), ModBlocks.LIGHT_BLUE_FIREFLY_LANTERN.get(), ModBlocks.YELLOW_FIREFLY_LANTERN.get(), ModBlocks.LIME_FIREFLY_LANTERN.get(), ModBlocks.PINK_FIREFLY_LANTERN.get(), ModBlocks.GRAY_FIREFLY_LANTERN.get(), ModBlocks.LIGHT_GRAY_FIREFLY_LANTERN.get(), ModBlocks.CYAN_FIREFLY_LANTERN.get(), ModBlocks.PURPLE_FIREFLY_LANTERN.get(), ModBlocks.BLUE_FIREFLY_LANTERN.get(), ModBlocks.BROWN_FIREFLY_LANTERN.get(), ModBlocks.GREEN_FIREFLY_LANTERN.get(), ModBlocks.RED_FIREFLY_LANTERN.get(), ModBlocks.BLACK_FIREFLY_LANTERN.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
