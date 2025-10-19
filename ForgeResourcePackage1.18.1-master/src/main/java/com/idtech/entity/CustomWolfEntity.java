package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class CustomWolfEntity extends Wolf {
    public CustomWolfEntity(EntityType<? extends Wolf> type, Level level) {
        super(type, level);
    }
    public static EntityType<CustomWolfEntity> TYPE = (EntityType<CustomWolfEntity>)
            EntityType.Builder.of(CustomWolfEntity::new, MobCategory.MISC)
                    .build("customwolf")
                    .setRegistryName(BaseMod.MODID, "customwolf");

    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);

    public static AttributeSupplier.Builder createAttributes() {
        return Wolf.createAttributes().add(Attributes.MAX_HEALTH, 200.0D)
                .add(Attributes.MOVEMENT_SPEED, 15.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D);
    }
}