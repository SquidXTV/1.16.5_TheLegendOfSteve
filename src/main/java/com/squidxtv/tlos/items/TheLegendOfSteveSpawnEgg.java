package com.squidxtv.tlos.items;

import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.function.Supplier;

public class TheLegendOfSteveSpawnEgg extends SpawnEggItem {

    public static final ArrayList<TheLegendOfSteveSpawnEgg> THE_LEGEND_OF_STEVE_EGGS = new ArrayList<>();

    public int primColor;
    public int secColor;

    Supplier<? extends EntityType<?>> type;
    public TheLegendOfSteveSpawnEgg(Properties builder, Supplier<? extends EntityType<?>> typeIn, int primaryColorIn, int secondaryColorIn) {
        super(null, primaryColorIn, secondaryColorIn, builder);
        type = typeIn;
        primColor = primaryColorIn;
        secColor = secondaryColorIn;
        THE_LEGEND_OF_STEVE_EGGS.add(this);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT p_208076_1_) {
        return type.get();
    }
}
