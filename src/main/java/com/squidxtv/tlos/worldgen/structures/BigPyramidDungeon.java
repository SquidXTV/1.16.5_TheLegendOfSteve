package com.squidxtv.tlos.worldgen.structures;

import com.mojang.serialization.Codec;
import com.squidxtv.tlos.TheLegendOfSteve;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;

//TODO: https://www.youtube.com/watch?v=umhuRXinD3o, https://github.com/TelepathicGrunt/StructureTutorialMod
//You can add the chest later or add it in right now. The command Sak showed is how to properly make chests generate their own loot the first time they are opened.
// Once you set a chest down with a loot table, do not open it before you save the structure piece to nbt as once it is opened,
// it gets rid of the loot table part and tries to generate loot from it

public class BigPyramidDungeon extends Structure<NoFeatureConfig> {

    public BigPyramidDungeon(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return BigPyramidDungeon.Start::new;
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    @Override
    public Structure<?> getStructure() {
        return super.getStructure();
    }

    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return super.getDefaultSpawnList();
    }

    @Override
    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
        return super.getDefaultCreatureSpawnList();
    }

    @Override
    public boolean getDefaultRestrictsSpawnsToInside() {
        return super.getDefaultRestrictsSpawnsToInside();
    }



    public static class Start extends StructureStart<NoFeatureConfig>  {
        public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, mutableBoundingBox, reference, seed);
        }

        @Override
        public void generatePieces(DynamicRegistries dynamicRegistries, ChunkGenerator chunkGenerator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) {
            /*
            int x = chunkX * 16;
            int z = chunkZ * 16;

            BlockPos centerPos = new BlockPos(x, 0, z);


            JigsawManager.addPieces(
                    dynamicRegistries,
                    new VillageConfig(() -> dynamicRegistries.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)

                            .get(new ResourceLocation(TheLegendOfSteve.MOD_ID, "big_pyramid_dungeon/")),
                            10),

                    AbstractVillagePiece::new,
                    chunkGenerator,
                    templateManager,
                    centerPos,
                    this.pieces,
                    this.random,
                    false,
                    true);


            );

             */
        }
    }
}
