package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.animal.Wolf;


public class CustomWolfRenderFactory implements EntityRendererProvider<Wolf> {

    public static CustomWolfRenderFactory INSTANCE = new CustomWolfRenderFactory();

    @Override
    public EntityRenderer<Wolf> create(Context manager) {
        return new CustomWolfRenderer(manager);
    }
}