package de.doctorg.fireflies.item;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.entity.ModEntityTypes;
import de.doctorg.fireflies.item.custom.FireflyLanternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirefliesMod.MOD_ID);

    public static final RegistryObject<ForgeSpawnEggItem> FIREFLY_SPAWN_EGG = ITEMS.register("firefly_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FIREFLY, 0xFFC800, 0x332700,
                    new Item.Properties()));

    public static final RegistryObject<Item> FIREFLY_IN_GLASS = ITEMS.register("firefly_in_glass",
            () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

    public static final RegistryObject<FireflyLanternItem> FIREFLY_LANTERN = ITEMS.register("firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.FIREFLY_LANTERN.get(), new Item.Properties(), 0xFFFFFF));

    public static final RegistryObject<FireflyLanternItem> WHITE_FIREFLY_LANTERN = ITEMS.register("white_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.WHITE_FIREFLY_LANTERN.get(), new Item.Properties(), 0xFFFFFF));

    public static final RegistryObject<FireflyLanternItem> ORANGE_FIREFLY_LANTERN = ITEMS.register("orange_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.ORANGE_FIREFLY_LANTERN.get(), new Item.Properties(), 0xd87f33));

    public static final RegistryObject<FireflyLanternItem> MAGENTA_FIREFLY_LANTERN = ITEMS.register("magenta_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.MAGENTA_FIREFLY_LANTERN.get(), new Item.Properties(), 0xb24cd8));

    public static final RegistryObject<FireflyLanternItem> LIGHT_BLUE_FIREFLY_LANTERN = ITEMS.register("light_blue_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.LIGHT_BLUE_FIREFLY_LANTERN.get(), new Item.Properties(), 0x6699d8));

    public static final RegistryObject<FireflyLanternItem> YELLOW_FIREFLY_LANTERN = ITEMS.register("yellow_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.YELLOW_FIREFLY_LANTERN.get(), new Item.Properties(), 0xe5e533));

    public static final RegistryObject<FireflyLanternItem> LIME_FIREFLY_LANTERN = ITEMS.register("lime_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.LIME_FIREFLY_LANTERN.get(), new Item.Properties(), 0x7fcc19));

    public static final RegistryObject<FireflyLanternItem> PINK_FIREFLY_LANTERN = ITEMS.register("pink_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.PINK_FIREFLY_LANTERN.get(), new Item.Properties(), 0xf27fa5));

    public static final RegistryObject<FireflyLanternItem> GRAY_FIREFLY_LANTERN = ITEMS.register("gray_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.GRAY_FIREFLY_LANTERN.get(), new Item.Properties(), 0x4c4c4c));

    public static final RegistryObject<FireflyLanternItem> LIGHT_GRAY_FIREFLY_LANTERN = ITEMS.register("light_gray_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.LIGHT_GRAY_FIREFLY_LANTERN.get(), new Item.Properties(), 0x999999));

    public static final RegistryObject<FireflyLanternItem> CYAN_FIREFLY_LANTERN = ITEMS.register("cyan_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.CYAN_FIREFLY_LANTERN.get(), new Item.Properties(), 0x4c7f99));

    public static final RegistryObject<FireflyLanternItem> PURPLE_FIREFLY_LANTERN = ITEMS.register("purple_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.PURPLE_FIREFLY_LANTERN.get(), new Item.Properties(), 0x7f3fb2));

    public static final RegistryObject<FireflyLanternItem> BLUE_FIREFLY_LANTERN = ITEMS.register("blue_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.BLUE_FIREFLY_LANTERN.get(), new Item.Properties(), 0x334cb2));

    public static final RegistryObject<FireflyLanternItem> BROWN_FIREFLY_LANTERN = ITEMS.register("brown_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.BROWN_FIREFLY_LANTERN.get(), new Item.Properties(), 0x664c33));

    public static final RegistryObject<FireflyLanternItem> GREEN_FIREFLY_LANTERN = ITEMS.register("green_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.GREEN_FIREFLY_LANTERN.get(), new Item.Properties(), 0x667f33));

    public static final RegistryObject<FireflyLanternItem> RED_FIREFLY_LANTERN = ITEMS.register("red_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.RED_FIREFLY_LANTERN.get(), new Item.Properties(), 0x993333));

    public static final RegistryObject<FireflyLanternItem> BLACK_FIREFLY_LANTERN = ITEMS.register("black_firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.BLACK_FIREFLY_LANTERN.get(), new Item.Properties(), 0x191919));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
