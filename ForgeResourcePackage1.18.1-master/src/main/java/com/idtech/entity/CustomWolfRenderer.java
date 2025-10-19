package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;

public class CustomWolfRenderer extends WolfRenderer {

    public CustomWolfRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }

    @Override
    public ResourceLocation getTextureLocation(Wolf entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/customwolf.png");
    }
}