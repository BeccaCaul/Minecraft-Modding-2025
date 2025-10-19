package com.idtech.item;

import com.idtech.entity.MilkBucketProjectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MilkGunItem extends Item {
    public MilkGunItem(Properties props) {
        super(props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            MilkBucketProjectile proj = new MilkBucketProjectile(level, player);
            proj.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.6F, 1.0F);
            level.addFreshEntity(proj);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.COW_MILK, SoundSource.PLAYERS, 0.5F, 1.0F);

        stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }
}
