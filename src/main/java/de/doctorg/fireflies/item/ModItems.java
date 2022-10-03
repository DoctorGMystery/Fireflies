package de.doctorg.fireflies.item;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.entity.EntityTypes;
import de.doctorg.fireflies.item.custom.FireflyLanternItem;
import de.doctorg.fireflies.item.custom.ModSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirefliesMod.MOD_ID);

    public static final RegistryObject<ModSpawnEggItem> FIREFLY_SPAWN_EGG = ITEMS.register("firefly_spawn_egg",
            () -> new ModSpawnEggItem(EntityTypes.FIREFLY, 0xFFC800, 0x332700,
                    new Item.Properties().group(ItemGroup.MISC)));

    public static final RegistryObject<Item> FIREFLY_IN_GLASS = ITEMS.register("firefly_in_glass",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC).containerItem(Items.GLASS_BOTTLE).group(ItemGroup.MISC)));

    public static final RegistryObject<FireflyLanternItem> FIREFLY_LANTERN = ITEMS.register("firefly_lantern",
            () -> new FireflyLanternItem(ModBlocks.FIREFLY_LANTERN.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
