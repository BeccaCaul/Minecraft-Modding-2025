package com.idtech.item;

import com.idtech.entity.GelArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GelArrowItem extends ArrowItem {
    private static final Properties properties = new Properties().tab(CreativeModeTab.TAB_MISC);

    public GelArrowItem(Properties properties) {
        super(properties);
    }

    public static final Item INSTANCE = new GelArrowItem(properties).setRegistryName("gelarrow");

    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
        return new GelArrowEntity(level, shooter);
    }
}
