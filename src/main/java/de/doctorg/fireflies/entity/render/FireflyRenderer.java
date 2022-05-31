package de.doctorg.fireflies.entity.render;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.entity.model.FireflyModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FireflyRenderer extends MobRenderer<FireflyEntity, FireflyModel<FireflyEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(FirefliesMod.MOD_ID, "textures/entity/firefly.png");

    public FireflyRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new FireflyModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getEntityTexture(FireflyEntity entity) {
        return TEXTURE;
    }
}