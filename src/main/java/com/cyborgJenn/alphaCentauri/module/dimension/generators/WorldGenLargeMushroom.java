package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLargeMushroom extends WorldGenerator 
{
    private final Block mushroomType;
    
	public WorldGenLargeMushroom(Block blockIn)
	{
		super(true);// Triggers block to notify neighbors on generate, in superclass. 
        this.mushroomType = blockIn;
	}
	public WorldGenLargeMushroom()
    {
        super(false);
        this.mushroomType = null;
    }
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) 
	{
		Block block = this.mushroomType;

        if (block == null)
        {
            block = rand.nextBoolean() ? ModBlocks.BLOCK_MUSHROOM_BLUE : ModBlocks.BLOCK_MUSHROOM_PURPLE;//TODO change to another mushroom type.
        }

        int i = rand.nextInt(4) + 7;

        if (rand.nextInt(12) == 0)
        {
            i *= 2;
        }

        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + i + 1 < 256)
        {
            for (int j = position.getY(); j <= position.getY() + 1 + i; ++j)
            {
                int k = 3;

                if (j <= position.getY() + 3)
                {
                    k = 0;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l)
                {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            IBlockState state = worldIn.getBlockState(blockpos$mutableblockpos.setPos(l, j, i1));

                            if (!state.getBlock().isAir(state, worldIn, blockpos$mutableblockpos) && !state.getBlock().isLeaves(state, worldIn, blockpos$mutableblockpos))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block1 = worldIn.getBlockState(position.down()).getBlock();

                if (block1 != ModBlocks.acDirt && block1 != ModBlocks.acGrass && block1 != ModBlocks.FUNGUS)
                {
                    return false;
                }
                else
                {
                    int k2 = position.getY() + i;

                    if (block == ModBlocks.BLOCK_MUSHROOM_PURPLE)
                    {
                        k2 = position.getY() + i - 3;
                    }

                    for (int l2 = k2; l2 <= position.getY() + i; ++l2)
                    {
                        int j3 = 1;

                        if (l2 < position.getY() + i)
                        {
                            ++j3;
                        }

                        if (block == ModBlocks.BLOCK_MUSHROOM_BLUE)
                        {
                            j3 = 3;
                        }

                        int k3 = position.getX() - j3;
                        int l3 = position.getX() + j3;
                        int j1 = position.getZ() - j3;
                        int k1 = position.getZ() + j3;

                        for (int l1 = k3; l1 <= l3; ++l1)
                        {
                            for (int i2 = j1; i2 <= k1; ++i2)
                            {
                                int j2 = 5;

                                if (l1 == k3)
                                {
                                    --j2;
                                }
                                else if (l1 == l3)
                                {
                                    ++j2;
                                }

                                if (i2 == j1)
                                {
                                    j2 -= 3;
                                }
                                else if (i2 == k1)
                                {
                                    j2 += 3;
                                }

                                BlockHugeMushroom.EnumType blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.byMetadata(j2);

                                if (block == ModBlocks.BLOCK_MUSHROOM_BLUE || l2 < position.getY() + i)
                                {
                                    if ((l1 == k3 || l1 == l3) && (i2 == j1 || i2 == k1))
                                    {
                                        continue;
                                    }

                                    if (l1 == position.getX() - (j3 - 1) && i2 == j1)
                                    {
                                        blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.NORTH_WEST;
                                    }

                                    if (l1 == k3 && i2 == position.getZ() - (j3 - 1))
                                    {
                                        blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.NORTH_WEST;
                                    }

                                    if (l1 == position.getX() + (j3 - 1) && i2 == j1)
                                    {
                                        blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.NORTH_EAST;
                                    }

                                    if (l1 == l3 && i2 == position.getZ() - (j3 - 1))
                                    {
                                        blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.NORTH_EAST;
                                    }

                                    if (l1 == position.getX() - (j3 - 1) && i2 == k1)
                                    {
                                        blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.SOUTH_WEST;
                                    }

                                    if (l1 == k3 && i2 == position.getZ() + (j3 - 1))
                                    {
                                        blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.SOUTH_WEST;
                                    }

                                    if (l1 == position.getX() + (j3 - 1) && i2 == k1)
                                    {
                                        blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.SOUTH_EAST;
                                    }

                                    if (l1 == l3 && i2 == position.getZ() + (j3 - 1))
                                    {
                                        blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.SOUTH_EAST;
                                    }
                                }

                                if (blockhugemushroom$enumtype == BlockHugeMushroom.EnumType.CENTER && l2 < position.getY() + i)
                                {
                                    blockhugemushroom$enumtype = BlockHugeMushroom.EnumType.ALL_INSIDE;
                                }

                                if (position.getY() >= position.getY() + i - 1 || blockhugemushroom$enumtype != BlockHugeMushroom.EnumType.ALL_INSIDE)
                                {
                                    BlockPos blockpos = new BlockPos(l1, l2, i2);
                                    IBlockState state = worldIn.getBlockState(blockpos);

                                    if (state.getBlock().canBeReplacedByLeaves(state, worldIn, blockpos))
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, block.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, blockhugemushroom$enumtype));
                                    }
                                }
                            }
                        }
                    }

                    for (int i3 = 0; i3 < i; ++i3)
                    {
                        IBlockState iblockstate = worldIn.getBlockState(position.up(i3));

                        if (iblockstate.getBlock().canBeReplacedByLeaves(iblockstate, worldIn, position.up(i3)))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(i3), block.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, BlockHugeMushroom.EnumType.STEM));
                        }
                    }

                    return true;
                }
            }
        }
        else
        {
            return false;
        }
	}

}
