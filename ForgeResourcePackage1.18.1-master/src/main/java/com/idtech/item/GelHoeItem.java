package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelHoeItem extends HoeItem {
    public static Tier tier = new ForgeTier(5, 5000, 30.0F, 2.0F, 20, null, ()->{return Ingredient.of(ItemMod.LOVE_ORE);});
    private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);
    public static Item INSTANCE = new GelHoeItem(tier, 2, 70,  properties).setRegistryName(BaseMod.MODID, "gelhoe");
    public GelHoeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
