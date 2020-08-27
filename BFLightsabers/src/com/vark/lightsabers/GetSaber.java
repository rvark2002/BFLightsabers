package com.vark.lightsabers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sun.istack.internal.NotNull;

import net.md_5.bungee.api.ChatColor;

public class GetSaber implements CommandExecutor
{
	
	
	public GetSaber() {}

	@Override
	public boolean onCommand(@NotNull CommandSender cs, @NotNull Command arg1, @NotNull String arg2,
			@NotNull String[] arg3) 
	{
		if(cs instanceof Player)
		{
			Player p = (Player)cs;
			if(p.hasPermission("saber.getsabers"))
			{
				if(arg3.length == 0)
				{
					p.getInventory().addItem(Sabers.getSaber("white"));
					return true;
				}
				p.getInventory().addItem(Sabers.getSaber(arg3[0]));
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
