package com.vark.lightsabers;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Sabers 
{

	
	public static ItemStack getSaber(String s)
	{
		ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("An Elegant Weapon From A More Civilized Age");
		meta.setLore(lore);
		
		if(s.equals("orange"))
		{
		meta.setCustomModelData(10000001);
		meta.setDisplayName(ChatColor.GOLD+"Orange Lightsaber");
		}
		
		if(s.equals("cyan"))
		{
		meta.setCustomModelData(10000002);
		meta.setDisplayName(ChatColor.DARK_AQUA+"Cyan Lightsaber");
		}
		
		if(s.equals("yellow"))
		{
		meta.setCustomModelData(10000011);
		meta.setDisplayName(ChatColor.YELLOW+"Yellow Lightsaber");
		}
		
		
		if(s.equals("purple"))
		{
		meta.setCustomModelData(10000003);
		meta.setDisplayName(ChatColor.DARK_PURPLE+"Purple Lightsaber");
		}
		
		if(s.equals("blue"))
		{
		meta.setCustomModelData(10000008);
		meta.setDisplayName(ChatColor.BLUE+"Blue Lightsaber");
		}
		
		if(s.equals("green"))
		{
		meta.setCustomModelData(10000009);
		meta.setDisplayName(ChatColor.GREEN+"Green Lightsaber");
		}
		
		if(s.equals("red"))
		{
		meta.setCustomModelData(10000007);
		meta.setDisplayName(ChatColor.RED+"Red Lightsaber");
		}
		
		if(s.equals("magenta"))
		{
		meta.setCustomModelData(10000012);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Magenta Lightsaber");
		}
		
		if(s.equals("white"))
		{
		meta.setCustomModelData(10000013);
		meta.setDisplayName(ChatColor.WHITE+"White Lightsaber");
		}
		if(s.equals("pink"))
		{
		meta.setCustomModelData(10000035);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Pink Lightsaber");
		}
		if(s.equals("amber"))
		{
		meta.setCustomModelData(10000029);
		meta.setDisplayName(ChatColor.GOLD+"Amber Lightsaber");
		}
		if(s.equals("turquoise"))
		{
		meta.setCustomModelData(10000032);
		meta.setDisplayName(ChatColor.AQUA+"Turquoise Lightsaber");
		}
		
		if(s.equals("dorange"))
		{
		meta.setCustomModelData(10000015);
		meta.setDisplayName(ChatColor.GOLD+"Orange Lightsaber");
		}
		
		if(s.equals("daqua"))
		{
		meta.setCustomModelData(10000016);
		meta.setDisplayName(ChatColor.DARK_AQUA+"Cyan Lightsaber");
		}
		
		if(s.equals("dyellow"))
		{
		meta.setCustomModelData(10000006);
		meta.setDisplayName(ChatColor.YELLOW+"Yellow Lightsaber");
		}
		
		
		if(s.equals("dpurple"))
		{
		meta.setCustomModelData(10000020);
		meta.setDisplayName(ChatColor.DARK_PURPLE+"Purple Lightsaber");
		}
		
		if(s.equals("dblue"))
		{
		meta.setCustomModelData(10000017);
		meta.setDisplayName(ChatColor.BLUE+"Blue Lightsaber");
		}
		
		if(s.equals("dgreen"))
		{
		meta.setCustomModelData(10000018);
		meta.setDisplayName(ChatColor.GREEN+"Green Lightsaber");
		}
		
		if(s.equals("dred"))
		{
		meta.setCustomModelData(10000005);
		meta.setDisplayName(ChatColor.RED+"Red Lightsaber");
		}
		
		if(s.equals("dmagenta"))
		{
		meta.setCustomModelData(10000019);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Magenta Lightsaber");
		}
		
		if(s.equals("dwhite"))
		{
		meta.setCustomModelData(10000014);
		meta.setDisplayName(ChatColor.WHITE+"White Lightsaber");
		}
		if(s.equals("dpink"))
		{
		meta.setCustomModelData(10000036);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Pink Lightsaber");
		}
		if(s.equals("damber"))
		{
		meta.setCustomModelData(10000030);
		meta.setDisplayName(ChatColor.GOLD+"Amber Lightsaber");
		}
		if(s.equals("dturquoise"))
		{
		meta.setCustomModelData(10000033);
		meta.setDisplayName(ChatColor.AQUA+"Turquoise Lightsaber");
		}
		if(s.equals("dcyan"))
		{
		meta.setCustomModelData(10000016);
		meta.setDisplayName(ChatColor.BLUE+"Cyan Lightsaber");
		}
		
		
		
		
		if(s.equals("corange"))
		{
		meta.setCustomModelData(10000024);
		meta.setDisplayName(ChatColor.GOLD+"Orange Lightsaber");
		}
		
		if(s.equals("ccyan"))
		{
		meta.setCustomModelData(10000025);
		meta.setDisplayName(ChatColor.DARK_AQUA+"Cyan Lightsaber");
		}
		
		if(s.equals("cyellow"))
		{
		meta.setCustomModelData(10000023);
		meta.setDisplayName(ChatColor.YELLOW+"Yellow Lightsaber");
		}
		
		
		if(s.equals("cpurple"))
		{
		meta.setCustomModelData(10000027);
		meta.setDisplayName(ChatColor.DARK_PURPLE+"Purple Lightsaber");
		}
		
		if(s.equals("cblue"))
		{
		meta.setCustomModelData(10000021);
		meta.setDisplayName(ChatColor.BLUE+"Blue Lightsaber");
		}
		
		if(s.equals("cgreen"))
		{
		meta.setCustomModelData(10000022);
		meta.setDisplayName(ChatColor.GREEN+"Green Lightsaber");
		}
		
		if(s.equals("cred"))
		{
		meta.setCustomModelData(10000010);
		meta.setDisplayName(ChatColor.RED+"Red Lightsaber");
		}
		
		if(s.equals("cmagenta"))
		{
		meta.setCustomModelData(10000026);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Magenta Lightsaber");
		}
		
		if(s.equals("cwhite"))
		{
		meta.setCustomModelData(10000028);
		meta.setDisplayName(ChatColor.WHITE+"White Lightsaber");
		}
		if(s.equals("cpink"))
		{
		meta.setCustomModelData(10000037);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Pink Lightsaber");
		}
		if(s.equals("camber"))
		{
		meta.setCustomModelData(10000031);
		meta.setDisplayName(ChatColor.GOLD+"Amber Lightsaber");
		}
		if(s.equals("cturquoise"))
		{
		meta.setCustomModelData(10000034);
		meta.setDisplayName(ChatColor.AQUA+"Turquoise Lightsaber");
		}
		
		item.setItemMeta(meta);
		
		
		return item;
	}
		

	

	
	
	
}
