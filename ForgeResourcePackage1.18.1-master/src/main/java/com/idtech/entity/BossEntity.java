package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class BossEntity extends WitherBoss{
    public BossEntity(EntityType<? extends WitherBoss> type, Level level) {
        super(type, level);
    }
    public static EntityType<BossEntity> TYPE = (EntityType<BossEntity>)
            EntityType.Builder.of(BossEntity::new, MobCategory.MONSTER)
                    .build("boss")
                    .setRegistryName(BaseMod.MODID, "boss");

    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);

    public static AttributeSupplier.Builder createAttributes() {
        return WitherBoss.createMonsterAttributes().add(Attributes.MAX_HEALTH, 300.0).add(Attributes.MOVEMENT_SPEED, 0.6000000238418579).add(Attributes.FLYING_SPEED, 0.6000000238418579).add(Attributes.FOLLOW_RANGE, 40.0).add(Attributes.ARMOR, 4.0);
    }
}