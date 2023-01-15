package de.doctorg.fireflies.tags;

import de.doctorg.fireflies.FirefliesMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> FIREFLY_LANTERN = ItemTags.create(new ResourceLocation(FirefliesMod.MOD_ID, "firefly_lantern"));
    }
}
