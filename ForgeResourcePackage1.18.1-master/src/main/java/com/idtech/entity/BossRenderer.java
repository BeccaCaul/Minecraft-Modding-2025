package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WitherBossRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.boss.wither.WitherBoss;

public class BossRenderer extends WitherBossRenderer {

    public BossRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }

    @Override
    public ResourceLocation getTextureLocation(WitherBoss entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/boss.png");
    }
}