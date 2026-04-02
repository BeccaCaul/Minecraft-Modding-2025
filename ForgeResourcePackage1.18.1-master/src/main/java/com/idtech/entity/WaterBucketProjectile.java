// ─ WaterBucketProjectile.java ─
package com.idtech.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class WaterBucketProjectile extends ThrowableItemProjectile {
    public static final String ID = "water_bucket_projectile";
    public static EntityType<WaterBucketProjectile> TYPE = (EntityType<WaterBucketProjectile>)
            EntityType.Builder.<WaterBucketProjectile>of(
                            (EntityType<WaterBucketProjectile> type, Level level) -> new WaterBucketProjectile(type, level),
                            MobCategory.MISC
                    )
                    .sized(0.25F, 0.25F)
                    .setTrackingRange(64)
                    .setUpdateInterval(10)
                    .build("water_bucket_projectile")
                    .setRegistryName("examplemod", "water_bucket_projectile");

    public WaterBucketProjectile(EntityType<? extends WaterBucketProjectile> type, Level level) {
        super(type, level);
    }

    public WaterBucketProjectile(Level level, LivingEntity shooter) {
        super(TYPE, shooter, level);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.WATER_BUCKET;
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    // Called when this projectile hits an entity
    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        Entity target = result.getEntity();

        if (!level.isClientSide) {
            // Extinguish fire on the target
            target.clearFire();

            // If target is a living entity, apply slowness effect for 3 seconds (60 ticks)
            if (target instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
                living.hurt(DamageSource.DROWN, 5);
            }

            // Remove the projectile after hitting
            this.discard();
        }
    }

    // Called when this projectile hits a block
    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        if (!level.isClientSide) {
            BlockState state = level.getBlockState(result.getBlockPos());
            // Extinguish fire if block is on fire
            if (state.getBlock().isBurning(state, level, result.getBlockPos())) {
                level.removeBlock(result.getBlockPos(), false);
            }

            // Spawn splash particles at the hit location
            for (int i = 0; i < 10; i++) {
                double offsetX = (level.random.nextDouble() - 0.5) * 0.4;
                double offsetY = (level.random.nextDouble() - 0.5) * 0.4;
                double offsetZ = (level.random.nextDouble() - 0.5) * 0.4;
                level.addParticle(
                        net.minecraft.core.particles.ParticleTypes.SPLASH,
                        result.getLocation().x + offsetX,
                        result.getLocation().y + offsetY,
                        result.getLocation().z + offsetZ,
                        0, 0, 0 // no speed
                );
            }

            // Remove the projectile on block hit
            this.discard();
        }
    }
}