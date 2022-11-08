package de.doctorg.fireflies.tags;

import de.doctorg.fireflies.FirefliesMod;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {

    public static class Items {
        public static final ITag.INamedTag<Item> FIREFLY_LANTERN = ItemTags.makeWrapperTag(new ResourceLocation(FirefliesMod.MOD_ID, "firefly_lantern").toString());
    }
}
