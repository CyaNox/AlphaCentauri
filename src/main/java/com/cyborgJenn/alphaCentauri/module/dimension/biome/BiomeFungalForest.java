package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeFungalForest extends ACBiome
{
	private ACBiomeDecorator biomeDecorator;
	
	public BiomeFungalForest(BiomeProperties properties) 
	{
		super(properties);
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
        this.topBlock = ModBlocks.FUNGUS.getDefaultState();
        this.fillerBlock = ModBlocks.acDirt.getDefaultState();
        this.theBiomeDecorator = new ACBiomeDecorator(this);
        biomeDecorator = (ACBiomeDecorator)theBiomeDecorator;
        this.biomeDecorator.mossPerChunk = 5;
        this.biomeDecorator.grassPerChunk = 3;
        this.biomeDecorator.mushroomsPerChunk = 3;
        this.biomeDecorator.bigMushroomsPerChunk = 409;
        
        //TODO moss , ferns , tall grass, boulders and sporePlants.
	}
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        super.decorate(worldIn, rand, pos);
    }
	@SideOnly(Side.CLIENT)
	@Override
    public int getSkyColorByTemp(float currentTemperature)
    {
        return 0xd6c5e8;
    }
	@SideOnly(Side.CLIENT)
	@Override
	public int getModdedBiomeGrassColor(int ont)
	{
		return 0x5D8F92;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public int getModdedBiomeFoliageColor(int original)
	{
		return 0xad5cc9;
	}
}
