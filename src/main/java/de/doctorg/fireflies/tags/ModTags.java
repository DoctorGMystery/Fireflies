package de.doctorg.fireflies.tags;

import de.doctorg.fireflies.FirefliesMod;
import net.minecraft.world.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class ModTags {

    public static class Items {
        public static final Tag.Named<Item> FIREFLY_LANTERN = ItemTags.bind(new ResourceLocation(FirefliesMod.MOD_ID, "firefly_lantern").toString());
    }
}
