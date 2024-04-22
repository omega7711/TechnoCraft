package fr.omega_7711;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;

import java.nio.file.Path;

public class Utils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static Path getModConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir().resolve(TechnoCraft.modId);
    }
}
