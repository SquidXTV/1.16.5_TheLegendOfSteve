package com.squidxtv.tlos.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;


public class PharaohEntity extends MonsterEntity {

    public PharaohEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
    }

    public static AttributeModifierMap.MutableAttribute prepareAttributes(){
        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D);
    }
}
