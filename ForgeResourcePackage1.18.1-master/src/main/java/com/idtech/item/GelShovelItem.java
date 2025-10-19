package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelShovelItem extends ShovelItem {
    public static Tier tier = new ForgeTier(5, 5000, 100.0F, 2.0F, 20, null, ()->{return Ingredient.of(ItemMod.LOVE_ORE);});
    private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);
    public static Item INSTANCE = new GelShovelItem(tier, 2, 200,  properties).setRegistryName(BaseMod.MODID, "gelshovel");
    public GelShovelItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
