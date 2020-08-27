package com.vark.lightsabers;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Crystals 
{

	
	public static ItemStack giveCrystal(String s)
	{
		
		ItemStack c = new ItemStack(Material.NETHER_STAR);
		ItemMeta cmeta = c.getItemMeta();
		ArrayList<String> kclore = new ArrayList<String>();
		kclore.add("A Shiny Crystal That Contains Unknown Powers...");
		cmeta.setLore(kclore);
		cmeta.setCustomModelData(30000101);
		cmeta.setDisplayName(ChatColor.WHITE+"White Kyber Crystal");
		c.setItemMeta(cmeta);
		
		
		if(s.equals("red"))
		{
			cmeta.setDisplayName(ChatColor.RED+"Red Kyber Crystal");
			cmeta.setCustomModelData(31111111);
		}
		
		if(s.equals("orange"))
		{
			cmeta.setDisplayName(ChatColor.GOLD+"Orange Kyber Crystal");
			cmeta.setCustomModelData(30000001);
		}
		
		if(s.equals("yellow"))
		{
			cmeta.setDisplayName(ChatColor.YELLOW+"Yellow Kyber Crystal");
			cmeta.setCustomModelData(30000111);
		}
		
		if(s.equals("green"))
		{
			cmeta.setDisplayName(ChatColor.GREEN+"Green Kyber Crystal");
			cmeta.setCustomModelData(30111111);
		}
		
		if(s.equals("blue"))
		{
			cmeta.setDisplayName(ChatColor.BLUE+"Blue Kyber Crystal");
			cmeta.setCustomModelData(30011111);
		}
		
		if(s.equals("purple"))
		{
			cmeta.setDisplayName(ChatColor.DARK_PURPLE+"Purple Kyber Crystal");
			cmeta.setCustomModelData(30001111);
		}
		
		if(s.equals("magenta"))
		{
			cmeta.setDisplayName(ChatColor.LIGHT_PURPLE+"Magenta Kyber Crystal");
			cmeta.setCustomModelData(41111111);
		}
		
		if(s.equals("cyan"))
		{
			cmeta.setDisplayName(ChatColor.AQUA+"Cyan Kyber Crystal");
			cmeta.setCustomModelData(30000011);
		}
		
		if(s.equals("pink"))
		{
			cmeta.setDisplayName(ChatColor.LIGHT_PURPLE+"Pink Kyber Crystal");
			cmeta.setCustomModelData(51111111);
		}
		
		if(s.equals("turquoise"))
		{
			cmeta.setDisplayName(ChatColor.AQUA+"Turquoise Kyber Crystal");
			cmeta.setCustomModelData(71111111);
		}
		
		if(s.equals("amber"))
		{
			cmeta.setDisplayName(ChatColor.GOLD+"Amber Kyber Crystal");
			cmeta.setCustomModelData(61111111);
		}
		
		
		
		
		
		
		
		
		
		
		c.setItemMeta(cmeta);
		return c;
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
