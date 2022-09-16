package de.doctorg.fireflies.block;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.block.custom.lightEmittingBlock;
import de.doctorg.fireflies.config.FirefliesConfig;
import de.doctorg.fireflies.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirefliesMod.MOD_ID);

    public static final RegistryObject<Block> LIGHT_EMITTING_BLOCK = BLOCKS.register("light_emitting_block",
            () -> new lightEmittingBlock(AbstractBlock.Properties.create(Material.AIR).setLightLevel((state) -> 5).doesNotBlockMovement().noDrops().setAir()));

    public static final RegistryObject<Block> FIREFLY_LANTERN = registerBlock("firefly_lantern",
            () -> new LanternBlock(AbstractBlock.Properties.create(Material.IRON).setLightLevel((state) -> 5).setRequiresTool().hardnessAndResistance(3.5F).sound(SoundType.LANTERN).notSolid()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ItemGroup.DECORATIONS)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
