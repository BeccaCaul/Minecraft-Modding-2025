package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Witch;


public class WhichRenderFactory implements EntityRendererProvider<Witch> {

    public static WhichRenderFactory INSTANCE = new WhichRenderFactory();

    @Override
    public EntityRenderer<Witch> create(Context manager) {
        return new WhichRenderer(manager);
    }
}