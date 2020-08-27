package com.vark.lightsabers;

import java.io.File;
import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;



public class Bleeding implements CommandExecutor
{

	private Plugin plugin = main.getPlugin(main.class);
	
	public Bleeding(){}
	
	
	
	public void dataCreate(Player p)
	{
		
		File file = new File(plugin.getDataFolder()+"/users/" + p.getUniqueId() + ".yml");
		
		// creates a new file with the given path example: File file = new File("plugins/Test/" + player.getUniqueId() + ".yml");
    	if (!file.exists()) 
    	{ //Checks if the file doesn't exist
    		try {
    			file.createNewFile(); //Tries to create the file
    			FileConfiguration config = YamlConfiguration.loadConfiguration(file); //Creates a FileConfiguration for the file
    			config.set("kills", 49);//Path, where the value is stored and Value, what gets stored example config.set("health",100); would put health: 100 in the plugins/Test/+player.getUniqueId().yml file
    			config.save(file); //So the changes are actually saved
    			config.get("kills"); 
    			//etc..etc..etc.. Learn FileConfiguration
    		} catch (IOException ex) {
    			p.sendMessage("Error 001 Contact An Admin");
    		} 
    	}
    	
    	else {
    		
    		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
    		getKills(file,config,p);
    		
    	}
    	
    	
    	
    	
    	
    	
	}


	@Override
	public boolean onCommand(CommandSender cs, Command arg1, String arg2, String[] arg3) 
	{
		if(cs instanceof Player)
		{
			
			Player p = (Player)cs;
			
			if(Levels.getLevels(p) >= 15)
			{
				dataCreate(p);
			}
			else {
				p.sendMessage(ChatColor.RED+"You aren't powerful enough to do this! Reach Level 15");
			}
			
			return true;
		}
		 
		return false;
		
	}
	
	
	public void getKills(File file, FileConfiguration config, Player p)
	{

		if(p.getInventory().getItemInMainHand().getType() != Material.AIR && p.getInventory().getItemInMainHand() != null)
		{
			if(p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
			{
				
		if(isCrystal(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData()) && p.getInventory().getItemInMainHand().getAmount() == 1)
		{
			
			//p.sendMessage("Detected Crystal");
			int kills = (int)config.get("kills");
			
			if(kills != 0)
			p.sendMessage(""+ChatColor.RED+ChatColor.BOLD+"You Have To Kill "+kills+" More Villagers!");
			
			if(kills <= 0)
			{
				p.sendMessage(ChatColor.DARK_RED+"Bleeding Crystal!");
				
				try
				{
					kills+=50;
				config.set("kills", kills);
				config.save(file);
				
				
				ItemStack i = p.getInventory().getItemInMainHand();
				ItemMeta m = i.getItemMeta();
				


				m.setCustomModelData(31111111);
				m.setDisplayName(ChatColor.RED+"Red Kyber Crystal");
				i.setItemMeta(m);
				
				
				p.getWorld().spawnParticle(Particle.REDSTONE, p.getLocation(),100,1.2,1.2,1.2,1,new Particle.DustOptions(Color.RED, 5));
			
			
				setPowerLevel(p, "crystalsbled", getPowerLevel(p, "crystalsbled")+1);
				
				Levels.addexp(p, 10);
				p.sendMessage(ChatColor.RED+"You Gained 10xp for Bleeding A Crystal!");
				
				}  catch (IOException ex) {
					p.sendMessage("Contact an Admin");
				}
				
				
			
			
			}
			
			
			
			
		}
		else
			p.sendMessage(ChatColor.BOLD+"You Must Have A Kyber Crystal In Your Hand!");
		
		
			}
		}
		
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
		
		
		
		return a;
		
	}
	
	
	
    
    public int getPowerLevel(Player p, String force)
    {
    	
    
    	
    	
    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
    	
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		int x = config.getInt(force);
    	
    	return x;
    	
    	
    	
    }
    
    
    
    public void setPowerLevel(Player p, String force,int x)
    {
    	
    
    	
    	
    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
    	
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		config.set(force, x);
    	
		try {
			config.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
	
	
}
