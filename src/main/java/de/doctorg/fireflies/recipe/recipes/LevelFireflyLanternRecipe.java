package de.doctorg.fireflies.recipe.recipes;

import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.recipe.ModRecipes;
import de.doctorg.fireflies.tags.ModTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class LevelFireflyLanternRecipe extends CustomRecipe {
    private static final Ingredient INGREDIENT_FIREFLY_IN_GLASS = Ingredient.of(ModItems.FIREFLY_IN_GLASS.get());
    private static Ingredient INGREDIENT_FIREFLY_LANTERN = Ingredient.of(ModItems.FIREFLY_LANTERN.get());

    private Item item = null;

    public LevelFireflyLanternRecipe(ResourceLocation idIn) {
        super(idIn);
    }

    @Override
    public boolean matches(CraftingContainer pContainer, Level pLevel) {
        INGREDIENT_FIREFLY_LANTERN = Ingredient.of(ModTags.Items.FIREFLY_LANTERN);
        boolean isFireflyLanternInGrid = false;
        boolean isFireflyInGlassInGrid = false;
        for (int i = 0; i < pContainer.getContainerSize(); i++) {
            final ItemStack stack = pContainer.getItem(i);
            if (INGREDIENT_FIREFLY_LANTERN.test(stack)) {
                CompoundTag compoundnbt = stack.getTag();
                if (compoundnbt != null && compoundnbt.getInt("NumberOfFireflies") > 2) {
                    return false;
                }
                if (isFireflyLanternInGrid) {
                    return false;
                }
                isFireflyLanternInGrid = true;
                item = stack.getItem();
            } else if (INGREDIENT_FIREFLY_IN_GLASS.test(stack)) {
                if (isFireflyInGlassInGrid) {
                    return false;
                }

                isFireflyInGlassInGrid = true;
            }
        }
        return isFireflyLanternInGrid && isFireflyInGlassInGrid;
    }

    @Override
    public ItemStack assemble(CraftingContainer pContainer) {
        ItemStack itemstack = new ItemStack(item, 1);
        CompoundTag compoundnbt = itemstack.getOrCreateTag();
        ItemStack oldLantern = new ItemStack(null);
        for (int i = 0; i < pContainer.getContainerSize(); i++) {
            final ItemStack stack = pContainer.getItem(i);
            if (INGREDIENT_FIREFLY_LANTERN.test(stack)) {
                oldLantern = stack;
                break;
            }
        }
        CompoundTag oldLanternNbt = oldLantern.getTag();
        if (oldLanternNbt != null && oldLanternNbt.getInt("NumberOfFireflies") < 3) {
            compoundnbt.putInt("NumberOfFireflies", oldLanternNbt.getInt("NumberOfFireflies") + 1);
        } else {
            compoundnbt.putInt("NumberOfFireflies", 2);
        }
        return itemstack;
    }

    @Override
    public ItemStack getResultItem() {
        return new ItemStack(ModItems.FIREFLY_LANTERN.get());
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth >= 3 && pHeight >= 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.LEVEL_FIREFLY_LANTERN_RECIPE.get();
    }
}
