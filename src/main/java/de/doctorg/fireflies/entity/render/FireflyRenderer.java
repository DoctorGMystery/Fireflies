package de.doctorg.fireflies.entity.render;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.entity.model.FireflyModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;

public class FireflyRenderer extends MobRenderer<FireflyEntity, FireflyModel<FireflyEntity>>
{
    protected static final ResourceLocation LIGHTED =
            new ResourceLocation(FirefliesMod.MOD_ID, "textures/entity/firefly.png");

    protected static final ResourceLocation UNLIGHTED =
            new ResourceLocation(FirefliesMod.MOD_ID, "textures/entity/firefly_unlighted.png");

    public FireflyRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new FireflyModel<>(), 0.2F);
        this.shadowSize = 0;
    }

    @Override
    public ResourceLocation getEntityTexture(FireflyEntity entity) {
        if (entity.getLighted() != null ? entity.getLighted() : true) {
            return LIGHTED;
        } else {
            return UNLIGHTED;
        }
    }
}