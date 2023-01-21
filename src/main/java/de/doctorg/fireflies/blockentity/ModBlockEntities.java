package de.doctorg.fireflies.blockentity;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static DeferredRegister<BlockEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FirefliesMod.MOD_ID);

    public static RegistryObject<BlockEntityType<LightEmittingBlockBlockEntity>> LIGHT_EMITTING_TILE =
            TILE_ENTITIES.register("light_emitting_tile", () -> BlockEntityType.Builder.of(
                    LightEmittingBlockBlockEntity::new, ModBlocks.LIGHT_EMITTING_BLOCK.get()).build(null));

    public static RegistryObject<BlockEntityType<FireflyLanternBlockEntity>> FIREFLY_LANTERN_TILE =
            TILE_ENTITIES.register("firefly_lantern_tile", () -> BlockEntityType.Builder.of(
                    FireflyLanternBlockEntity::new, ModBlocks.FIREFLY_LANTERN.get(), ModBlocks.WHITE_FIREFLY_LANTERN.get(), ModBlocks.ORANGE_FIREFLY_LANTERN.get(), ModBlocks.MAGENTA_FIREFLY_LANTERN.get(), ModBlocks.LIGHT_BLUE_FIREFLY_LANTERN.get(), ModBlocks.YELLOW_FIREFLY_LANTERN.get(), ModBlocks.LIME_FIREFLY_LANTERN.get(), ModBlocks.PINK_FIREFLY_LANTERN.get(), ModBlocks.GRAY_FIREFLY_LANTERN.get(), ModBlocks.LIGHT_GRAY_FIREFLY_LANTERN.get(), ModBlocks.CYAN_FIREFLY_LANTERN.get(), ModBlocks.PURPLE_FIREFLY_LANTERN.get(), ModBlocks.BLUE_FIREFLY_LANTERN.get(), ModBlocks.BROWN_FIREFLY_LANTERN.get(), ModBlocks.GREEN_FIREFLY_LANTERN.get(), ModBlocks.RED_FIREFLY_LANTERN.get(), ModBlocks.BLACK_FIREFLY_LANTERN.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
