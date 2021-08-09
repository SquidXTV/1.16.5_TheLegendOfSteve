package com.squidxtv.tlos.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class StrengthSpell extends Item {
    int effectTime;
    private final String hoverText = "This Item will give you Strength for 1 Minute";
    private final String hoverText2 = "per right click, effect will stack, 10 uses!";

    public StrengthSpell(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(!world.isClientSide()){
            if(hand == Hand.MAIN_HAND || hand == Hand.OFF_HAND){
                ItemStack StrengthSpell = playerEntity.getItemInHand(hand);

                if(playerEntity.hasEffect(Effects.DAMAGE_BOOST)){
                    effectTime = playerEntity.getEffect(Effects.DAMAGE_BOOST).getDuration();
                    effectTime += 1200;
                    playerEntity.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, effectTime));
                } else {
                    effectTime = 1200;
                    playerEntity.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, effectTime));
                }
                StrengthSpell.hurtAndBreak(1, playerEntity, (x) -> {
                    x.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                });
            }
            return ActionResult.pass(playerEntity.getItemInHand(hand));
        }

        return super.use(world, playerEntity, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable World world, List<ITextComponent> list, ITooltipFlag iTooltipFlag) {
        list.add(new TranslationTextComponent(hoverText, itemStack.getDisplayName()).withStyle(TextFormatting.GRAY));
        list.add(new TranslationTextComponent(hoverText2, itemStack.getDisplayName()).withStyle(TextFormatting.GRAY));
        super.appendHoverText(itemStack, world, list, iTooltipFlag);
    }
}
