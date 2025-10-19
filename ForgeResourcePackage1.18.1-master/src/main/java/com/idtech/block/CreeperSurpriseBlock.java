package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;

public class CreeperSurpriseBlock extends Block {
    private static Properties properties = Properties.of(Material.STONE);
    public static Block INSTANCE = new CreeperSurpriseBlock(properties).setRegistryName(BaseMod.MODID, "creepersurprise");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, CreativeModeTab.TAB_MISC);
    //constructor
    public CreeperSurpriseBlock(Properties properties){
        super(properties);
    }
    //block destroy
    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(level, player, pos, blockState, blockEntity, stack);
        //spawn creeper
        Cat cat = new Cat(EntityType.CAT, level);
        Utils.spawnEntity(level, cat, pos);

    }
}
