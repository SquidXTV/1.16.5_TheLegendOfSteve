package com.squidxtv.tlos.entity;

import com.squidxtv.tlos.TheLegendOfSteve;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class PharaohRenderer extends BipedRenderer<PharaohEntity, PharaohModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TheLegendOfSteve.MODID, "textures/entity/pharaoh/pharaoh.png");

    public PharaohRenderer(EntityRendererManager p_i46168_1_) {
        super(p_i46168_1_, new PharaohModel(0.0F,false), 0.5F);
    }


    @Override
    public ResourceLocation getTextureLocation(PharaohEntity pEntity) {
        return TEXTURE;
    }
}
