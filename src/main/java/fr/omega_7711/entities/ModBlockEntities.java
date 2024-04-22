package fr.omega_7711.entities;

import fr.omega_7711.ModBlocks;
import fr.omega_7711.TechnoCraft;
import fr.omega_7711.blocks.SecurityCameraEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<SecurityCameraEntity> SECURITY_CAMERA_ENTITY;
    public static void registerAllBlockEntities() {
        SECURITY_CAMERA_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(TechnoCraft.modId, "security_camera_entity"),
                FabricBlockEntityTypeBuilder.create(SecurityCameraEntity::new, ModBlocks.SECURITY_CAMERA).build());
    }
}
