package com.vark.lightsabers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sun.istack.internal.NotNull;

import net.md_5.bungee.api.ChatColor;

public class GetCrystal implements CommandExecutor
{
	
	
	public GetCrystal() {}

	@Override
	public boolean onCommand(@NotNull CommandSender cs, @NotNull Command arg1, @NotNull String arg2,
			@NotNull String[] arg3) 
	{
		if(cs instanceof Player)
		{
			Player p = (Player)cs;
			if(p.hasPermission("saber.getcrystal"))
			{
				if(arg3.length == 0)
				{
					p.getInventory().addItem(Crystals.giveCrystal("white"));
					return true;
				}
				p.getInventory().addItem(Crystals.giveCrystal(arg3[0]));
				return true;
				
			}
			else
			{
				p.sendMessage(ChatColor.RED+"You Do Not Have Pemission To Do This!");
				return true;
			}
			
			
		}
		return false;
	}

	
	
	
	
}
