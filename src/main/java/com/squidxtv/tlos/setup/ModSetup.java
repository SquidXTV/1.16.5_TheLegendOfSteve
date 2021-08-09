package com.squidxtv.tlos.setup;

import com.squidxtv.tlos.TheLegendOfSteve;
import com.squidxtv.tlos.entity.PharaohEntity;
import com.squidxtv.tlos.network.Networking;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = TheLegendOfSteve.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {
    public static final ItemGroup GROUP = new ItemGroup("tlosGroup")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.HEAL_SPELL.get());
        }
    };

    public static void init(final FMLCommonSetupEvent event){
        Networking.registerMessages();

    }

    @SubscribeEvent
    public static void serverLoad(FMLServerStartingEvent event) {

    }

}
