package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.BlazeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WitchRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Witch;

public class WhichRenderer extends WitchRenderer {

    public WhichRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }

    @Override
    public ResourceLocation getTextureLocation(Witch entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/which.png");
    }

}
