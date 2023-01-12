package de.doctorg.fireflies.integrations.jei;

import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.tags.ModTags;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.IShapedRecipe;

import java.util.ArrayList;
import java.util.List;

public class LevelFireflyLanternRecipeMaker {
    public static List<IShapedRecipe<?>> createLevelFireflyLanternRecipes() {
        List<IShapedRecipe<?>> recipes = new ArrayList();
        String group = "fireflies.lantern.level";

        for(int i = 0; i < ModTags.Items.FIREFLY_LANTERN.getAllElements().size() * 2; ++i) {
            ItemStack fireflyLantern;
            ItemStack output;
            int levelTo;
            Ingredient lanternIngredient;
            if (i < 17) {
                output = new ItemStack(ModTags.Items.FIREFLY_LANTERN.getAllElements().get(i));
                fireflyLantern = new ItemStack(ModTags.Items.FIREFLY_LANTERN.getAllElements().get(i));
                levelTo = 2;
            } else {
                output = new ItemStack(ModTags.Items.FIREFLY_LANTERN.getAllElements().get(i - 17));
                fireflyLantern = new ItemStack(ModTags.Items.FIREFLY_LANTERN.getAllElements().get(i - 17));
                levelTo = 3;
            }
            fireflyLantern.getOrCreateTag().putInt("NumberOfFireflies", levelTo - 1);
            lanternIngredient = Ingredient.fromStacks(fireflyLantern);
            output.getOrCreateTag().putInt("NumberOfFireflies", levelTo);
            Ingredient fireflyInGlassIngredient = Ingredient.fromItems(ModItems.FIREFLY_IN_GLASS.get());
            NonNullList<Ingredient> inputs = NonNullList.from(Ingredient.EMPTY, new Ingredient[]{lanternIngredient, fireflyInGlassIngredient});
            ResourceLocation id = new ResourceLocation("fireflies", "fireflies.lantern.level." + output.getTranslationKey() + "." + levelTo);
            ShapedRecipe recipe = new ShapedRecipe(id, group, 3, 3, inputs, output);
            recipes.add(recipe);
        }

        return recipes;
    }

    private LevelFireflyLanternRecipeMaker() {
    }
}
