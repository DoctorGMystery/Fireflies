package de.doctorg.fireflies;

import com.mojang.serialization.Codec;
import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.blockentity.ModBlockEntities;
import de.doctorg.fireflies.config.FirefliesConfig;
import de.doctorg.fireflies.entity.ModEntityTypes;
import de.doctorg.fireflies.events.ModEventBusEvents;
import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.recipe.ModRecipes;
import de.doctorg.fireflies.sound.ModSoundEvents;
import de.doctorg.fireflies.world.ModMobSpawning;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
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
        ModBlockEntities.register(eventBus);

        ModEntityTypes.register(eventBus);

        final DeferredRegister<Codec<? extends BiomeModifier>> biomeModifiers =
                DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, FirefliesMod.MOD_ID);
        biomeModifiers.register(eventBus);
        biomeModifiers.register("firefly_spawns", ModMobSpawning::makeCodec);

        // Register the setup method for modloading
        eventBus.addListener(ModEventBusEvents::setup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FirefliesConfig.SPEC, "fiefly.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("Fireflies mod recognized on Server-side!");
    }
}
