package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFluidTerraLava extends BlockFluidClassic{
    
	public BlockFluidTerraLava(Fluid fluid, Material material) {
		super(fluid, material);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setLightLevel(15.0F);
	}
	
	
	
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World world, int posX, int posY, int posZ, Entity entity) {
    	
    }
}
