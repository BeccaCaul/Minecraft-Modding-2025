package com.idtech.entity;

import com.idtech.item.BombArrowItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class BombArrow extends AbstractArrow
{
    public BombArrow(Level levelIn, LivingEntity entityIn)
    {
        super(EntityType.ARROW, entityIn, levelIn);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(BombArrowItem.INSTANCE);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        Vec3 loc = result.getLocation();

        if (level.isClientSide) { // Note: now checking client side!
            for (int i = 0; i < 50; i++) {
                double dx = (random.nextDouble() - 0.5) * 0.5;
                double dy = (random.nextDouble() - 0.5) * 0.5;
                double dz = (random.nextDouble() - 0.5) * 0.5;
                level.addParticle(ParticleTypes.DRAGON_BREATH, loc.x, loc.y, loc.z, dx, dy, dz);
            }
        }
    }
}