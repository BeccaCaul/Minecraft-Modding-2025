// ─ MilkBucketProjectile.java ─
package com.idtech.entity;

import net.minecraft.core.particles.ParticleTypes;
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

public class MilkBucketProjectile extends ThrowableItemProjectile {
    public static final String ID = "milk_bucket_projectile";
    public static EntityType<MilkBucketProjectile> TYPE = (EntityType<MilkBucketProjectile>)
            EntityType.Builder.<MilkBucketProjectile>of(
                            (EntityType<MilkBucketProjectile> type, Level level) -> new MilkBucketProjectile(type, level),
                            MobCategory.MISC
                    )
                    .sized(0.25F, 0.25F)
                    .setTrackingRange(64)
                    .setUpdateInterval(10)
                    .build("milk_bucket_projectile")
                    .setRegistryName("examplemod", "milk_bucket_projectile");

    public MilkBucketProjectile(EntityType<? extends MilkBucketProjectile> type, Level level) {
        super(type, level);
    }

    public MilkBucketProjectile(Level level, LivingEntity shooter) {
        super(TYPE, shooter, level);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.MILK_BUCKET;
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
                living.hurt(DamageSource.DROWN, 19);
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
            // Extinguish fire if block is on fire (optional: more complex logic can be added here)
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

