package de.doctorg.fireflies.integrations.jei;

import de.doctorg.fireflies.FirefliesMod;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class FirefliesJei implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(FirefliesMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(LevelFireflyLanternRecipeMaker.createLevelFireflyLanternRecipes(), VanillaRecipeCategoryUid.CRAFTING);
    }
}
