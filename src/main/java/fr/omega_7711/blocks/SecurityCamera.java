package fr.omega_7711.blocks;

import com.mojang.serialization.MapCodec;
import fr.omega_7711.TechnoCraft;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SecurityCamera extends BlockWithEntity implements BlockEntityProvider, GeoAnimatable {
    public SecurityCamera(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if(placer instanceof PlayerEntity player) {
            if (!world.isClient) {
                player.sendMessage(Text.literal("Your Security Camera has been placed to location: " + pos), false);
                SecurityCameraEntity sce = (SecurityCameraEntity) world.getBlockEntity(pos);
                assert sce != null;
                sce.setOwnername(player.getName().toString());
                sce.setOwneruuid(player.getUuid());
                sce.writeNbt(new NbtCompound());
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient) {
            SecurityCameraEntity sce = (SecurityCameraEntity) world.getBlockEntity(pos);
            assert sce != null;
            player.sendMessage(Text.literal("This is the camera of " + sce.getOwnername()), false);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        //return VoxelShapes.cuboid(new Box(0.3125f, 0f, 0.f, 0.3125f, 1f, 0f));
        return super.getCollisionShape(state, world, pos, context);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(new Box(0.3125f, 0f, 0.f, 0.3125f, 0.6875f, 1f));
        //return VoxelShapes.empty();
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SecurityCameraEntity(pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }

    @Override
    public double getTick(Object object) {
        return 0;
    }
}
