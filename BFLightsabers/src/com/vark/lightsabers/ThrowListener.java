package com.vark.lightsabers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;

public class ThrowListener implements Listener
{

	
	
private Plugin plugin = main.getPlugin(main.class);
	
	
	
	

	public ThrowListener(main plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this,plugin);

	}
	
	
	
	
	
	//Mechanics
	
	
    public int getPowerLevel(Player p, String force)
    {
    	
    
    	
    	
    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
    	
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		int x = config.getInt(force);
    	
    	return x;
    	
    	
    	
    }
	

	
	
	@EventHandler
	public void throwSaber(PlayerDropItemEvent event)
	{
		
		
		
			Player p = event.getPlayer();
			
		if(checkSaber(event.getItemDrop().getItemStack(),p))
		{
			
			
				if(CM.checkCooldown(p))
				{
					if(getPowerLevel(p, "saberthrow") >= 1)
					{
						
						
						
						p.sendMessage(ChatColor.RED+"Threw Lightsaber!");
						CM.setCooldown(p, 6);
						ArmorStand as = p.getWorld().spawn(p.getLocation(),ArmorStand.class);
						as.setVisible(false);		
				
						ItemStack is = event.getItemDrop().getItemStack();
						as.setGravity(false);			
						as.setArms(true);
						as.getEquipment().setItemInMainHand(is);
				

						saberThrow(p,as,is);
						
						ItemStack emp = new ItemStack(Material.CARROT_ON_A_STICK);
						ItemMeta e = emp.getItemMeta();
						e.setCustomModelData(10000000);
						e.setDisplayName("Empty");
						emp.setItemMeta(e);
						
						p.getInventory().setItemInMainHand(emp);
						
						event.getItemDrop().remove();

					}
			
			
				}		
				else
				{
					p.sendMessage(ChatColor.RED+"You Cant Throw Your Saber For Another "+CM.getCooldown(p) +" seconds");
					event.setCancelled(true);
				}
			

		
		
		}

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void saberThrow(Player p,ArmorStand armorstand,ItemStack is)
	{
		
		
		new BukkitRunnable() {
			
			int a = 0;
	
			Location l = new Location(p.getLocation().getWorld(),p.getLocation().getX(),p.getLocation().getY()+1,p.getLocation().getZ(),p.getLocation().getYaw(),p.getLocation().getPitch());
			
			
			ArmorStand as = armorstand;

			
			@Override
			public void run() {
					
				if(a == 0)
				{
					l = l.clone().add(l.getDirection().multiply(1));
				}
				
					if(!(isAir(l)))
					{
						this.cancel();
						ItemStack emp = new ItemStack(Material.CARROT_ON_A_STICK);
						ItemMeta e = emp.getItemMeta();
						e.setCustomModelData(10000000);
						e.setDisplayName("Empty");
						emp.setItemMeta(e);
						
						p.getInventory().remove(emp);
						p.getInventory().addItem(is);
						as.remove();
						
					}
					else {

					a+=1;
					setArmorStand(as,l,p);
					l = l.clone().add(l.getDirection().multiply(a/2));

				if(a==11)
				{
					as.teleport(p.getLocation());
				}
				if(a == 12)
				{
					as.remove();
					if(!(p.isDead()))
					{
						ItemStack emp = new ItemStack(Material.CARROT_ON_A_STICK);
						ItemMeta e = emp.getItemMeta();
						e.setCustomModelData(10000000);
						e.setDisplayName("Empty");
						emp.setItemMeta(e);
						p.getInventory().remove(emp);
						p.getInventory().addItem(is);
					}else
					{
						if(canDropHere(p.getLocation()))
						{
							p.getWorld().dropItemNaturally(p.getLocation(), is);
						}
						else
						{
							ItemStack emp = new ItemStack(Material.CARROT_ON_A_STICK);
							ItemMeta e = emp.getItemMeta();
							e.setCustomModelData(10000000);
							e.setDisplayName("Empty");
							emp.setItemMeta(e);
							
							p.getInventory().remove(emp);
						
							p.getInventory().addItem(is);
							
						}
					}
					
					this.cancel();
				}
					}
				
				
				
			}
			

			
		}.runTaskTimer(plugin, 0L, 3L);
		
		
		
	}
	
	
	

	
	
	
	public void hitMob(ArmorStand as,Player p)
	{
		Location l = as.getLocation();
		if(l.getWorld().getNearbyEntities(l, 1, 1, 1).size() >0)
		{
			for(Entity e: l.getWorld().getNearbyEntities(l, 1, 1, 1))
			{
				
				if(e instanceof LivingEntity)
				{
					if(e instanceof Player)
					{
						int dmg = 10;
						if(canPvPHere(e.getLocation()))
						{
							if(!townyCheck((Entity)p, e))
							{
							
							if(getPowerLevel(p, "saberthrow") == 3)
							{
								dmg = 20;
							}
	
						
							Player p2 = (Player)e;
							if((isSaber(p2)))
							{
								if((p.getLocation().getDirection().dot(p2.getLocation().getDirection()) < 0))
								{
									//
								}
								else
								{
									if(!(p2.equals(p)))
									{
										p2.damage(dmg);
									}
								}
						
							}
							
							else
							{
								if(!(p2.equals(p)))
									p2.damage(dmg);
								
								
								
							
							}
						}
							
						}
						
						
					}
					else					
					{

						LivingEntity ent = (LivingEntity) e;
						ent.damage(15);
					}
					
				}
			}
			

				
			
			
		}
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setArmorStand(ArmorStand as,Location l,Player p)
	{

		as.teleport(l);
		as.setRightArmPose(new EulerAngle(0,as.getRightArmPose().getY()+45,0));	
		hitMob(as,p);
		if(getPowerLevel(p, "saberthrow") >= 2)
		{
			if(canBreakHere(l))	
				
				cutBlock(l);
			
		
		}
		
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Exploit Prevention
	
	
	
	
	@EventHandler
	public void cancelMove(final InventoryClickEvent event)
	{
		//event.getWhoClicked().sendMessage(event.getAction().toString());
		
		
		if(event.getAction() == InventoryAction.PICKUP_ALL)
		{
			if(event.getCurrentItem() != null)
			{
			if(checkSaber(event.getCurrentItem(), (Player)event.getWhoClicked()))
				event.setCancelled(true);
			}
			
		}
		
		
	}
	
	
	
	@EventHandler
	public void cancelDrop(final InventoryClickEvent event)
	{
		//event.getWhoClicked().sendMessage(event.getAction().toString());
		if(event.getCurrentItem() != null)
		{
		
		if(event.getAction() == InventoryAction.DROP_ALL_SLOT || event.getAction() == InventoryAction.DROP_ALL_CURSOR)
		{
			if(checkSaber(event.getCurrentItem(), (Player)event.getWhoClicked()))
				event.setCancelled(true);
			
			
		}
		}
		
		
	}
	
	
	
	
	
	
	@EventHandler
	public void cancelSwap(PlayerSwapHandItemsEvent event)
	{		
		if(isEmpty(event.getOffHandItem()))
			event.setCancelled(true);

	}
	
	
	
	
	
	@EventHandler
	public void cancelEmpty(PlayerDropItemEvent event)
	{
	
		ItemStack is = event.getItemDrop().getItemStack();
		
		if(isEmpty(is))
			event.setCancelled(true);

	}
	

	
	
	@EventHandler
	public void emptyClick(final InventoryClickEvent event)
	{
	
		ItemStack is = event.getCurrentItem();
		if(event.getCurrentItem() != null)
		{
		if(isEmpty(is))
			event.setCancelled(true);
		}
	}
			
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@EventHandler
	public void OnInteractAtEntity(PlayerInteractEntityEvent e) {
	
		if(e.getRightClicked() instanceof ArmorStand) {
	
			ArmorStand as = (ArmorStand)e;
			if(as.hasArms())
			{
				e.setCancelled(true);
			}
				
				
		}
	}
	
	@EventHandler
	public void dupeGlitch(PlayerArmorStandManipulateEvent event)
	{
		
		if(event.getRightClicked().hasArms())
		{
			//event.getPlayer().sendMessage("Denied");
			
			event.setCancelled(true);
	
		}

		
	}
	
	
	
	//Assistant Methods
	
	
	
	
	public boolean isEmpty(ItemStack is)
	{
		ItemMeta im = is.getItemMeta();
		if(is.getType() == Material.CARROT_ON_A_STICK)
		{
			if(im.hasCustomModelData());
			{
				if(im.getCustomModelData() == 10000000 )
				{
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	
	public boolean isSaber(Player p) 
	{

		if(!(p.isDead()))
		{
		
		
			if( !( (p.getInventory().getItemInMainHand().getType() == Material.AIR) || (p.getInventory().getItemInMainHand().getType() == null)) )
			{
				
				
				
				if(p.getInventory().getItemInMainHand().getType() != Material.SCUTE && p.getInventory().getItemInMainHand().getType() != Material.CARROT_ON_A_STICK)
				{
					return false;
				}
				
				
				if(p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
				{
					int a = p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
				
					
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
						
						if(a >= 100 && a <= 120)
						{
							return true;
						}
					
				}
			}
		}
		

		return false;
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
	
	
	
	
	
	
	
	public boolean isAir(Location l)
	{
	
		Location loc = new Location(l.getWorld(),l.getX(),l.getY()+0.5,l.getZ());
		Block b = loc.getBlock();
			
			if(b.getType() == Material.AIR)
			{
				
				return true;
				
			}
			if(b.getType() == Material.BAMBOO)
			{
				return true;
			}
			if(b.getType() == Material.CHORUS_PLANT)
			{
				return true;
			}
			if(b.getType() == Material.SUGAR_CANE)
			{
				return true;
			}
			if(b.getType() == Material.TALL_GRASS)
			{
				return true;
			}
			if(b.getType() == Material.SEAGRASS)
			{
				return true;
			}
			if(b.getType() == Material.KELP)
			{
				return true;
			}
			if(b.getType() == Material.TALL_SEAGRASS)
			{
				return true;
			}
			if(b.getType() == Material.CACTUS)
			{
				return true;
			}
			if(b.getType() == Material.VINE)
			{
				
				return true;
			}
			if(b.getType() == Material.WATER)
			{
				
				return true;
			}
			if(b.getType() == Material.LAVA)
			{
				
				return true;
			}
			if(b.getType() == Material.GRASS)
			{
				
				return true;
			}
			if(b.getType() == Material.REDSTONE)
			{
				
				return true;
			}
			
			
			
		
		
		return false;
		
		
		
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

public static boolean canBreakHere(Location location) {
    RegionContainer container = com.sk89q.worldguard.WorldGuard.getInstance().getPlatform().getRegionContainer();
    RegionQuery query = container.createQuery();
    ApplicableRegionSet set = query.getApplicableRegions(BukkitAdapter.adapt(location));
    return set.testState(null, new StateFlag[] { Flags.SOIL_DRY });
}

	
public static boolean canDropHere(Location location) {
    RegionContainer container = com.sk89q.worldguard.WorldGuard.getInstance().getPlatform().getRegionContainer();
    RegionQuery query = container.createQuery();
    ApplicableRegionSet set = query.getApplicableRegions(BukkitAdapter.adapt(location));
    return set.testState(null, new StateFlag[] { Flags.MYCELIUM_SPREAD });
}

	
public void cutBlock(Location l)
{

	for(Block b: getNearbyBlocks(l,2))
	{
	if(b.getType() == Material.BAMBOO)
	{
		b.breakNaturally();
	}
	if(b.getType() == Material.CHORUS_PLANT)
	{
		b.breakNaturally();
	}
	if(b.getType() == Material.SUGAR_CANE)
	{
		b.breakNaturally();
	}
	if(b.getType() == Material.TALL_GRASS)
	{
		b.breakNaturally();
	}
	if(b.getType() == Material.SEAGRASS)
	{
		b.breakNaturally();
	}
	if(b.getType() == Material.KELP)
	{
		b.breakNaturally();
	}
	if(b.getType() == Material.TALL_SEAGRASS)
	{
		b.breakNaturally();
	}
	if(b.getType() == Material.CACTUS)
	{
		b.breakNaturally();
	}
	if(b.getType() == Material.VINE)
	{
		
		b.breakNaturally();
	}
	
	
	
	
	}

}	
	
	
	

public static List<Block> getNearbyBlocks(Location location, int radius) {
    List<Block> blocks = new ArrayList<Block>();
    for(int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
        for(int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
            for(int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
               blocks.add(location.getWorld().getBlockAt(x, y, z));
            }
        }
    }
    return blocks;
}


	
	
	
	
}
