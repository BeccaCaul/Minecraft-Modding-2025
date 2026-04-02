package com.idtech.item;

import com.idtech.entity.WaterBucketProjectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class WaterGunItem extends Item {
    public WaterGunItem(Properties props) {
        super(props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // Check if the player has a water bucket in their inventory
        if (!player.getInventory().contains(new ItemStack(Items.WATER_BUCKET))) {
            return InteractionResultHolder.fail(stack);
        }

        if (!level.isClientSide) {
            // Remove one water bucket from inventory
            player.getInventory().clearOrCountMatchingItems(
                    item -> item.is(Items.WATER_BUCKET), 1, player.inventoryMenu.getCraftSlots()
            );

            // Give the player an empty bucket back
            player.getInventory().add(new ItemStack(Items.BUCKET));

            WaterBucketProjectile proj = new WaterBucketProjectile(level, player);
            proj.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.6F, 1.0F);
            level.addFreshEntity(proj);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.AMBIENT_UNDERWATER_ENTER, SoundSource.PLAYERS, 0.5F, 1.0F);

        stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }
}