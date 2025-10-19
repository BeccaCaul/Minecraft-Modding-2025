package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class CreepingMoldBlock extends Block {
    private static Properties properties = Properties.of(Material.STONE).randomTicks();

    public static Block INSTANCE = new CreepingMoldBlock(properties).setRegistryName(BaseMod.MODID, "creepingmold");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, CreativeModeTab.TAB_MISC);

    public CreepingMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, Random random) {
        super.randomTick(blockState, serverLevel, pos, random);
        BlockPos blockPos = Utils.findNeightborBlock(pos);

        if (blockPos != null) {
            serverLevel.setBlockAndUpdate(blockPos, this.defaultBlockState());
        }
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(world, pos, state, entity);

        if (!world.isClientSide && entity instanceof LivingEntity livingEntity) {
            // Option 1: Poison the entity
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0)); // 3 seconds, amplifier 0

            // Option 2: Damage like a cactus
             entity.hurt(DamageSource.CACTUS, 1.0F);
        }
    }
}