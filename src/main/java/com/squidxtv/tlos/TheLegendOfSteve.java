package com.squidxtv.tlos;

import com.squidxtv.tlos.setup.ClientSetup;
import com.squidxtv.tlos.setup.Config;
import com.squidxtv.tlos.setup.ModSetup;
import com.squidxtv.tlos.setup.Registration;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(TheLegendOfSteve.MODID)
public class TheLegendOfSteve {
    public static final String MODID = "tlos";

    public static final Logger LOGGER = LogManager.getLogger();

    public TheLegendOfSteve()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

        Registration.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }
}


//Mumien, maybe traps