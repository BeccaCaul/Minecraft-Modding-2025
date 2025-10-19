package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelSwordItem extends SwordItem {
    public static Tier tier = new ForgeTier(5, 5000, 50.0F, 10.0F, 20, null, ()->{return Ingredient.of(ItemMod.LOVE_ORE);});
    private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_COMBAT);
    public static Item INSTANCE = new GelSwordItem(tier, 40, 100,  properties).setRegistryName(BaseMod.MODID, "gelsword");
    public GelSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
