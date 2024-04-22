package fr.omega_7711.mixin;

import fr.omega_7711.Utils;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class Injector {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {

	}
}