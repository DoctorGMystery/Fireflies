package de.doctorg.fireflies.events;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.config.custom.FireflySpawnConfig;
import de.doctorg.fireflies.entity.ModEntityTypes;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.tags.ModTags;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = FirefliesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            List<Item> fireflyLanterns = ForgeRegistries.ITEMS.tags().getTag(ModTags.Items.FIREFLY_LANTERN).stream().toList();
            for (Item fireflyLantern : fireflyLanterns) {
                event.accept(fireflyLantern);
            }
        }
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.FIREFLY_SPAWN_EGG);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.FIREFLY_IN_GLASS);
        }
    }

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.FIREFLY.get(), FireflyEntity.setCustomAttributes().build());
    }

    public static void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        FirefliesMod.LOGGER.info("Fireflies mod recognized on Client-side!");
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityTypes.FIREFLY.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING, Animal::checkAnimalSpawnRules);

            ItemProperties.register(ModItems.FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.WHITE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.ORANGE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.MAGENTA_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.LIGHT_BLUE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.YELLOW_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.LIME_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.PINK_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.GRAY_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.LIGHT_GRAY_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.CYAN_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.PURPLE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.BLUE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.BROWN_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.GREEN_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.RED_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemProperties.register(ModItems.BLACK_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living, var) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
        });
        FireflySpawnConfig.init();
    }
}
