package com.idtech.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class EntityMod {


    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
        event.getRegistry().register(MilkBucketProjectile.TYPE);
        //Wolf
       event.getRegistry().register(CustomWolfEntity.TYPE);
       //wither
        event.getRegistry().register(BossEntity.TYPE);
    }

    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(WhichEntity.EGG);
        //wolf
       event.getRegistry().register(CustomWolfEntity.EGG);
       //boss
        event.getRegistry().register(BossEntity.EGG);
    }



    @SubscribeEvent
    public static void entityRenderers(final EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(WhichEntity.TYPE, WhichRenderFactory.INSTANCE);
        event.registerEntityRenderer(MilkBucketProjectile.TYPE,
                ctx -> new ThrownItemRenderer<>(ctx, 1.0f, false));
   //wolf
       event.registerEntityRenderer(CustomWolfEntity.TYPE, CustomWolfRenderFactory.INSTANCE);
       //boss
        event.registerEntityRenderer(BossEntity.TYPE, BossRenderFactory.INSTANCE);

    }


    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(WhichEntity.TYPE, WhichEntity.createAttributes().build());
      event.put(CustomWolfEntity.TYPE, CustomWolfEntity.createAttributes().build());
      //boss
        event.put(BossEntity.TYPE, BossEntity.createAttributes().build());

    }
}
