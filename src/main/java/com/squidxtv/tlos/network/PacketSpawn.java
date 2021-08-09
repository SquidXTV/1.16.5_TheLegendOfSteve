package com.squidxtv.tlos.network;

import com.mojang.serialization.Dynamic;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class PacketSpawn {

    private final ResourceLocation id;
    private final BlockPos pos;

    public PacketSpawn(PacketBuffer buf) {
        id = buf.readResourceLocation();
        pos = buf.readBlockPos();
    }

    public PacketSpawn(ResourceLocation id, DimensionType type, BlockPos pos) {
        this.id = id;
        this.pos = pos;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeResourceLocation(id);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            EntityType<?> entityType = ForgeRegistries.ENTITIES.getValue(id);
            if (entityType == null) {
                throw new IllegalStateException("This cannot happen! Unknown id '" + id.toString() + "'!");
            }
        });
        return true;
    }

}
