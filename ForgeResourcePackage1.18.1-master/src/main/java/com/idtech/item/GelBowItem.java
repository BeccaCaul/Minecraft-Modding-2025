package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.entity.EntityMod;
import com.idtech.entity.GelArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GelBowItem extends BowItem {
    private static final Properties properties = new Item.Properties()
            .tab(CreativeModeTab.TAB_COMBAT)
            .durability(768); // standard bow durability

    public static final Item INSTANCE = new GelBowItem(properties).setRegistryName(BaseMod.MODID, "gelbow");

    public GelBowItem(Properties properties) {
        super(properties);
    }
    

}
