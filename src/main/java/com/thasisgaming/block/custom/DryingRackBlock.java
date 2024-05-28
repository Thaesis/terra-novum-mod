package com.thasisgaming.block.custom;

import com.thasisgaming.block.entity.DryingRackBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.rcon.NetworkDataOutputStream;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkContext;
import net.minecraftforge.network.NetworkInstance;
import net.minecraftforge.network.NetworkRegistry;
import org.jetbrains.annotations.Nullable;

import java.net.NetworkInterface;
import java.nio.channels.NetworkChannel;

public class DryingRackBlock extends BaseEntityBlock {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 32, 16);

    protected DryingRackBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    //Must Override getRenderShape method, otherwise model will be invisible.
    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState1, boolean b) {

        if(blockState.getBlock() != blockState1.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);

            if(blockEntity instanceof DryingRackBlockEntity) {
                ((DryingRackBlockEntity) blockEntity).drops();
            }
        }

        super.onRemove(blockState, level, blockPos, blockState1, b);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if(level.getBlockEntity(blockPos) instanceof DryingRackBlockEntity) {

        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> tBlockEntityType) {
        return super.getTicker(level, blockState, tBlockEntityType);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DryingRackBlockEntity(pos, state);
    }
}