package com.squidxtv.tlos.items;


import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;

public class EnergyDrink extends Item {
    public static final Food EnergyDrinkFood = (new Food.Builder()).nutrition(0).saturationMod(0.0F).effect(new EffectInstance(Effects.MOVEMENT_SPEED, 1200, 0), 1.0F).effect(new EffectInstance(Effects.DIG_SPEED, 1200, 0), 1.0F).alwaysEat().build();


    public EnergyDrink(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public SoundEvent getEatingSound() {
        return super.getDrinkingSound();
    }
}
