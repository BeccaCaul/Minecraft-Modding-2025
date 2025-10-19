package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelPickaxeItem extends PickaxeItem {
    public static Tier tier = new ForgeTier(5, 5000, 60.0F, 2.0F, 20, null, ()->{return Ingredient.of(ItemMod.LOVE_ORE);});
    private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);
    public static Item INSTANCE = new GelPickaxeItem(tier, 2, 100,  properties).setRegistryName(BaseMod.MODID, "gelpickaxe");
    public GelPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }
}
