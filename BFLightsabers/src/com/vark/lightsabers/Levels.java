package com.vark.lightsabers;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class Levels 
{

	
	private static Plugin plugin = main.getPlugin(main.class);

	public static void addLevels(Player p, int x)
	{
		
		if(checkFile(p))
		{

		
			File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			int a = config.getInt("levels");
			
		
			a+=x;
			
			
			
			config.set("levels", a);
			
			
			try {
				config.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
			}
	
		}

		
	}
	
	
	public static void addSkillpoins(Player p, int x)
	{
		
		if(checkFile(p))
		{

		
			File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			int a = config.getInt("skillpoints");
			
		
			a+=x;
			
			
			
			config.set("skillpoints", a);
			
			
			try {
				config.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
			}
	
		}

		
	}
	
	public static void addexp(Player p, int x)
	{
		
		if(checkFile(p))
		{

			File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			int a = config.getInt("exp");
			
			a+=x;
			
			config.set("exp", a);
			
			
			try {
				config.save(file);
				checkLevelUp(p);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
	
		}

		
	}
	public static void removeexp(Player p, int x)
	{
		
		if(checkFile(p))
		{

			File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			int a = config.getInt("exp");
			
			a-=x;
			
			config.set("exp", a);
			
			
			try {
				config.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}

		
	}
	
	
	public static int getLevels(Player p)
	{
		
		if(checkFile(p))
		{

			File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			int a = config.getInt("levels");
			
			return a;
			

	
		}
		else 
			return -1;

	}
	
	public static int getExp(Player p)
	{
		
		if(checkFile(p))
		{

			File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			int a = config.getInt("exp");
			
			
		
			return a;
			

	
		}
		else 
			return -1;

	}
	
	
	
	public static int getSkillpoints(Player p)
	{
		
		if(checkFile(p))
		{

			File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			int a = config.getInt("skillpoints");
			
			
		
			return a;
			

	
		}
		else 
			return -1;

	}
	
	
	
	
	
	public static String printStats(Player p)
	{
		int initial = Levels.getLevels(p);
		int next = initial + 1;
		
		int expneeded = (int) (Math.pow(next, 2));
		expneeded*=5;
		
		
		int d = expneeded-=Levels.getExp(p);
	
		return "Level: "+getLevels(p)+ " Exp: "+getExp(p) + " You Need "+d+" more exp to level up!";

	}
	
	
	
	
	
	
	
	public static void checkLevelUp(Player p)
	{
		
		int initial = Levels.getLevels(p);
		
		
		
		int next = initial + 1;
		

		
		
		int expneeded = (int) (Math.pow(next, 2));
		
		expneeded*=5;
		
	
		
		if(Levels.getExp(p) >= expneeded)
		{
			
			
			Levels.addLevels(p, 1);
	
			Levels.removeexp(p, expneeded);
			
			Levels.addSkillpoins(p, 1);
			
			p.sendTitle(ChatColor.GREEN+""+ChatColor.BOLD+"Level Up!", ChatColor.BLUE+"You Have Gained 1 Skill Point!", 10, 10, 10);
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	public static boolean checkFile(Player p)
	{
		File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
		if(file.exists())
		{
			return true;
		}
		
		
		return false;
		
	}
	
	
}
