package fr.omega_7711;

import fr.omega_7711.blocks.SecurityCamera;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SECURITY_CAMERA = Registry.register(Registries.BLOCK, new Identifier(TechnoCraft.modId, "security_camera_block"),
            new SecurityCamera(FabricBlockSettings.create().strength(4.0f).requiresTool().nonOpaque()));
}
