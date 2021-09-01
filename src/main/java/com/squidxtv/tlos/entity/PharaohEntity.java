package com.squidxtv.tlos.entity;

import com.squidxtv.tlos.entity.ai.RightClickAttackGoal;
import com.squidxtv.tlos.setup.Registration;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;


public class PharaohEntity extends MonsterEntity {



    public PharaohEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
        this.reassessWeaponGoal();
    }

    public static AttributeModifierMap.MutableAttribute prepareAttributes(){
        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 80.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance p_180481_1_) {
        super.populateDefaultEquipmentSlots(p_180481_1_);
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Registration.SUMMON_STAFF.get()));
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficultyInstance, SpawnReason spawnReason, @Nullable ILivingEntityData livingEntityData, @Nullable CompoundNBT compoundNBT) {
        this.populateDefaultEquipmentSlots(difficultyInstance);
        this.reassessWeaponGoal();
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, compoundNBT);
    }

    public void reassessWeaponGoal() {
        if(this.level != null && !this.level.isClientSide){
            //this.goalSelector.removeGoal(rightClickGoal);
            ItemStack itemStack = this.getItemInHand(ProjectileHelper.getWeaponHoldingHand(this, item -> item instanceof com.squidxtv.tlos.items.SummonStaff));
            if(itemStack.getItem() == (Registration.SUMMON_STAFF.get())){

                //this.goalSelector.addGoal(4, this.rightClickGoal);
            }
        }
    }
}
