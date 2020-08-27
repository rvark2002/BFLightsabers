package com.vark.lightsabers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class TurningSaberListener implements Listener
{

	
	
	private Plugin plugin = main.getPlugin(main.class);
	
	
	
	

	public TurningSaberListener(main plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this,plugin);
		

	}
	
	
	@EventHandler
	public void onSaberOff(PlayerInteractEvent event)
	{
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			Player p = (Player)event.getPlayer();
			
			
			
			if(isSaber(p))
			{
				
				if(p.getInventory().getItemInOffHand() == null || p.getInventory().getItemInOffHand().getType() == Material.AIR)
				{
					
					if(CM.checkCSI(p))
					{
						retractSaber(p);
						p.sendMessage(ChatColor.GOLD+"You Turned Your Lightsaber Off");
					}
	
					
				}

			}
		}
		
		
		
		
	}
	
	
	@EventHandler
	public void onSaberOn(PlayerInteractEvent event)
	{
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			Player p = (Player)event.getPlayer();
			
			
			
			if(isHilt(p))
			{
				
				
				if(p.getInventory().getItemInOffHand() == null || p.getInventory().getItemInOffHand().getType() == Material.AIR)
				{
					if(CM.checkCSI(p))
					{
						igniteSaber(p);
						p.sendMessage(ChatColor.GOLD+"You Turned Your Lightsaber On");
					
						
					}
	
					
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
		
		
		
		return a;
		
		
		
		
	}
	
	
	
	public boolean isCrossHilt(int c)
	{

		if(c >= 150 && c <= 180)
			return true;

		return false;

		
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
				
					if((p.getInventory().getItemInMainHand().getType() != Material.CARROT_ON_A_STICK))
						return false;
					
					
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
			}
		}
		

		return false;
	}

	
	
	public boolean isHilt(Player p) 
	{

		if(!(p.isDead()))
		{
		
		
			if( !( (p.getInventory().getItemInMainHand().getType() == Material.AIR) || (p.getInventory().getItemInMainHand().getType() == null)) )
			{
				if(p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
				{
					int a = p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
					
					if((p.getInventory().getItemInMainHand().getType() != Material.CARROT_ON_A_STICK))
						return false;
					
						if(a >= 100 && a <= 1000)
						{
							if(isCrossHilt(a))
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
			}
		}
		

		return false;
	}
	
	
	
	
	
	
	public void retractSaber(Player p)
	{
		
		ItemMeta im = p.getInventory().getItemInMainHand().getItemMeta();
		
		im.setCustomModelData(getHilt(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData()));
		if(im.getCustomModelData() != 0)
		{
			p.getInventory().getItemInMainHand().setItemMeta(im);
			CM.setCSI(p, 1);
		}
		
		
		
	}
	
	
	public void igniteSaber(Player p)
	{
		
		ItemMeta im = p.getInventory().getItemInMainHand().getItemMeta();
		
		im.setCustomModelData(getSaber(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData()));
		if(im.getCustomModelData() != 0)
		{
			p.getInventory().getItemInMainHand().setItemMeta(im);
			CM.setCSI(p, 1);
		}
		
		
		
	}
	
	
	
	public int getHilt(int cmd)
	{
		if(cmd == 10000008)//blue
		{
			return 101;
		}
		else if(cmd == 10000029)//amber
		{
			return 102;
		}
		else if(cmd == 10000007)//red
		{
			return 106;
		}
		else if(cmd == 10000001)//orange
		{
			return 103;
		}
		else if(cmd == 10000011)//yellow
		{
			return 104;
		}
		else if(cmd == 10000009)//green
		{
			return 105;
		}
		else if(cmd == 10000003)//purple
		{
			return 107;
		}
		else if(cmd == 10000035)//pink
		{
			return 108;
		}
		else if(cmd == 10000002)//cyan
		{
			return 109;
		}
		else if(cmd == 10000032)//turquoise
		{
			return 110;
		}
		else if(cmd == 10000013)//white
		{
			return 111;
		}
		else if(cmd == 10000012)//magenta
		{
			return 112;
		}
		else if(cmd == 10000004)//dark
		{
			return 113;
		}
		else if(cmd == 10000017)
			return 114;
		else if(cmd == 10000030)
			return 115;
		else if(cmd == 10000015)
			return 116;
		else if(cmd == 10000006)
			return 117;
		else if(cmd == 10000018)
			return 118;
		else if(cmd == 10000005)
			return 119;
		else if(cmd == 10000020)
			return 120;
		else if(cmd == 10000036)
			return 121;
		else if(cmd == 10000016)
			return 122;
		else if(cmd == 10000033)
			return 123;
		else if(cmd == 10000014)
			return 124;
		else if(cmd == 10000019)
			return 125;
		
		else if(cmd == 10000044)
			return 131;
		else if(cmd == 10000045)
			return 128;
		else if(cmd == 10000046)
			return 127;
		else if(cmd == 10000047)
			return 134;
		else if(cmd == 10000048)
			return 137;
		else if(cmd == 10000049)
			return 133;
		else if(cmd == 10000050)
			return 132;
		else if(cmd == 10000051)
			return 129;
		else if(cmd == 10000052)
			return 136;
		else if(cmd == 10000053)
			return 135;
		else if(cmd == 10000043)
			return 126;
		else if(cmd == 10000042)
			return 130;
		
		
		else if(cmd == 10000021)
			return 138;
		else if(cmd == 10000031)
			return 139;
		else if(cmd == 10000024)
			return 140;
		else if(cmd == 10000023)
			return 141;
		else if(cmd == 10000022)
			return 142;
		else if(cmd == 10000010)
			return 143;
		else if(cmd == 10000027)
			return 144;
		else if(cmd == 10000037)
			return 145;
		else if(cmd == 10000025)
			return 146;
		else if(cmd == 10000034)
			return 147;
		else if(cmd == 10000028)
			return 148;
		else if(cmd == 10000026)
			return 149;
		
		else {
			return 0;
		}
		
		
	}
	public int getSaber(int cmd)
	{
		//SINGLE SABERS
		if(cmd == 101)
			return 10000008;
		else if(cmd == 102)
			return 10000029;
		else if(cmd == 103)
			return 10000001;
		else if(cmd == 104)
			return 10000011;
		else if(cmd == 105)
			return 10000009;
		else if(cmd == 106)
			return 10000007;
		else if(cmd == 107)
			return 10000003;
		else if(cmd == 108)
			return 10000035;
		else if(cmd == 109)
			return 10000002;
		else if(cmd == 110)
			return 10000032;
		else if(cmd == 111)
			return 10000013;
		else if(cmd == 112)
			return 10000012;
		else if(cmd == 113)
			return 10000004;
		
		//DOUBLE SABERS
		if(cmd == 114)
			return 10000017;
		else if(cmd == 115)
			return 10000030;
		else if(cmd == 116)
			return 10000015;
		else if(cmd == 117)
			return 10000006;
		else if(cmd == 118)
			return 10000018;
		else if(cmd == 119)
			return 10000005;
		else if(cmd == 120)
			return 10000020;
		else if(cmd == 121)
			return 10000036;
		else if(cmd == 122)
			return 10000016;
		else if(cmd == 123)
			return 10000033;
		else if(cmd == 124)
			return 10000014;
		else if(cmd == 125)
			return 10000019;
		
		//Backwards
		if(cmd == 131)
			return 10000044;
		else if(cmd == 128)
			return 10000045;
		else if(cmd == 127)
			return 10000046;
		else if(cmd == 134)
			return 10000047;
		else if(cmd == 137)
			return 10000048;
		else if(cmd == 133)
			return 10000049;
		else if(cmd == 132)
			return 10000050;
		else if(cmd == 129)
			return 10000051;
		else if(cmd == 136)
			return 10000052;
		else if(cmd == 135)
			return 10000053;
		else if(cmd == 126)
			return 10000043;
		else if(cmd == 130)
			return 10000042;
		//Cross Guard
		if(cmd == 138)
			return 10000021;
		else if(cmd == 139)
			return 10000031;
		else if(cmd == 140)
			return 10000024;
		else if(cmd == 141)
			return 10000023;
		else if(cmd == 142)
			return 10000022;
		else if(cmd == 143)
			return 10000010;
		else if(cmd == 144)
			return 10000027;
		else if(cmd == 145)
			return 10000037;
		else if(cmd == 146)
			return 10000025;
		else if(cmd == 147)
			return 10000034;
		else if(cmd == 148)
			return 10000028;
		else if(cmd == 149)
			return 10000026;
		
		else
			return 0;
	}
	
}
