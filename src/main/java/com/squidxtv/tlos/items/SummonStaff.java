package com.squidxtv.tlos.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SummonStaff extends Item {
    int skeletonCount = 0;
    int zombieCount = 0;

    public SummonStaff(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(!world.isClientSide){
            if(hand == Hand.MAIN_HAND){
                skeletonCount += 1;
                zombieCount += 1;

                ItemStack summonStaff = playerEntity.getItemInHand(hand);

                Vector3d pV2 = playerEntity.getLookAngle();
                double spawnX = playerEntity.getX() + (pV2.x * 2);
                double spawnY = playerEntity.getEyeY() + pV2.y;
                double spawnZ = playerEntity.getZ() + (pV2.z*2);
                ZombieEntity zombieEntity = new ZombieEntity(world);
                zombieEntity.setPos(spawnX, spawnY, spawnZ);

                spawnX += .5F;
                spawnZ += .5F;
                SkeletonEntity skeletonEntity = new SkeletonEntity(EntityType.SKELETON, world);
                skeletonEntity.setPos(spawnX, spawnY, spawnZ);

                skeletonEntity.setCustomName(new TranslationTextComponent("Sniper Nr." + skeletonCount));
                zombieEntity.setCustomName(new TranslationTextComponent("Bodyguard Nr." + zombieCount));

                world.addFreshEntity(zombieEntity);
                world.addFreshEntity(skeletonEntity);

                summonStaff.hurtAndBreak(1, playerEntity, (p_220045_0_) -> {
                    p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                });
            }
            return ActionResult.pass(playerEntity.getItemInHand(hand));
        }
        return super.use(world, playerEntity, hand);
    }

}
