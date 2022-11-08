package de.doctorg.fireflies.events;

import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.block.custom.FireflyLanternBlock;
import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.item.custom.FireflyLanternItem;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;

public class ModColorHandler {

    @OnlyIn(Dist.CLIENT)
    public static void ItemColorHandlerEvents(ColorHandlerEvent.Item evt) {
        final ItemColors itemColors = evt.getItemColors();
        itemColors.register((stack, color) -> color > 0 ? ((FireflyLanternItem)stack.getItem()).getColor() : -1,
                ModItems.WHITE_FIREFLY_LANTERN.get(), ModItems.ORANGE_FIREFLY_LANTERN.get(), ModItems.MAGENTA_FIREFLY_LANTERN.get(), ModItems.LIGHT_BLUE_FIREFLY_LANTERN.get(), ModItems.YELLOW_FIREFLY_LANTERN.get(), ModItems.LIME_FIREFLY_LANTERN.get(), ModItems.PINK_FIREFLY_LANTERN.get(), ModItems.GRAY_FIREFLY_LANTERN.get(), ModItems.LIGHT_GRAY_FIREFLY_LANTERN.get(), ModItems.CYAN_FIREFLY_LANTERN.get(), ModItems.PURPLE_FIREFLY_LANTERN.get(), ModItems.BLUE_FIREFLY_LANTERN.get(), ModItems.BROWN_FIREFLY_LANTERN.get(), ModItems.GREEN_FIREFLY_LANTERN.get(), ModItems.RED_FIREFLY_LANTERN.get(), ModItems.BLACK_FIREFLY_LANTERN.get());
    }

    @OnlyIn(Dist.CLIENT)
    public static void BlockColorHandlerEvents(ColorHandlerEvent.Block evt) {
        final BlockColors blockColors = evt.getBlockColors();
        blockColors.register((state, reader, pos, color) -> ((FireflyLanternBlock)state.getBlock()).getColor(),
                ModBlocks.WHITE_FIREFLY_LANTERN.get(), ModBlocks.ORANGE_FIREFLY_LANTERN.get(), ModBlocks.MAGENTA_FIREFLY_LANTERN.get(), ModBlocks.LIGHT_BLUE_FIREFLY_LANTERN.get(), ModBlocks.YELLOW_FIREFLY_LANTERN.get(), ModBlocks.LIME_FIREFLY_LANTERN.get(), ModBlocks.PINK_FIREFLY_LANTERN.get(), ModBlocks.GRAY_FIREFLY_LANTERN.get(), ModBlocks.LIGHT_GRAY_FIREFLY_LANTERN.get(), ModBlocks.CYAN_FIREFLY_LANTERN.get(), ModBlocks.PURPLE_FIREFLY_LANTERN.get(), ModBlocks.BLUE_FIREFLY_LANTERN.get(), ModBlocks.BROWN_FIREFLY_LANTERN.get(), ModBlocks.GREEN_FIREFLY_LANTERN.get(), ModBlocks.RED_FIREFLY_LANTERN.get(), ModBlocks.BLACK_FIREFLY_LANTERN.get());
    }
}
