package com.vark.lightsabers;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_16_R3.projectiles.CraftBlockProjectileSource;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;




public class LightsaberListener implements Listener
{
	
	private Plugin plugin = main.getPlugin(main.class);
	
	
	
	

	public LightsaberListener(main plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this,plugin);
		
		

		
	}
	
	

	
	
	
	
	//Checks if Item in Hand is a saber
	public boolean isSaber(Player p) 
	{

		if(!(p.isDead()))
		{
		
		
			if( !( (p.getInventory().getItemInMainHand().getType() == Material.AIR) || (p.getInventory().getItemInMainHand().getType() == null)) )
			{
				if(p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
				{
					int a = p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
				
					
						if(a <= 10000100 && a >= 10000001)
						{
							if(isCross(a))
							{
								if(p.hasPermission("saber.sl"))
								{
									if(checkRed(p,a))
										return true;
									else
									{
										p.sendMessage(ChatColor.DARK_RED+"You are Not A High Enough Level to Use This! Reach Level 12");
										return false;
									}
								}
								else
								{
									p.sendMessage(ChatColor.DARK_RED+"Sorry Only Supreme Leaders Can Wield This Weapon!");
									return false;
								}
							}
							
							
							if(Levels.getLevels(p) >= 5)
							{
							
							if(checkRed(p,a))
							{
								return true;
							}
							else
							{
								p.sendMessage(ChatColor.DARK_RED+"You are not a high enough level to use this! Reach Level 12");
								return false;
							}
							
							}else {
								p.sendMessage(ChatColor.GOLD+"You are not a high enough level to use this! Reach Level 5!");
							}
							
						}
					
				}
			}
		}
		

		return false;
	}
	
	//Checks if Item in Hand is a saber pike
		public boolean isPike(Player p) 
		{

			if(!(p.isDead()))
			{
			
				
			
				if( !( (p.getInventory().getItemInMainHand().getType() == Material.AIR) || (p.getInventory().getItemInMainHand().getType() == null)) )
				{
					
					if(p.getInventory().getItemInMainHand().getType() != Material.SCUTE)
					{
						return false;
					}
					
					
					if(p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
					{
						int a = p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
					
						
							if(a >= 101 && a <= 500)
							{
								
								
								if(Levels.getLevels(p) >= 5)
								{
								
								if(checkRed(p,a))
								{
									
									if(a == 102)
									{
										if(Levels.getLevels(p) >= 12)
										{
											return true;
										}
										else
										{
											p.sendMessage(ChatColor.DARK_RED+"You are not a high enough level to use this! Reach Level 12");
											return false;
										}
									}
									else {
										
										return true;
									}
									
								}
								else
								{
									p.sendMessage(ChatColor.DARK_RED+"You are not a high enough level to use this! Reach Level 12");
									return false;
								}
								
								}else {
									p.sendMessage(ChatColor.GOLD+"You are not a high enough level to use this! Reach Level 5!");
								}
								
							}
						
					}
				}
			}
			

			return false;
		}
		
	
	
	
	public boolean checkRed(Player p,int model)
	{
		
		if(model == 10000044 || model == 10000005 || model == 10000007 || model == 10000010)
		{
			
			
			if(Levels.getLevels(p) >= 12)
			{
				return true;
			}else {
				return false;
			}
			
			
			
		}
		else
			return true;
		
		
	}
	
	
	@EventHandler
	public void onThorns(EntityDamageEvent event)
	{
		
		if(event.getCause() == DamageCause.THORNS)
		{
			
			if(event.getEntityType() == EntityType.PLAYER)
			{
				Player e = (Player) event.getEntity();
				if(isSaber(e))
				{
					event.setCancelled(true);
				}
				if(isPike(e))
				{
					event.setCancelled(true);
				}
			}
			
		}
		
		
		
	}
	
	
	
	
	
	public boolean checkSaber(ItemStack is,Player p) 
	{

		
			ItemStack b = is;
			
				if(b.getItemMeta().hasCustomModelData())
				{
					int a = b.getItemMeta().getCustomModelData();
				
					
						if(a <= 10000100 && a >= 10000001)
						{
							if(isCross(a))
							{
								if(p.hasPermission("saber.sl"))
								{
									return true;
								}
								else
								{
									p.sendMessage(ChatColor.DARK_RED+"Sorry Only Supreme Leaders Can Wield This Weapon!");
									return false;
								}
							}

							return true;
						}
					
				}
					

		return false;
	}
	
	
	
	public boolean isCross(int c)
	{
		boolean a = false;
		
		
		if(c == 10000010)
			a = true;
		
		if(c >= 10000021 && c <= 10000028)
			a = true;
		
		if(c == 10000031)
			a = true;
		
		if(c == 10000034)
			a = true;
		
		if(c == 10000037)
			a = true;
		
		if(c == 10000056)
			a = true;	
		
		if(c == 10000060)
			a = true;
		
		return a;
		
		
		
		
	}
	
	
	@EventHandler
	public void onHasSaber(EntityDamageByEntityEvent event)
	{
	
			if(event.getEntity() instanceof Player)
			{
				Player p = (Player)event.getEntity();
			
			
				if(isSaber(p))
				{
					if(event.getDamager() instanceof LivingEntity)
					{
						Entity e = event.getDamager();
						if((p.getLocation().getDirection().dot(e.getLocation().getDirection()) < 0))
						{
							
							if(e instanceof Player)
							{
								Player attacker = (Player)e;
								if(isSaber(attacker))
								{
									
									if(saberBreak(attacker,1))
									{
										
										event.setDamage(15);
										attacker.sendMessage(ChatColor.RED+""+" you broke " +p.getName()+"'s guard!");
										
										p.sendMessage(ChatColor.RED+""+attacker.getName()+" broke your guard!");
										
									}
									else
									{
										event.setCancelled(true);
									}
									
								}
								
								else if(isPike(attacker))
								{
									
									if(saberBreak(attacker,2))
									{
										
										event.setDamage(3);
										attacker.sendMessage(ChatColor.RED+""+" you broke " +p.getName()+"'s guard!");
										
										p.sendMessage(ChatColor.RED+""+attacker.getName()+" broke your guard!");
										
									}
									else
									{
										event.setCancelled(true);
									}
									
								}
								else {
								
								
								event.setCancelled(true);
								}
								
								
							}
							else
							{
							
							
								event.setCancelled(true);
							
							}

						}
				
					}
				
					
					if(event.getDamager() instanceof Projectile)
					{
					
						Projectile proj = (Projectile)event.getDamager();
						
						if(proj.getShooter() instanceof LivingEntity)
						{
							LivingEntity shoot = (LivingEntity)proj.getShooter();
							if(p.getLocation().getDirection().dot(shoot.getLocation().getDirection()) < 0)
							{
								proj.setVelocity(p.getLocation().getDirection().multiply(-10));
								event.setCancelled(true);
							}
						}
						
						if(proj.getShooter() instanceof CraftBlockProjectileSource)
						{
							
							CraftBlockProjectileSource d = (CraftBlockProjectileSource)proj.getShooter();
							

								
						
							
							
								if(p.getLocation().getDirection().dot(d.getBlock().getLocation().getDirection()) < 0)
								{
									proj.setVelocity(p.getLocation().getDirection().multiply(-10));
									event.setCancelled(true);
								}
						}
							
					}
					
				}
				
				
				
				//Saber Pike
				
				if(isPike(p))
				{
					
					if(event.getDamager() instanceof LivingEntity)
					{
						Entity e = event.getDamager();
						if((p.getLocation().getDirection().dot(e.getLocation().getDirection()) < 0))
						{
							
							if(e instanceof Player)
							{
								Player attacker = (Player)e;
								if(isSaber(attacker))
								{
									
									if(saberBreak(attacker,1))
									{
										
										event.setDamage(15);
										attacker.sendMessage(ChatColor.RED+""+" you broke " +p.getName()+"'s guard!");
										
										p.sendMessage(ChatColor.RED+""+attacker.getName()+" broke your guard!");
										
									}
									else
									{
										event.setCancelled(true);
									}
									
								}
								
								
								else if(isPike(attacker))
								{
									
									if(saberBreak(attacker,2))
									{
										
										event.setDamage(3);
										attacker.sendMessage(ChatColor.RED+""+" you broke " +p.getName()+"'s guard!");
										
										p.sendMessage(ChatColor.RED+""+attacker.getName()+" broke your guard!");
										
									}
									else
									{
										event.setCancelled(true);
									}
									
								}
								else {
								
								event.setCancelled(true);

								}
							}
							else
							{
							
							
								event.setCancelled(true);
							
							}

						}
				
					}
					
					if(event.getDamager() instanceof Projectile)
					{
					
						Projectile proj = (Projectile)event.getDamager();
						
						if(proj.getShooter() instanceof LivingEntity)
						{
							LivingEntity shoot = (LivingEntity)proj.getShooter();
							if(p.getLocation().getDirection().dot(shoot.getLocation().getDirection()) < 0)
							{
								proj.setVelocity(p.getLocation().getDirection().multiply(-10));
								event.setCancelled(true);
							}
						}
						
						if(proj.getShooter() instanceof CraftBlockProjectileSource)
						{
							
							CraftBlockProjectileSource d = (CraftBlockProjectileSource)proj.getShooter();
							

								
						
							
							
								if(p.getLocation().getDirection().dot(d.getBlock().getLocation().getDirection()) < 0)
								{
									proj.setVelocity(p.getLocation().getDirection().multiply(-10));
									event.setCancelled(true);
								}
						}
							
					}
					
				}
				
				

				
				
				
				
				
			}
			
		
			
		}
		
	
	

	@EventHandler
	public void attackSaber(EntityDamageByEntityEvent event)
	{
		if(event.getEntity() instanceof LivingEntity)
		{
			if(event.getDamager() instanceof LivingEntity)
			{
				if(event.getDamager() instanceof Player)
				{
					Player p = (Player)event.getDamager();

			
					if(isSaber(p))
					{
						event.setDamage(25);
						
						
						if(getPowerLevel(p, "saberscrafted") == 0)
						{
							
							Levels.addexp(p, 100);
							setPowerLevel(p, "saberscrafted", 1);
							p.sendMessage(ChatColor.BLUE+"You Gained 100xp for using a Lightsaber");
							
						}
						
						
					}
					
					
					if(isPike(p))
					{
						event.setDamage(15);
						
						
						if(getPowerLevel(p, "saberscrafted") == 0)
						{
							
							Levels.addexp(p, 100);
							setPowerLevel(p, "saberscrafted", 1);
							p.sendMessage(ChatColor.BLUE+"You Gained 100xp for using a Lightsaber");
							
						}
						
						
					}
				}
			}
		}
		
		
	}
	
	
	
	
	@EventHandler
	public void pikeRush(PlayerInteractEntityEvent event)
	{
		
		Player p = event.getPlayer();
		
		if(!(event.getRightClicked() instanceof LivingEntity))
		{
			return;
		}
		
		LivingEntity e = (LivingEntity) event.getRightClicked();
		
		if(townyCheck((Entity)event.getPlayer(),event.getRightClicked()))
		{

			return;

		}
		
		
		
		if(isPike(p))
		{
			int ability = getPowerLevel(p, "pikerush");
			if(ability >= 1)
			{
				double damage = 4;
				int cooldown = 40;
				int knockback = 2;
				
				if(ability == 2)
				{
					damage = 7;
					cooldown = 20;
					knockback = 3;
					
				}
				if(ability == 3)
				{
					knockback = 4;
					damage = 10;
					cooldown = 15;
				}
				
				if(CM.checkPR(p))
				{
					
					
					
					if(canPvPHere(p.getLocation()))
					{
					
					p.sendMessage(ChatColor.GOLD+ "Pike Rush");

				
					e.setVelocity(p.getLocation().getDirection().multiply(knockback));
					p.setVelocity(p.getLocation().getDirection().multiply(2));
					e.damage(damage);
					
					
					
					CM.setPR(p, cooldown);
					
					}
					else
					{
						p.sendMessage(ChatColor.GOLD+ "You cannot do that here!");
					}
					
					
					
					
					
				}
				else
				{
					
					p.sendMessage(
							ChatColor.GOLD
									+ "You cannot use this for another "
									+ CM.getPR(p)
									+ " seconds!");
					
					
				}
				
				
			

			}
			

		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	@EventHandler
	public void updateConfig(PlayerJoinEvent event)
	{
		
		if(getPowerLevel(event.getPlayer(),"saberbreak") == -1)
		{
			System.out.println("Non-Updated Player Detected, Updating Config");
			
			setPowerLevel(event.getPlayer(), "saberbreak", 0);
			setPowerLevel(event.getPlayer(), "pikerush", 0);

		}
		
		
		
		
	}
	
	
	
	
	
	public boolean saberBreak(Player p, int multiplier)
	{
		
		int chance = 0;
		
		int level = getPowerLevel(p, "saberbreak");
		
		if(level == 1)
		{
			chance = 2;
		}
		if(level == 2)
		{
			chance = 5;
		}
		if(level == 3)
		{
			chance = 7;
		}
		
		chance*=multiplier;

		int random = (int)(Math.random() * (100 - 1) + 1);
		
		if(random <= chance)
		{
			return true;
		}
		
		return false;
	}
	
	
	
    
    public int getPowerLevel(Player p, String force)
    {
    	
    
    	
    	
    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
    	
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		int x = config.getInt(force,-1);
		
    	
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
    
	
	
	
			
	
    public static boolean townyCheck(Entity attack, Entity defense)
    {


    	
    	return com.palmergames.bukkit.towny.utils.CombatUtil.preventDamageCall(com.palmergames.bukkit.towny.Towny.getPlugin(), attack, defense);

    }
	
	

	

	
	
	
	
	

	

	
public static boolean canPvPHere(Location location) {
    RegionContainer container = com.sk89q.worldguard.WorldGuard.getInstance().getPlatform().getRegionContainer();
    RegionQuery query = container.createQuery();
    ApplicableRegionSet set = query.getApplicableRegions(BukkitAdapter.adapt(location));
    return set.testState(null, new StateFlag[] { Flags.PVP });
}
	
		
		
		
	
	


	
	
	
	
	
	
	
	
	

	
	
	

		
		
		
}
	
	
	
	
	
	
	

