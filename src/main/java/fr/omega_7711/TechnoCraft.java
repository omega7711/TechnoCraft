package fr.omega_7711;

import fr.omega_7711.blocks.SecurityCamera;
import fr.omega_7711.blocks.SecurityCameraEntity;
import fr.omega_7711.entities.ModBlockEntities;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

import java.util.*;

public class TechnoCraft implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String modId = "technocraft";
	public static final String modName = "TechnoCraft";
    public static final Logger Logger = LoggerFactory.getLogger(modName);

	//Au lancement de Minecraft
	@Override
	public void onInitialize() {
		Logger.info("Initializing TechnoCraft Mod");
		GeckoLib.initialize();
		Registry.register(Registries.ITEM, new Identifier(modId, "security_camera_item"), new BlockItem(ModBlocks.SECURITY_CAMERA, new FabricItemSettings()));
		ModBlockEntities.registerAllBlockEntities();
	}
}