package de.doctorg.fireflies.entity.render;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.entity.layers.FireflyLayer;
import de.doctorg.fireflies.entity.model.FireflyModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FireflyRenderer extends MobRenderer<FireflyEntity, FireflyModel<FireflyEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(FirefliesMod.MOD_ID, "textures/entity/firefly_body.png");

    public FireflyRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new FireflyModel<>(renderManagerIn.bakeLayer(FireflyModel.LAYER_LOCATION)), 0.1F);
        this.addLayer(new FireflyLayer(this));
        this.shadowRadius = 0;
    }

    @Override
    public ResourceLocation getTextureLocation(FireflyEntity pEntity) {
        return TEXTURE;
    }
}