package com.vark.lightsabers;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

public class VillagerKills implements Listener
{
	private Plugin plugin = main.getPlugin(main.class);

	public VillagerKills(main plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this,plugin);
	}
	
	
	@EventHandler
	public void onVillKilled(EntityDeathEvent event)
	{
		
		if(event.getEntity() instanceof Villager)
		{
			if(event.getEntity().getKiller() instanceof Player)
			{
				
				
				Player p = (Player)event.getEntity().getKiller();
				//p.sendMessage("Killed a Villager...");
				
				File file = new File(plugin.getDataFolder()+"/users/" + p.getUniqueId() + ".yml");
				
		    	if (!file.exists()) 
		    	{ //Checks if the file doesn't exist
		    		try {
		    			file.createNewFile(); //Tries to create the file
		    			FileConfiguration config = YamlConfiguration.loadConfiguration(file); //Creates a FileConfiguration for the file
		    			config.set("kills", 49);//Path, where the value is stored and Value, what gets stored example config.set("health",100); would put health: 100 in the plugins/Test/+player.getUniqueId().yml file
		    			config.save(file); //So the changes are actually saved
		    			config.get("kills"); 
		    			//etc..etc..etc.. Learn FileConfiguration
		    			//p.sendMessage("File Does Not Exist");
		    		} catch (IOException ex) {
		    			p.sendMessage("Error123 Contact an Admin");
		    		} 
		    	}
		    	else
		    	{
		    		//p.sendMessage("File Exists!");
		    		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		    		try {
		    		int kills = (int)config.get("kills");
		    		kills--;
		    		config.set("kills", kills);
		    		config.save(file);
		    		}catch (IOException ex) {
		    			p.sendMessage("Error223 Contact an Admin");
		    		}
		    		
		    		
		    		
		    		
		    	}
				
				
				
				
				
				
				
			}
		
		
		
		
		
		
		}
	}
	
	
	
	
}
