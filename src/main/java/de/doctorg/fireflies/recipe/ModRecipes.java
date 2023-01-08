package de.doctorg.fireflies.recipe;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.recipe.recipes.LevelFireflyLanternRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> REG = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FirefliesMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CustomRecipe>> LEVEL_FIREFLY_LANTERN_RECIPE = REG.register("level_firefly_lantern_recipe", makeSerializer(LevelFireflyLanternRecipe::new));

    private static <T extends CraftingRecipe> Supplier<RecipeSerializer<T>> makeSerializer(final Function<ResourceLocation, T> factory) {
        return () -> new SimpleRecipeSerializer<>(factory);
    }

    public static void register(IEventBus eventBus) {
        REG.register(eventBus);
    }
}
