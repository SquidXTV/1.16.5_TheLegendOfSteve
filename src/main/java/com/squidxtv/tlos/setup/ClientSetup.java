package com.squidxtv.tlos.setup;

import com.squidxtv.tlos.entity.PharaohRenderer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void init(final FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(Registration.PHARAOH.get(), PharaohRenderer::new);
    }

}
