package com.vark.lightsabers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sun.istack.internal.NotNull;

import net.md_5.bungee.api.ChatColor;

public class SetSign implements CommandExecutor 
{
	
	private Plugin plugin = main.getPlugin(main.class);

	@Override
	public boolean onCommand(@NotNull CommandSender cs, @NotNull Command arg1, @NotNull String arg2,
			@NotNull String[] arg3) 
	{
		if(cs instanceof Player)
		{
			Player p = (Player)cs;
			if(p.isOp())
			{
				setLoc(p);
				return true;
				
			}
		}
		
		
		
		return false;
	}
	
	
	
	public void setLoc(Player p)
	{
		
	
		
		File file = new File(plugin.getDataFolder()+"/data/"+"respawnloc"+".yml");
		
		// creates a new file with the given path example: File file = new File("plugins/Test/" + player.getUniqueId() + ".yml");
    		if (!file.exists()) 
    		{ //Checks if the file doesn't exist
    			try {
    				file.createNewFile(); //Tries to create the file
    				FileConfiguration config = YamlConfiguration.loadConfiguration(file);
    				
    				Location loc = p.getLocation();
    				config.set("path",loc);

    				config.save(file); 
    				p.sendMessage(ChatColor.AQUA+"Respawn Set: X: "+config.get("locx")+" Y: "+config.get("locy")+" Z: "+config.get("locz"));

    			} catch (IOException ex) {
    				p.sendMessage("Error 401 Contact An Admin");
    			} 
    		}
    	
    		else 
    		{
    			try {
    				FileConfiguration config = YamlConfiguration.loadConfiguration(file);
    	
    				Location loc = p.getLocation();
    				config.set("path",loc);
    				config.save(file); 
    				p.sendMessage(ChatColor.AQUA+"Respawn Set: " + config.get("path"));
    		
    			}catch (IOException ex) {
    				p.sendMessage("Error 501 Contact an Admin");
    			}
    		}	
	}

	
	
	
	
	
	
}
