package com.idtech.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemMod {

    //BASIC ITEMS
    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", CreativeModeTab.TAB_MISC);
    public static final Item GEL_ORE = ItemUtils.buildBasicItem("gelore", CreativeModeTab.TAB_MISC);
    public static final Item WAMY_ORE = ItemUtils.buildBasicItem("wamy", CreativeModeTab.TAB_MISC);
    public static final Item LOVE_ORE = ItemUtils.buildBasicItem("love", CreativeModeTab.TAB_MISC);

    //FOODS
    public static FoodProperties yummyFood = (new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(1.4f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1000, 3), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 2), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0f)
            .alwaysEat()
            .build());
    public static Item yummyFoodItem = ItemUtils.buildFoodItem("sushi", yummyFood);

    public static final Item MILK_GUN = new MilkGunItem(new Item.Properties()
            .stacksTo(1)
            .durability(250)
            .tab(net.minecraft.world.item.CreativeModeTab.TAB_COMBAT))
            .setRegistryName("idtech", "water_gun");


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        event.getRegistry().register(STRUCTURE_GEL);
        event.getRegistry().register(GEL_ORE);
        event.getRegistry().register(WAMY_ORE);
        event.getRegistry().register(LOVE_ORE);


        // ITEMS
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        event.getRegistry().register(GelPickaxeItem.INSTANCE);
        event.getRegistry().register(GelSwordItem.INSTANCE);
        event.getRegistry().register(GelHoeItem.INSTANCE);
        event.getRegistry().register(GelShovelItem.INSTANCE);
        event.getRegistry().register(GelAxeItem.INSTANCE);
        // TOOLS

        // FOOD
        event.getRegistry().register(yummyFoodItem);
        // ARMOR
        event.getRegistry().register(CustomArmorItem.HELM);
        event.getRegistry().register(CustomArmorItem.CHEST);
        event.getRegistry().register(CustomArmorItem.LEGS);
        event.getRegistry().register(CustomArmorItem.FEET);

        event.getRegistry().register(MILK_GUN);


        // MILK GUN


        //bow
        event.getRegistry().register(GelBowItem.INSTANCE);

        //gel arrow
        event.getRegistry().register(GelArrowItem.INSTANCE);
        event.getRegistry().register(BombArrowItem.INSTANCE);

    }
}
