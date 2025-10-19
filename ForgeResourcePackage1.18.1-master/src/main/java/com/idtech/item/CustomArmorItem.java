package com.idtech.item;


import com.idtech.BaseMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

//helmet
public class CustomArmorItem extends ArmorItem {
    private static Properties properties = new Properties().tab(CreativeModeTab.TAB_COMBAT);
    //new material
    private static ArmorMaterial customMaterial = ItemUtils.buildArmorMaterial("love", 22, new int[]{5,8,6,4} ,7,  SoundEvents.AMETHYST_BLOCK_CHIME, 4.0f, 0.1f,"examplemod:love");
    public static Item HELM = new CustomArmorItem(customMaterial, EquipmentSlot.HEAD, properties).setRegistryName(BaseMod.MODID,"customhelm");
//chest
    public static final Item CHEST = new CustomArmorItem(customMaterial, EquipmentSlot.CHEST, (properties)).setRegistryName(BaseMod.MODID, "customchest");
 //legs
 public static final Item LEGS = new CustomArmorItem(customMaterial, EquipmentSlot.LEGS, (properties)).setRegistryName(BaseMod.MODID, "customlegs");
  //boots
  public static final Item FEET = new CustomArmorItem(customMaterial, EquipmentSlot.FEET, (properties)).setRegistryName(BaseMod.MODID, "customfeet");
    //constructor
    public CustomArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);

    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            return "examplemod:textures/models/armor/custom_armor_layer_2.png";
        } else {
            return "examplemod:textures/models/armor/custom_armor_layer_1.png";
        }
    }
}
