package com.cyborgJenn.alphaCentauri.module.accessories.item.accessory;

import java.util.List;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.api.AccessoryType;
import com.cyborgJenn.alphaCentauri.api.IAccessory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSwimGoggles extends Item implements IAccessory
{
	public ItemSwimGoggles()
	{
		super();
		this.setUnlocalizedName("swimGoggles");
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);

	}
	@Override
	public AccessoryType getAccessoryType(ItemStack itemstack)
	{
		return AccessoryType.Accessory;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player)
	{
		
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player)
	{
		
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
	{
		
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player)
	{
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player)
	{
		return true;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		tooltip.add("That fish was this ....... big. Allows the wearer to see through the murky depths.");
	}
}
