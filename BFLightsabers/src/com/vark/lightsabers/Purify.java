package com.vark.lightsabers;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Purify implements CommandExecutor
{

	
	public boolean onCommand(CommandSender cs, Command arg1, String arg2, String[] arg3)
	{
		
		
		
		if(cs instanceof Player)
		{
			
			if(((Player) cs).getInventory().getItemInMainHand().getType() == Material.NETHER_STAR)
			{
				
				if(((Player) cs).getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
				{
					
					if(((Player) cs).getInventory().getItemInMainHand().getAmount() == 1)
					{
						if(isCrystal(((Player) cs).getInventory().getItemInMainHand().getItemMeta().getCustomModelData()))
						{
							
							Player p = ((Player) cs).getPlayer();
							
							int xp = p.getTotalExperience();
							
							if(xp >= 300)
							{
							
								//p.setTotalExperience(xp-360);
								p.giveExp(-300);
								
								
								p.sendMessage(ChatColor.AQUA+"Purified Crystal!");
								
								ItemStack i = p.getInventory().getItemInMainHand();
								ItemMeta m = i.getItemMeta();
								


								m.setCustomModelData(30000101);
								m.setDisplayName(ChatColor.WHITE+"White Kyber Crystal");
								i.setItemMeta(m);
								
								
								p.getWorld().spawnParticle(Particle.REDSTONE, p.getLocation(),100,1.2,1.2,1.2,1,new Particle.DustOptions(Color.WHITE, 5));
								return true;
							}
							else {
								int x = 300-xp;
								cs.sendMessage(ChatColor.AQUA + "You Need "+ x + ChatColor.YELLOW+"More Levels of Experience!");
								return true;
							}
							
							
							
							
						}
						else {
							cs.sendMessage(ChatColor.AQUA + "You Must Have One Kyber Crystal In Your Hand!");
							return true;
						}
					}
					else {
						cs.sendMessage(ChatColor.AQUA + "You Must Have One Kyber Crystal In Your Hand!");
						return true;
					}
					
					
					
				}
				else
				{
					cs.sendMessage(ChatColor.AQUA + "You Must Have One Kyber Crystal In Your Hand!");
					return true;
				}
				
				
				
			}
			
			else
			{
				cs.sendMessage(ChatColor.AQUA + "You Must Have One Kyber Crystal In Your Hand!");
				return true;
			}
			
			
			
			
		}
		
		
		
		
		
		return false;

	}
	
	
	public boolean isCrystal(int c)
	{
		boolean a = false;
		
		if(c == 30000001)
			a = true;
		
		if(c == 30000011)
			a = true;
		
		if(c == 30000111)
			a = true;
		
		if(c == 30001111)
			a = true;
		
		if(c == 30011111)
			a = true;
		
		if(c == 30000101)
			a = true;
		
		if(c == 30111111)
			a = true;
		
		if(c == 41111111)
			a = true;
		
		if(c == 51111111)
			a = true;
		
		if(c == 61111111)
			a = true;
		
		if(c == 71111111)
			a = true;
		
		if(c == 31111111)
			a = true;
		
		
		
		return a;
		
	}
	
	
	
	
}
