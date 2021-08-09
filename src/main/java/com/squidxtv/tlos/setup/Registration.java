package com.squidxtv.tlos.setup;

import com.squidxtv.tlos.entity.PharaohEntity;
import com.squidxtv.tlos.items.HealSpell;
import com.squidxtv.tlos.items.StrengthSpell;
import com.squidxtv.tlos.items.TNTStaff;
import com.squidxtv.tlos.items.TheLegendOfSteveSpawnEgg;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.squidxtv.tlos.TheLegendOfSteve.MODID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MODID)
public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    public static void init(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items:
    public static final Food TankApple = (new Food.Builder()).nutrition(4).saturationMod(0.3F).effect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 1200, 0), 1.0F).alwaysEat().build();
    public static final Food EnergyDrink = (new Food.Builder()).nutrition(0).saturationMod(0.0F).effect(new EffectInstance(Effects.MOVEMENT_SPEED, 1200, 0), 1.0F).effect(new EffectInstance(Effects.DIG_SPEED, 1200, 0), 1.0F).alwaysEat().build();

    public static final RegistryObject<TNTStaff> TNT_LAUNCHER = ITEMS.register("tnt_launcher", () ->
            new TNTStaff(new Item.Properties().tab(ModSetup.GROUP).stacksTo(1).durability(128)));

    public static final RegistryObject<Item> TANK_APPLE = ITEMS.register("tank_apple", () ->
            new Item(new Item.Properties().tab(ModSetup.GROUP).food(TankApple)));
    public static final RegistryObject<Item> ENERGY_DRINK = ITEMS.register("energy_drink", () ->
            new Item(new Item.Properties().tab(ModSetup.GROUP).food(EnergyDrink)));

    public static final RegistryObject<HealSpell> HEAL_SPELL = ITEMS.register("heal_spell", () ->
            new HealSpell(new Item.Properties().tab(ModSetup.GROUP).stacksTo(1).durability(10)));
    public static final RegistryObject<StrengthSpell> STRENGTH_SPELL = ITEMS.register("strength_spell", () ->
            new StrengthSpell(new Item.Properties().tab(ModSetup.GROUP).stacksTo(1).durability(10)));

    //BlockItems:
    public static final RegistryObject<BlockItem> TNTX8ITEM = ITEMS.register("tntx8", () ->
            new BlockItem(Registration.TNTX8.get(), new Item.Properties().tab(ModSetup.GROUP)));
    public static final RegistryObject<BlockItem> TNTX64ITEM = ITEMS.register("tntx64", () ->
            new BlockItem(Registration.TNTX64.get(), new Item.Properties().tab(ModSetup.GROUP)));

    //Blocks:
    public static final RegistryObject<Block> TNTX8 = BLOCKS.register("tntx8", () ->
            new Block(AbstractBlock.Properties.of(Material.METAL).instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> TNTX64 = BLOCKS.register("tntx64", () ->
            new Block(AbstractBlock.Properties.of(Material.METAL).instabreak().sound(SoundType.GRASS)));

    //Entities:
    public static final RegistryObject<EntityType<PharaohEntity>> PHARAOH = ENTITIES.register("pharaoh", () -> EntityType.Builder.of(PharaohEntity::new, EntityClassification.MONSTER)
            .sized(.6F, 2.1F).build("pharaoh"));
    public static final RegistryObject<Item> PHARAOH_SPAWN_EGG = ITEMS.register("pharaoh_spawn_egg", () -> new TheLegendOfSteveSpawnEgg(new Item.Properties().tab(ModSetup.GROUP).stacksTo(1), PHARAOH::get, 1575190, 6031692));


    @SubscribeEvent
    public static void attributes(EntityAttributeCreationEvent e) {
        e.put(Registration.PHARAOH.get(), PharaohEntity.prepareAttributes().build());
    }
}
