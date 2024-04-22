package fr.omega_7711;

import fr.omega_7711.blocks.SecurityCameraEntity;
import fr.omega_7711.blocks.SecurityCameraRenderer;
import fr.omega_7711.entities.ModBlockEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import software.bernie.example.client.renderer.block.GeckoHabitatBlockRenderer;
import software.bernie.example.registry.BlockEntityRegistry;

public class TechnoCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		//BlockEntityRendererFactories.register(ModBlockEntities.SECURITY_CAMERA_ENTITY, SecurityCameraRenderer::new);
		BlockEntityRendererRegistry.register(ModBlockEntities.SECURITY_CAMERA_ENTITY,
				context -> new SecurityCameraRenderer());
	}
}