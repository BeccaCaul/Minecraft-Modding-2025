package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.boss.wither.WitherBoss;


public class BossRenderFactory implements EntityRendererProvider<WitherBoss> {

    public static BossRenderFactory INSTANCE = new BossRenderFactory();

    @Override
    public EntityRenderer<WitherBoss> create(Context manager) {
        return new BossRenderer(manager);
    }
}