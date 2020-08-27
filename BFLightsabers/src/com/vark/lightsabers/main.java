package com.vark.lightsabers;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;



public class main extends JavaPlugin
{
	
	
	
	public void onEnable() {
		
		new LightsaberListener(this);
		new Crafting(this);
		new VillagerKills(this);
		new Signs(this);
		new ThrowListener(this);
		new TurningSaberListener(this);
		getCommand("bleedcrystal").setExecutor(new Bleeding());
		getCommand("getcrystals").setExecutor(new GetCrystal());
		getCommand("setcrystalrespawn").setExecutor(new SetSign());
		getCommand("purifycrystal").setExecutor(new Purify());
		getCommand("getsabers").setExecutor(new GetSaber());
		CM.setupCooldown();
		//	Crafting.newRecipe();
		
		File userFolder = new File(this.getDataFolder(), "users");
		File data = new File(this.getDataFolder(), "data");
		userFolder.mkdirs();
		data.mkdir();	
		
		
		
		
	}
	

	
	public void onDisable() {
		
	}
	
	
	
	


}
