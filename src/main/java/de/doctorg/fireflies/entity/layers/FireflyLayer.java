package de.doctorg.fireflies.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.config.FirefliesConfig;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.entity.model.FireflyModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FireflyLayer extends LayerRenderer<FireflyEntity, FireflyModel<FireflyEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(FirefliesMod.MOD_ID + ":textures/entity/firefly_light.png");

    public FireflyLayer(IEntityRenderer<FireflyEntity, FireflyModel<FireflyEntity>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, FireflyEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (FirefliesConfig.SMOOTH_TEXTURE_FADING.get()) {
            if (entitylivingbaseIn.getLighted()) {
                entitylivingbaseIn.setALPHA(lerp(entitylivingbaseIn.getALPHA(), 1.0F, 0.08F));
            } else {
                entitylivingbaseIn.setALPHA(lerp(entitylivingbaseIn.getALPHA(), 0.0F, 0.08F));
            }
        } else {
            if (entitylivingbaseIn.getLighted()) {
                entitylivingbaseIn.setALPHA(1.0F);
            } else {
                entitylivingbaseIn.setALPHA(0.0F);
            }
        }
        if (!entitylivingbaseIn.isInvisible()) {
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(TEXTURE));
            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F), 1.0F, 1.0F, 1.0F, entitylivingbaseIn.getALPHA());
        }
    }

    float lerp(float a, float b, float f)
    {
        return a + f * (b - a);
    }
}
