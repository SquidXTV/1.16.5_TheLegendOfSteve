package com.squidxtv.tlos.setup;

import com.squidxtv.tlos.TheLegendOfSteve;
import com.squidxtv.tlos.entity.PharaohRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TheLegendOfSteve.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(Registration.PHARAOH.get(), PharaohRenderer::new);
    }

    @SubscribeEvent
    public static void onItemColor(ColorHandlerEvent.Item event) {

    }
}
