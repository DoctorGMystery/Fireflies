package de.doctorg.fireflies.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.config.FirefliesConfig;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.entity.model.FireflyModel;
import de.doctorg.fireflies.events.ModEventBusEvents;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FireflyLayer extends RenderLayer<FireflyEntity, FireflyModel<FireflyEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(FirefliesMod.MOD_ID + ":textures/entity/firefly_light.png");

    public FireflyLayer(RenderLayerParent<FireflyEntity, FireflyModel<FireflyEntity>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, FireflyEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (FirefliesConfig.SMOOTH_TEXTURE_FADING.get()) {
            if (pLivingEntity.getLighted()) {
                pLivingEntity.setALPHA(lerp(pLivingEntity.getALPHA(), 1.0F, 0.08F));
            } else {
                pLivingEntity.setALPHA(lerp(pLivingEntity.getALPHA(), 0.0F, 0.08F));
            }
        } else {
            if (pLivingEntity.getLighted()) {
                pLivingEntity.setALPHA(1.0F);
            } else {
                pLivingEntity.setALPHA(0.0F);
            }
        }
        if (!pLivingEntity.isInvisible()) {
            VertexConsumer ivertexbuilder = pBuffer.getBuffer(RenderType.entityTranslucent(TEXTURE));
            this.getParentModel().renderToBuffer(pMatrixStack, ivertexbuilder, pPackedLight, LivingEntityRenderer.getOverlayCoords(pLivingEntity, 0.0F), 1.0F, 1.0F, 1.0F, pLivingEntity.getALPHA());
        }
    }

    float lerp(float a, float b, float f)
    {
        return a + f * (b - a);
    }
}
