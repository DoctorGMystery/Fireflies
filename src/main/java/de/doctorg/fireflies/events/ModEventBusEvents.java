package de.doctorg.fireflies.events;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.config.custom.FireflySpawnConfig;
import de.doctorg.fireflies.entity.EntityTypes;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.item.custom.ModSpawnEggItem;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = FirefliesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.FIREFLY.get(), FireflyEntity.setCustomAttributes().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

    public static void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        FirefliesMod.LOGGER.info("Fireflies mod recognized on Client-side!");
        event.enqueueWork(() -> {
            EntitySpawnPlacementRegistry.register(EntityTypes.FIREFLY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING, AnimalEntity::canAnimalSpawn);

            ItemModelsProperties.registerProperty(ModItems.FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.WHITE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.ORANGE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.MAGENTA_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.LIGHT_BLUE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.YELLOW_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.LIME_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.PINK_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.GRAY_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.LIGHT_GRAY_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.CYAN_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.PURPLE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.BLUE_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.BROWN_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.GREEN_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.RED_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
                if (stack.getTag() == null) {
                    return 1.0F;
                } else if (stack.getTag().getInt("NumberOfFireflies") == 2) {
                    return 2.0F;
                } else {
                    return 3.0F;
                }
            });
            ItemModelsProperties.registerProperty(ModItems.BLACK_FIREFLY_LANTERN.get(), new ResourceLocation(FirefliesMod.MOD_ID, "number_of_fireflies"), (stack, world, living) -> {
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
