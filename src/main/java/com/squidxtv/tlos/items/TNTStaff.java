package com.squidxtv.tlos.items;

import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class TNTStaff extends Item {


    public TNTStaff(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(!world.isClientSide){
            if(hand == Hand.MAIN_HAND){
                ItemStack tntLauncher = playerEntity.getItemInHand(hand);
                Vector3d pV2 = playerEntity.getLookAngle();
                double spawnX = playerEntity.getX() + (pV2.x * 2);
                double spawnY = playerEntity.getEyeY() + pV2.y;
                double spawnZ = playerEntity.getZ() + (pV2.z*2);
                TNTEntity tntEntity = new TNTEntity(world, spawnX,
                                                           spawnY - 0.5D,
                                                           spawnZ,
                                                           playerEntity);
                world.addFreshEntity(tntEntity);
                tntEntity.push(playerEntity.getLookAngle().x(), playerEntity.getLookAngle().y(), playerEntity.getLookAngle().z());
                tntLauncher.hurtAndBreak(1, playerEntity, (p_220045_0_) -> {
                    p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                });
            }
            return ActionResult.pass(playerEntity.getItemInHand(hand));
        }
        return super.use(world, playerEntity, hand);
    }


}
