package com.vark.lightsabers;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;



public class Signs implements Listener
{

	private Plugin plugin = main.getPlugin(main.class);
	
	
	
	public Signs(main plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this,plugin);
	}
	
	
	@EventHandler
	public void onInteractWithSign(PlayerInteractEvent event)
	{
		
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
		
			if(event.getClickedBlock().getType() == Material.OAK_SIGN || event.getClickedBlock().getType() == Material.OAK_WALL_SIGN)
			{
		

				
				//p.sendMessage("Clicked a sign");
				//event.getClickedBlock().getState()
				Sign s = (Sign)event.getClickedBlock().getState();
				
				//p.sendMessage("line 0 = " + s.getLine(0));
				if(s.getLine(0).equals("[Convert]"))
				{
					Player p = event.getPlayer();
					if(p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getType() == Material.NETHER_STAR)
					{
						ItemStack item = p.getInventory().getItemInMainHand();
						if(item.getItemMeta().getCustomModelData() == 30000101)
						{
							if(item.getAmount() == 1)
							{
								if(s.getLine(1).equals("GREEN"))
								{
									ItemStack c = Crystals.giveCrystal("green");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.GREEN+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
								if(s.getLine(1).equals("BLUE"))
								{
									ItemStack c = Crystals.giveCrystal("blue");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.BLUE+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
								if(s.getLine(1).equals("YELLOW"))
								{
									ItemStack c = Crystals.giveCrystal("yellow");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.YELLOW+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
								if(s.getLine(1).equals("CYAN"))
								{
									ItemStack c = Crystals.giveCrystal("cyan");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.AQUA+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
								if(s.getLine(1).equals("AMBER"))
								{
									ItemStack c = Crystals.giveCrystal("amber");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.GOLD+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
								if(s.getLine(1).equals("MAGENTA"))
								{
									ItemStack c = Crystals.giveCrystal("magenta");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.LIGHT_PURPLE+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
								if(s.getLine(1).equals("PURPLE"))
								{
									ItemStack c = Crystals.giveCrystal("purple");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.DARK_PURPLE+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
								if(s.getLine(1).equals("PINK"))
								{
									ItemStack c = Crystals.giveCrystal("pink");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.LIGHT_PURPLE+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
								if(s.getLine(1).equals("TURQUOISE"))
								{
									ItemStack c = Crystals.giveCrystal("turquoise");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.AQUA+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
								if(s.getLine(1).equals("ORANGE"))
								{
									ItemStack c = Crystals.giveCrystal("orange");
									
									item.setItemMeta(c.getItemMeta());
									p.sendMessage(ChatColor.GOLD+"Kyber Crystal Has Changed Color....");

									p.teleport(sendLoc(p));
									
								}
							}
							else
							{
								p.sendMessage("Only Hold One Kyber Crystal In Your Hand!");
							}
							
							
							
							
							
						}
						
					}
				}
			

			}
		
		
		}
		
		
		
		
		
	}
	
	@EventHandler
	public void onCreateSign(SignChangeEvent event)
	{
	    if (!(event.getPlayer().isOp())) 
	    {
	            String line = event.getLine(0);
	            
	            if (line.equals("[Convert]")) 
	            {
	                event.isCancelled();
	                event.getBlock().breakNaturally();
	                event.getPlayer().sendMessage(ChatColor.RED+"You Do Not Have Permission to Do This!");
	            }
	        
	    }		

	}
	
	
	public Location sendLoc(Player p)
	{
		
		Location loc = p.getLocation();
		
		File file = new File(plugin.getDataFolder()+"/data/"+"respawnloc"+".yml");
		
		// creates a new file with the given path example: File file = new File("plugins/Test/" + player.getUniqueId() + ".yml");
    		if (file.exists()) 
    		{ 
    			//p.sendMessage("file exists 19303");
    			FileConfiguration config = YamlConfiguration.loadConfiguration(file);

				

				loc = (Location)config.get("path");
				
			
				
    		}
    	
    		else 
    		{
    			p.sendMessage("Error 701 Contact an Admin");
    			
    		}
    		
    		return loc;
    		
    		
    		
    		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
