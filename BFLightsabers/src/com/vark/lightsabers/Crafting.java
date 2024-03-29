package com.vark.lightsabers;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class Crafting implements Listener {

	public Crafting(main plugin) {

		plugin.getServer().getPluginManager().registerEvents((Listener) this,
				plugin);
		createRecipe();

	}

	private Plugin plugin = main.getPlugin(main.class);

	public void createRecipe() {

		ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK); 
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("An Elegant Weapon From A More Civilized Age"); 
		meta.setLore(lore);

		NamespacedKey key = new NamespacedKey(plugin, "lightsaber");//Normal Saber
		ShapedRecipe r = new ShapedRecipe(key, item);
		r.shape("***", "*N*", "*I*");
		r.setIngredient('*', Material.AIR);
		r.setIngredient('N', Material.NETHER_STAR);
		r.setIngredient('I', Material.IRON_BLOCK);

		plugin.getServer().addRecipe(r);

		NamespacedKey key2 = new NamespacedKey(plugin, "dlightsaber");//Double Saber
		ShapedRecipe rd = new ShapedRecipe(key2, item);
		rd.shape("***", "INI", "***");
		rd.setIngredient('*', Material.AIR);
		rd.setIngredient('N', Material.NETHER_STAR);
		rd.setIngredient('I', Material.IRON_BLOCK);

		plugin.getServer().addRecipe(rd);

		NamespacedKey key4 = new NamespacedKey(plugin, "clightsaber"); //Cross saber
		ShapedRecipe rc = new ShapedRecipe(key4, item);
		rc.shape("***", "INI", "*I*");
		rc.setIngredient('*', Material.AIR);
		rc.setIngredient('N', Material.NETHER_STAR);
		rc.setIngredient('I', Material.IRON_BLOCK);

		plugin.getServer().addRecipe(rc);
		
		NamespacedKey key7 = new NamespacedKey(plugin, "blightsaber");// Backwards saber
		ShapedRecipe rb = new ShapedRecipe(key7, item);
		rb.shape("***", "*I*", "*N*");
		rb.setIngredient('*', Material.AIR);
		rb.setIngredient('N', Material.NETHER_STAR);
		rb.setIngredient('I', Material.IRON_BLOCK);

		plugin.getServer().addRecipe(rb);

		ItemStack kc = new ItemStack(Material.NETHER_STAR); 
		ItemMeta kcmeta = kc.getItemMeta();
		ArrayList<String> kclore = new ArrayList<String>();
		kclore.add("A Shiny Crystal That Contains Unknown Powers...");
		kcmeta.setLore(kclore);
		kcmeta.setCustomModelData(30000101);
		kcmeta.setDisplayName(ChatColor.WHITE + "White Kyber Crystal");
		kc.setItemMeta(kcmeta);

		NamespacedKey key3 = new NamespacedKey(plugin, "KyberCrystal"); //Kyber Crystal
		ShapedRecipe kr = new ShapedRecipe(key3, kc);
		kr.shape("DDD", "DND", "DDD");
		kr.setIngredient('N', Material.NETHER_STAR);
		kr.setIngredient('D', Material.DIAMOND);

		plugin.getServer().addRecipe(kr);

		NamespacedKey key6 = new NamespacedKey(plugin, "KyberCrystalFromSaber"); //Crystal from saber
		ShapelessRecipe kcs = new ShapelessRecipe(key6, kc);
		kcs.addIngredient(Material.CARROT_ON_A_STICK);
		
		plugin.getServer().addRecipe(kcs);
		
		
		NamespacedKey key9 = new NamespacedKey(plugin, "KyberCrystalFromPike"); //Crystal from Pike
		ShapelessRecipe kcp = new ShapelessRecipe(key9, kc);
		kcp.addIngredient(Material.SCUTE);
		
		plugin.getServer().addRecipe(kcp);
		
		
		
		
		
		
		
		//Saber Pike
		
		ItemStack pike = new ItemStack(Material.SCUTE); 
		ItemMeta pikemeta = pike.getItemMeta();
		pikemeta.setCustomModelData(101);
		pikemeta.setUnbreakable(true);
		ArrayList<String> lorep = new ArrayList<String>();
		lorep.add("An Ancient Weapon of Specialists..."); 
		pikemeta.setLore(lorep);
		
		
		NamespacedKey pikerec = new NamespacedKey(plugin, "saberpike"); //Cross saber
		ShapedRecipe pikerc = new ShapedRecipe(pikerec, pike);
		pikerc.shape("*N*", "*I*", "*I*");
		pikerc.setIngredient('*', Material.AIR);
		pikerc.setIngredient('N', Material.NETHER_STAR);
		pikerc.setIngredient('I', Material.IRON_BLOCK);

		plugin.getServer().addRecipe(pikerc);
		
		


	}
	
	
	@EventHandler
	public void craftPike(PrepareItemCraftEvent e)
	{
		
		
		
		if(e.getInventory().getResult() != null)
		{
			if(e.getInventory().getResult().getType() == Material.SCUTE)
			{
				
				if(e.getInventory().getItem(1) != null)
				{
					
					return;
				}
				if(e.getInventory().getItem(3) != null)
				{
					return;
				}
				if(e.getInventory().getItem(4) != null)
				{
					return;
				}
				if(e.getInventory().getItem(6) != null)
				{
					return;
				}
				if(e.getInventory().getItem(7) != null)
				{
					return;
				}
				if(e.getInventory().getItem(9) != null)
				{
					return;
				}
				if(e.getInventory().getItem(2) == null)
				{
					return;
				}
				if(e.getInventory().getItem(5) == null)
				{
					return;
				}
				if(e.getInventory().getItem(8) == null)
				{
					return;
				}
				if(e.getInventory().getItem(5).getType() == Material.IRON_BLOCK)
				{
					
					if(e.getInventory().getItem(5).getAmount() == 1)
					{
						if(e.getInventory().getItem(8).getType() == Material.IRON_BLOCK)
						{
							if(e.getInventory().getItem(8).getAmount() == 1)
							{
								if(e.getInventory().getItem(2).getType() == Material.NETHER_STAR)
								{
									if(e.getInventory().getItem(2).getAmount() == 1)
									{
										
										
										ItemStack crystal = e.getInventory().getItem(2);
										if(crystal.hasItemMeta())
										{
											if(crystal.getItemMeta().hasCustomModelData())
											{
												
												
												int crystalId = crystal.getItemMeta().getCustomModelData();
												ItemStack sp = getPike(crystalId);
												
												e.getInventory().setResult(sp);
	
											}
											else {
												e.getInventory().setResult(null);
											}
											
										}
										else {
											e.getInventory().setResult(null);
										}
										
										
	
										
					
									}else {
										e.getInventory().setResult(null);
									}
								}
								else {
									e.getInventory().setResult(null);
								}
							}
							else {
								e.getInventory().setResult(null);
							}
						}
					}
				}
				
				
			}
		
		}
		
		
		
	}
	
	
	
	public ItemStack getPike(int cmd) {
		ItemStack pike = new ItemStack(Material.SCUTE); 
		ItemMeta meta = pike.getItemMeta();

		meta.setUnbreakable(true);
		ArrayList<String> lorep = new ArrayList<String>();
		lorep.add("An Ancient Weapon of Specialists..."); 
		meta.setLore(lorep);

		if (cmd == 30000001) {
			meta.setCustomModelData(104);
			meta.setDisplayName(ChatColor.GOLD + "Orange Saber-Pike");
		}

		if (cmd == 30000011) {
			meta.setCustomModelData(108);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Saber-Pike");
		}

		if (cmd == 30000111) {
			meta.setCustomModelData(105);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Saber-Pike");
		}

		if (cmd == 30001111) {
			meta.setCustomModelData(114);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Saber-Pike");
		}

		if (cmd == 30011111) {
			meta.setCustomModelData(101);
			meta.setDisplayName(ChatColor.BLUE + "Blue Saber-Pike");
		}

		if (cmd == 30111111) {
			meta.setCustomModelData(103);
			meta.setDisplayName(ChatColor.GREEN + "Green Saber-Pike");
		}

		if (cmd == 31111111) {
			meta.setCustomModelData(102);
			meta.setDisplayName(ChatColor.RED + "Red Saber-Pike");
		}

		if (cmd == 41111111) {
			meta.setCustomModelData(110);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magenta Saber-Pike");
		}

		if (cmd == 30000101) {
			meta.setCustomModelData(113);
			meta.setDisplayName(ChatColor.WHITE + "White Saber-Pike");
		}
		if (cmd == 51111111) {
			meta.setCustomModelData(109);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Saber-Pike");
		}
		if (cmd == 61111111) {
			meta.setCustomModelData(111);
			meta.setDisplayName(ChatColor.GOLD + "Amber Saber-Pike");
		}
		if (cmd == 71111111) {
			meta.setCustomModelData(112);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Saber-Pike");
		}
		
		if (cmd == 81111111) {
			meta.setCustomModelData(107);
			meta.setDisplayName(ChatColor.RED + "Lava Saber-Pike");
		}
		
		if (cmd == 91111111) {
			meta.setCustomModelData(106);
			meta.setDisplayName(ChatColor.YELLOW + "Lime Saber-Pike");
		}

		pike.setItemMeta(meta);

		return pike;
	}
	
	
	
	
	
	
	@EventHandler
	public void craftCrystal(PrepareItemCraftEvent e)
	{
		
		if(e.getInventory().getResult() != null)
		{
			if(e.getInventory().getResult().getType() == Material.NETHER_STAR)
			{
				if(e.getInventory().getItem(5).getType() != null || e.getInventory().getItem(5).getType() != Material.AIR)
				{
				
					if(e.getInventory().getItem(5).getType() == Material.NETHER_STAR )
					{
						if(e.getInventory().getItem(5).getItemMeta().hasCustomModelData())
						{
							e.getInventory().setResult(null);
						}

					}
				}
			
			}
		}
		
		
	}

	@EventHandler
	public void SaberDeconstruct(PrepareItemCraftEvent e) {
		for (int i = 0; i < e.getInventory().getSize(); i++) {
			if (e.getInventory().getItem(i) != null) {
				if(e.getInventory().getResult() != null)
				{
				if (e.getInventory().getResult()
						.getType() == Material.NETHER_STAR) {
					
					if (e.getInventory().getItem(i)
							.getType() == Material.CARROT_ON_A_STICK) {
					
						if (e.getInventory().getItem(i).getItemMeta()
								.hasCustomModelData()) {
							
							e.getInventory()
									.setResult(getSaberCrystal(e.getInventory()
											.getItem(i).getItemMeta()
											.getCustomModelData()));
							
							
						} else {
							e.getInventory().setResult(null);
						}
					}
					
					
					
					if (e.getInventory().getItem(i)
							.getType() == Material.SCUTE) {
					
						if (e.getInventory().getItem(i).getItemMeta()
								.hasCustomModelData()) {
							
							e.getInventory()
									.setResult(getPikeCrystal(e.getInventory()
											.getItem(i).getItemMeta()
											.getCustomModelData()));
							
							
						} else {
							e.getInventory().setResult(null);
						}
					}
					
					
					
					
					
					
					
					
					
					
					
				}
			}
			}

		}

	}
	@EventHandler(priority = EventPriority.HIGH)

	public void customCrafting(PrepareItemCraftEvent e) {

		boolean isStar = false;

		boolean iron1 = false;

		boolean iron2 = false;

		boolean iron3 = false;
		
		boolean isStar2 = false;
		boolean iron4 = false;

		for (int i = 0; i < e.getInventory().getSize(); i++) {
			if (e.getInventory().getItem(i) != null) {

				ItemStack item = e.getInventory().getItem(i);

				if (item.getType() == Material.NETHER_STAR)
				{
					if (i == 5)
						isStar = true;
					
					if(item.getAmount() != 1)
						isStar = false;
				}

				if (item.getType() == Material.IRON_BLOCK)
					if (i == 4)
						iron1 = true;

				if (item.getType() == Material.IRON_BLOCK)
					if (i == 6)
						iron2 = true;

				if (item.getType() == Material.IRON_BLOCK)
					if (i == 8)
						iron3 = true;
				if (item.getType() == Material.NETHER_STAR)
				{
					if (i == 8)
						isStar2 = true;
					
					if(item.getAmount() != 1)
						isStar2 = false;
				}
				if (item.getType() == Material.IRON_BLOCK)
					if (i == 5)
						iron4 = true;
				

			}

		}
		//Regular saber

		if (isStar && !iron1 && !iron2 && iron3 && !isStar2 && !iron4) {
			ItemStack item = e.getInventory().getItem(5);

			ItemMeta meta = item.getItemMeta();
			if (meta.hasCustomModelData()) {
				int b = meta.getCustomModelData();

				e.getInventory().setResult(getSaber(b));
				
				if(e.getInventory().getItem(1) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(3) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(4) != null)
				{
					e.getInventory().setResult(null);

				}
				
				
				
				if(e.getInventory().getItem(6) != null)
				{
					e.getInventory().setResult(null);

				}
				
				
				
				if(e.getInventory().getItem(7) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(2) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(9) != null)
				{
					e.getInventory().setResult(null);

				}
			} else
				e.getInventory().setResult(null);
		}

		if (isStar && iron1 && iron2 && !iron3 && !isStar2 && !iron4) {

			ItemStack item = e.getInventory().getItem(5);

			ItemMeta meta = item.getItemMeta();
			if (meta.hasCustomModelData()) {
				int b = meta.getCustomModelData();

				e.getInventory().setResult(getDSaber(b));
				
				
				if(e.getInventory().getItem(1) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(3) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(2) != null)
				{
					e.getInventory().setResult(null);

				}
				

				
				
				if(e.getInventory().getItem(7) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(8) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(9) != null)
				{
					e.getInventory().setResult(null);

				}
			} else
				e.getInventory().setResult(null);
		}

		//Cross Guard
		if ((isStar && (iron1 && iron2 && iron3 && !isStar2 && !iron4))) {
			if (e.getView().getPlayer().hasPermission("sabers.sl")) {

				ItemStack item = e.getInventory().getItem(5);

				ItemMeta meta = item.getItemMeta();
				if (meta.hasCustomModelData()) {
					int b = meta.getCustomModelData();

					e.getInventory().setResult(getCSaber(b));
					
					if(e.getInventory().getItem(1) != null)
					{
						e.getInventory().setResult(null);

					}
					
					if(e.getInventory().getItem(3) != null)
					{
						e.getInventory().setResult(null);

					}
					
					if(e.getInventory().getItem(2) != null)
					{
						e.getInventory().setResult(null);

					}
					

					
					
					if(e.getInventory().getItem(7) != null)
					{
						e.getInventory().setResult(null);

					}

					
					if(e.getInventory().getItem(9) != null)
					{
						e.getInventory().setResult(null);

					}
					
					
					
				} else
					e.getInventory().setResult(null);
			} else
				e.getInventory().setResult(null);

		}
		
		
		//Backwards
		if (!isStar && !iron1 && !iron2 && !iron3 && isStar2 && iron4) {

			ItemStack item = e.getInventory().getItem(8);

			ItemMeta meta = item.getItemMeta();
			if (meta.hasCustomModelData()) {
				int b = meta.getCustomModelData();

				e.getInventory().setResult(getBSaber(b));
				
				
				
				if(e.getInventory().getItem(1) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(3) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(2) != null)
				{
					e.getInventory().setResult(null);

				}
				
				if(e.getInventory().getItem(4) != null)
				{
					e.getInventory().setResult(null);

				}
				
				
				
				if(e.getInventory().getItem(6) != null)
				{
					e.getInventory().setResult(null);

				}
				
				
				
				if(e.getInventory().getItem(7) != null)
				{
					e.getInventory().setResult(null);

				}
				

				
				if(e.getInventory().getItem(9) != null)
				{
					e.getInventory().setResult(null);

				}
				
				
				
				
			} else
				e.getInventory().setResult(null);
		}
		
		

		

			
			


	}
	


	public ItemStack getSaber(int cmd) {
		ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("An Elegant Weapon From A More Civilized Age");
		meta.setLore(lore);

		if (cmd == 30000001) {
			meta.setCustomModelData(10000001);
			meta.setDisplayName(ChatColor.GOLD + "Orange Lightsaber");
		}

		if (cmd == 30000011) {
			meta.setCustomModelData(10000002);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Lightsaber");
		}

		if (cmd == 30000111) {
			meta.setCustomModelData(10000011);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Lightsaber");
		}

		if (cmd == 30001111) {
			meta.setCustomModelData(10000003);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Lightsaber");
		}

		if (cmd == 30011111) {
			meta.setCustomModelData(10000008);
			meta.setDisplayName(ChatColor.BLUE + "Blue Lightsaber");
		}

		if (cmd == 30111111) {
			meta.setCustomModelData(10000009);
			meta.setDisplayName(ChatColor.GREEN + "Green Lightsaber");
		}

		if (cmd == 31111111) {
			meta.setCustomModelData(10000007);
			meta.setDisplayName(ChatColor.RED + "Red Lightsaber");
		}

		if (cmd == 41111111) {
			meta.setCustomModelData(10000012);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magenta Lightsaber");
		}

		if (cmd == 30000101) {
			meta.setCustomModelData(10000013);
			meta.setDisplayName(ChatColor.WHITE + "White Lightsaber");
		}
		if (cmd == 51111111) {
			meta.setCustomModelData(10000035);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Lightsaber");
		}
		if (cmd == 61111111) {
			meta.setCustomModelData(10000029);
			meta.setDisplayName(ChatColor.GOLD + "Amber Lightsaber");
		}
		if (cmd == 71111111) {
			meta.setCustomModelData(10000032);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Lightsaber");
		}
		if (cmd == 81111111) {
			meta.setCustomModelData(10000054);
			meta.setDisplayName(ChatColor.RED + "Lava Lightsaber");
		}
		if (cmd == 91111111) {
			meta.setCustomModelData(10000058);
			meta.setDisplayName(ChatColor.YELLOW + "Lime Lightsaber");
		}

		item.setItemMeta(meta);

		return item;
	}

	public ItemStack getDSaber(int cmd) {
		ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("An Elegant Weapon From A More Civilized Age");
		meta.setLore(lore);

		if (cmd == 30000001) {
			meta.setCustomModelData(10000015);
			meta.setDisplayName(ChatColor.GOLD + "Orange Lightsaber");
		}

		if (cmd == 30000011) {
			meta.setCustomModelData(10000016);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Lightsaber");
		}

		if (cmd == 30000111) {
			meta.setCustomModelData(10000006);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Lightsaber");
		}

		if (cmd == 30001111) {
			meta.setCustomModelData(10000020);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Lightsaber");
		}

		if (cmd == 30011111) {
			meta.setCustomModelData(10000017);
			meta.setDisplayName(ChatColor.BLUE + "Blue Lightsaber");
		}

		if (cmd == 30111111) {
			meta.setCustomModelData(10000018);
			meta.setDisplayName(ChatColor.GREEN + "Green Lightsaber");
		}

		if (cmd == 31111111) {
			meta.setCustomModelData(10000005);
			meta.setDisplayName(ChatColor.RED + "Red Lightsaber");
		}

		if (cmd == 41111111) {
			meta.setCustomModelData(10000019);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magenta Lightsaber");
		}

		if (cmd == 30000101) {
			meta.setCustomModelData(10000014);
			meta.setDisplayName(ChatColor.WHITE + "White Lightsaber");
		}
		if (cmd == 51111111) {
			meta.setCustomModelData(10000036);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Lightsaber");
		}
		if (cmd == 61111111) {
			meta.setCustomModelData(10000030);
			meta.setDisplayName(ChatColor.GOLD + "Amber Lightsaber");
		}
		if (cmd == 71111111) {
			meta.setCustomModelData(10000033);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Lightsaber");
		}
		
		if (cmd == 81111111) {
			meta.setCustomModelData(10000055);
			meta.setDisplayName(ChatColor.RED + "Lava Lightsaber");
		}
		if (cmd == 91111111) {
			meta.setCustomModelData(10000059);
			meta.setDisplayName(ChatColor.YELLOW + "Lime Lightsaber");
		}

		item.setItemMeta(meta);

		return item;
	}

	public ItemStack getCSaber(int cmd) {
		ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("A Weapon of a Supreme Leader!");
		meta.setLore(lore);

		if (cmd == 30000001) {
			meta.setCustomModelData(10000024);
			meta.setDisplayName(ChatColor.GOLD + "Orange Lightsaber");
		}

		if (cmd == 30000011) {
			meta.setCustomModelData(10000025);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Lightsaber");
		}

		if (cmd == 30000111) {
			meta.setCustomModelData(10000023);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Lightsaber");
		}

		if (cmd == 30001111) {
			meta.setCustomModelData(10000027);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Lightsaber");
		}

		if (cmd == 30011111) {
			meta.setCustomModelData(10000021);
			meta.setDisplayName(ChatColor.BLUE + "Blue Lightsaber");
		}

		if (cmd == 30111111) {
			meta.setCustomModelData(10000022);
			meta.setDisplayName(ChatColor.GREEN + "Green Lightsaber");
		}

		if (cmd == 31111111) {
			meta.setCustomModelData(10000010);
			meta.setDisplayName(ChatColor.RED + "Red Lightsaber");
		}

		if (cmd == 41111111) {
			meta.setCustomModelData(10000026);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magenta Lightsaber");
		}

		if (cmd == 30000101) {
			meta.setCustomModelData(10000028);
			meta.setDisplayName(ChatColor.WHITE + "White Lightsaber");
		}
		if (cmd == 51111111) {
			meta.setCustomModelData(10000037);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Lightsaber");
		}
		if (cmd == 61111111) {
			meta.setCustomModelData(10000031);
			meta.setDisplayName(ChatColor.GOLD + "Amber Lightsaber");
		}
		if (cmd == 71111111) {
			meta.setCustomModelData(10000034);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Lightsaber");
		}
		
		if (cmd == 81111111) {
			meta.setCustomModelData(10000056);
			meta.setDisplayName(ChatColor.RED + "Lava Lightsaber");
		}
		
		if (cmd == 91111111) {
			meta.setCustomModelData(10000060);
			meta.setDisplayName(ChatColor.YELLOW + "Lime Lightsaber");
		}

		item.setItemMeta(meta);

		return item;
	}

	public ItemStack getSaberCrystal(int cmd) {

		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("A Shiny Crystal That Contains Unknown Powers...");
		meta.setLore(lore);
		

		if (cmd == 10000001) {
			meta.setCustomModelData(30000001);
			meta.setDisplayName(ChatColor.GOLD + "Orange Kyber Crystal");
		}

		if (cmd == 10000002) {
			meta.setCustomModelData(30000011);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Kyber Crystal");
		}

		if (cmd == 10000011) {
			meta.setCustomModelData(30000111);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Kyber Crystal");
		}

		if (cmd == 10000003) {
			meta.setCustomModelData(30001111);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Kyber Crystal");
		}

		if (cmd == 10000008) {
			meta.setCustomModelData(30011111);
			meta.setDisplayName(ChatColor.BLUE + "Blue Kyber Crystal");
		}

		if (cmd == 10000009) {
			meta.setCustomModelData(30111111);
			meta.setDisplayName(ChatColor.GREEN + "Green Kyber Crystal");
		}

		if (cmd == 10000007) {
			meta.setCustomModelData(31111111);
			meta.setDisplayName(ChatColor.RED + "Red Kyber Crystal");
		}

		if (cmd == 10000012) {
			meta.setCustomModelData(41111111);
			meta.setDisplayName(
					ChatColor.LIGHT_PURPLE + "Magenta Kyber Crystal");
		}

		if (cmd == 10000013) {
			meta.setCustomModelData(30000101);
			meta.setDisplayName(ChatColor.WHITE + "White Kyber Crystal");
		}
		if (cmd == 10000035) {
			meta.setCustomModelData(51111111);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Kyber Crystal");
		}
		if (cmd == 10000029) {
			meta.setCustomModelData(61111111);
			meta.setDisplayName(ChatColor.GOLD + "Amber Kyber Crystal");
		}
		if (cmd == 10000032) {
			meta.setCustomModelData(71111111);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Kyber Crystal");
		}

		if (cmd == 10000015) {
			meta.setCustomModelData(30000001);
			meta.setDisplayName(ChatColor.GOLD + "Orange Kyber Crystal");
		}

		if (cmd == 10000016) {
			meta.setCustomModelData(30000011);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Kyber Crystal");
		}

		if (cmd == 10000006) {
			meta.setCustomModelData(30000111);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Kyber Crystal");
		}

		if (cmd == 10000020) {
			meta.setCustomModelData(30001111);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Kyber Crystal");
		}

		if (cmd == 10000017) {
			meta.setCustomModelData(30011111);
			meta.setDisplayName(ChatColor.BLUE + "Blue Kyber Crystal");
		}

		if (cmd == 10000018) {
			meta.setCustomModelData(30111111);
			meta.setDisplayName(ChatColor.GREEN + "Green Kyber Crystal");
		}

		if (cmd == 10000005) {
			meta.setCustomModelData(31111111);
			meta.setDisplayName(ChatColor.RED + "Red Kyber Crystal");
		}

		if (cmd == 10000019) {
			meta.setCustomModelData(41111111);
			meta.setDisplayName(
					ChatColor.LIGHT_PURPLE + "Magenta Kyber Crystal");
		}

		if (cmd == 10000014) {
			meta.setCustomModelData(30000101);
			meta.setDisplayName(ChatColor.WHITE + "White Kyber Crystal");
		}
		if (cmd == 10000036) {
			meta.setCustomModelData(51111111);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Kyber Crystal");
		}
		if (cmd == 10000030) {
			meta.setCustomModelData(61111111);
			meta.setDisplayName(ChatColor.GOLD + "Amber Kyber Crystal");
		}
		if (cmd == 10000033) {
			meta.setCustomModelData(71111111);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Kyber Crystal");
		}

		if (cmd == 10000024) {
			meta.setCustomModelData(30000001);
			meta.setDisplayName(ChatColor.GOLD + "Orange Kyber Crystal");
		}

		if (cmd == 10000025) {
			meta.setCustomModelData(30000011);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Kyber Crystal");
		}

		if (cmd == 10000023) {
			meta.setCustomModelData(30000111);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Kyber Crystal");
		}

		if (cmd == 10000027) {
			meta.setCustomModelData(30001111);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Kyber Crystal");
		}

		if (cmd == 10000021) {
			meta.setCustomModelData(30011111);
			meta.setDisplayName(ChatColor.BLUE + "Blue Kyber Crystal");
		}

		if (cmd == 10000022) {
			meta.setCustomModelData(30111111);
			meta.setDisplayName(ChatColor.GREEN + "Green Kyber Crystal");
		}

		if (cmd == 10000010) {
			meta.setCustomModelData(31111111);
			meta.setDisplayName(ChatColor.RED + "Red Kyber Crystal");
		}

		if (cmd == 10000026) {
			meta.setCustomModelData(41111111);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magenta Kyber Crystal");
		}

		if (cmd == 10000028) {
			meta.setCustomModelData(30000101);
			meta.setDisplayName(ChatColor.WHITE + "White Kyber Crystal");
		}
		if (cmd == 10000037) {
			meta.setCustomModelData(51111111);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Kyber Crystal");
		}
		if (cmd == 10000031) {
			meta.setCustomModelData(61111111);
			meta.setDisplayName(ChatColor.GOLD + "Amber Kyber Crystal");
		}
		if (cmd == 10000034) {
			meta.setCustomModelData(71111111);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Kyber Crystal");
		}

		
		if (cmd == 10000045) {
			meta.setCustomModelData(30000001);
			meta.setDisplayName(ChatColor.GOLD + "Orange Kyber Crystal");
		}

		if (cmd == 10000047) {
			meta.setCustomModelData(30000011);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Kyber Crystal");
		}

		if (cmd == 10000051) {
			meta.setCustomModelData(30000111);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Kyber Crystal");
		}

		if (cmd == 10000050) {
			meta.setCustomModelData(30001111);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Kyber Crystal");
		}

		if (cmd == 10000043) {
			meta.setCustomModelData(30011111);
			meta.setDisplayName(ChatColor.BLUE + "Blue Kyber Crystal");
		}

		if (cmd == 10000042) {
			meta.setCustomModelData(30111111);
			meta.setDisplayName(ChatColor.GREEN + "Green Kyber Crystal");
		}

		if (cmd == 10000044) {
			meta.setCustomModelData(31111111);
			meta.setDisplayName(ChatColor.RED + "Red Kyber Crystal");
		}

		if (cmd == 10000048) {
			meta.setCustomModelData(41111111);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magenta Kyber Crystal");
		}

		if (cmd == 10000052) {
			meta.setCustomModelData(30000101);
			meta.setDisplayName(ChatColor.WHITE + "White Kyber Crystal");
		}
		if (cmd == 10000049) {
			meta.setCustomModelData(51111111);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Kyber Crystal");
		}
		if (cmd == 10000046) {
			meta.setCustomModelData(61111111);
			meta.setDisplayName(ChatColor.GOLD + "Amber Kyber Crystal");
			
		}
		if (cmd == 10000053) {
			meta.setCustomModelData(71111111);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Kyber Crystal");
		}
		
		if (cmd >= 10000054 && cmd <= 10000057) {
			meta.setCustomModelData(81111111);
			meta.setDisplayName(ChatColor.RED + "Lava Kyber Crystal");
		}
		
		
		if (cmd >= 10000058 && cmd <= 10000061) {
			meta.setCustomModelData(91111111);
			meta.setDisplayName(ChatColor.YELLOW + "Lime Kyber Crystal");
		}		
		item.setItemMeta(meta);

		return item;
	}


	public ItemStack getBSaber(int cmd) {
		ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("An Elegant Weapon From A More Civilized Age");
		meta.setLore(lore);

		if (cmd == 30000001) {
			meta.setCustomModelData(10000045);
			meta.setDisplayName(ChatColor.GOLD + "Orange Lightsaber");
		}

		if (cmd == 30000011) {
			meta.setCustomModelData(10000047);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Lightsaber");
		}

		if (cmd == 30000111) {
			meta.setCustomModelData(10000051);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Lightsaber");
		}

		if (cmd == 30001111) {
			meta.setCustomModelData(10000050);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Lightsaber");
		}

		if (cmd == 30011111) {
			meta.setCustomModelData(10000043);
			meta.setDisplayName(ChatColor.BLUE + "Blue Lightsaber");
		}

		if (cmd == 30111111) {
			meta.setCustomModelData(10000042);
			meta.setDisplayName(ChatColor.GREEN + "Green Lightsaber");
		}

		if (cmd == 31111111) {
			meta.setCustomModelData(10000044);
			meta.setDisplayName(ChatColor.RED + "Red Lightsaber");
		}

		if (cmd == 41111111) {
			meta.setCustomModelData(10000048);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magenta Lightsaber");
		}

		if (cmd == 30000101) {
			meta.setCustomModelData(10000052);
			meta.setDisplayName(ChatColor.WHITE + "White Lightsaber");
		}
		if (cmd == 51111111) {
			meta.setCustomModelData(10000049);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Lightsaber");
		}
		if (cmd == 61111111) {
			meta.setCustomModelData(10000046);
			meta.setDisplayName(ChatColor.GOLD + "Amber Lightsaber");
		}
		if (cmd == 71111111) {
			meta.setCustomModelData(10000053);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Lightsaber");
		}
		
		if (cmd == 81111111) {
			meta.setCustomModelData(10000057);
			meta.setDisplayName(ChatColor.RED + "Lava Lightsaber");
		}
		
		if (cmd == 91111111) {
			meta.setCustomModelData(10000061);
			meta.setDisplayName(ChatColor.YELLOW + "Lime Lightsaber");
		}


		item.setItemMeta(meta);

		return item;
	}



	public ItemStack getPikeCrystal(int cmd) {

		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("A Shiny Crystal That Contains Unknown Powers...");
		meta.setLore(lore);
		

		if (cmd == 104) {
			meta.setCustomModelData(30000001);
			meta.setDisplayName(ChatColor.GOLD + "Orange Kyber Crystal");
		}

		if (cmd == 108) {
			meta.setCustomModelData(30000011);
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cyan Kyber Crystal");
		}

		if (cmd == 105) {
			meta.setCustomModelData(30000111);
			meta.setDisplayName(ChatColor.YELLOW + "Yellow Kyber Crystal");
		}

		if (cmd == 114) {
			meta.setCustomModelData(30001111);
			meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Kyber Crystal");
		}

		if (cmd == 101) {
			meta.setCustomModelData(30011111);
			meta.setDisplayName(ChatColor.BLUE + "Blue Kyber Crystal");
		}

		if (cmd == 103) {
			meta.setCustomModelData(30111111);
			meta.setDisplayName(ChatColor.GREEN + "Green Kyber Crystal");
		}

		if (cmd == 102) {
			meta.setCustomModelData(31111111);
			meta.setDisplayName(ChatColor.RED + "Red Kyber Crystal");
		}

		if (cmd == 110) {
			meta.setCustomModelData(41111111);
			meta.setDisplayName(
					ChatColor.LIGHT_PURPLE + "Magenta Kyber Crystal");
		}

		if (cmd == 113) {
			meta.setCustomModelData(30000101);
			meta.setDisplayName(ChatColor.WHITE + "White Kyber Crystal");
		}
		if (cmd == 109) {
			meta.setCustomModelData(51111111);
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Kyber Crystal");
		}
		if (cmd == 111) {
			meta.setCustomModelData(61111111);
			meta.setDisplayName(ChatColor.GOLD + "Amber Kyber Crystal");
		}
		if (cmd == 112) {
			meta.setCustomModelData(71111111);
			meta.setDisplayName(ChatColor.AQUA + "Turquoise Kyber Crystal");
		}

		
		if (cmd == 107) {
			meta.setCustomModelData(81111111);
			meta.setDisplayName(ChatColor.RED + "Lava Kyber Crystal");
		}
		
		
		if (cmd == 106) {
			meta.setCustomModelData(91111111);
			meta.setDisplayName(ChatColor.YELLOW + "Lime Kyber Crystal");
		}		
		item.setItemMeta(meta);

		return item;
	}

















}
