package de.doctorg.fireflies;

import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.config.FirefliesConfig;
import de.doctorg.fireflies.entity.EntityTypes;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.entity.render.FireflyRenderer;
import de.doctorg.fireflies.events.ModEventBusEvents;
import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.recipe.ModRecipes;
import de.doctorg.fireflies.sound.ModSoundEvents;
import de.doctorg.fireflies.tileentity.ModTileEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FirefliesMod.MOD_ID)
public class FirefliesMod
{
    public static final String MOD_ID = "fireflies";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public FirefliesMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(eventBus);
        ModItems.register(eventBus);

        ModSoundEvents.register(eventBus);
        ModRecipes.register(eventBus);
        ModTileEntities.register(eventBus);

        EntityTypes.register(eventBus);

        // Register the setup method for modloading
        eventBus.addListener(ModEventBusEvents::setup);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FirefliesConfig.SPEC, "fiefly.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(FireflyEntity.class);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.LIME_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.PINK_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_FIREFLY_LANTERN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_FIREFLY_LANTERN.get(), RenderType.getCutout());
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityTypes.FIREFLY.get(), FireflyRenderer::new);
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("Fireflies mod recognized on Server-side!");
    }
}
