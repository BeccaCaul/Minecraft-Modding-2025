package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelAxeItem extends AxeItem {
    public static Tier tier = new ForgeTier(5, 5000, 60.0F, 2.0F, 20, null, ()->{return Ingredient.of(ItemMod.LOVE_ORE);});
    private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);
    public static Item INSTANCE = new GelAxeItem(tier, 2, 70,  properties).setRegistryName(BaseMod.MODID, "gelaxe");
    public GelAxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }

    // className.methodName(parameters)
}