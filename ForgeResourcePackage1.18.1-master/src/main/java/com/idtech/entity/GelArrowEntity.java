package com.idtech.entity;

import com.idtech.item.GelArrowItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class GelArrowEntity extends AbstractArrow {

    // Constructors matching your pattern
    public GelArrowEntity(Level level, LivingEntity entityIn) {
        super(EntityType.ARROW, entityIn, level);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(GelArrowItem.INSTANCE);
    }
}
