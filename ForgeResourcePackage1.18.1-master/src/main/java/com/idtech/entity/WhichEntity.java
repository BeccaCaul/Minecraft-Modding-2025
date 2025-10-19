package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestHealableRaiderTargetGoal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class WhichEntity extends Witch {
    private NearestHealableRaiderTargetGoal<Raider> healRaidersGoal;
    //type instance
    public static EntityType<WhichEntity> TYPE = (EntityType<WhichEntity>)
            EntityType.Builder.of(WhichEntity::new, MobCategory.MONSTER)
                    .build("which")
                    .setRegistryName(BaseMod.MODID, "which");
    //egg instance
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xff2a7e, 0xff8fc9);

    //construdctor
    public WhichEntity(EntityType<? extends Witch> type, Level level) {
        super(type, level);
    }
        //attributes
        public static AttributeSupplier.Builder createAttributes() {
            return Monster.createMonsterAttributes()
                    .add(Attributes.MAX_HEALTH, 60F)
                    .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
        }
        //registerGoals method
        @Override
        public void registerGoals() {
            super.registerGoals(); // THIS is important

            this.targetSelector.addGoal(0, new FloatGoal(this));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Villager.class, false));
            this.targetSelector.addGoal(3, new MeleeAttackGoal(this, 0.8f, false));
            this.targetSelector.addGoal(4, (new HurtByTargetGoal(this)).setAlertOthers(Wolf.class));
            this.targetSelector.addGoal(8, new RandomLookAroundGoal(this));
        }

}







