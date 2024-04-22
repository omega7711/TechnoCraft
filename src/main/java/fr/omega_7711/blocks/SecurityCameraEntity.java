package fr.omega_7711.blocks;

import fr.omega_7711.TechnoCraft;
import fr.omega_7711.entities.ModBlockEntities;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtils;

import java.util.UUID;

@Getter@Setter
public class SecurityCameraEntity extends BlockEntity implements GeoBlockEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    String ownername;
    UUID owneruuid;
    public SecurityCameraEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SECURITY_CAMERA_ENTITY,pos, state);
    }
    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putUuid("owneruuid", owneruuid);
        nbt.putString("ownername", ownername);
        super.writeNbt(nbt);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        ownername = nbt.getString("ownername");
        owneruuid = nbt.getUuid("owneruuid");
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, this::deployAnimController));
    }

    protected <E extends SecurityCameraEntity> PlayState deployAnimController(final AnimationState<E> tAnimationState) {
        tAnimationState.getController().setAnimation(RawAnimation.begin().then("move2", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
