package de.nope.ultraholograms.Guis;

import java.util.ArrayList;
import java.util.UUID;

import de.nope.ultraholograms.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HologrammGUI {
	
	public static void openHoloGui(Player player) {
		Main.cgholoreload();
		player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 3);
		
		
		
		
		Inventory MainInv =	Bukkit.createInventory(null, 5*9, ("§eUltraHolograms > Hologram List"));
		
		
		
		ItemStack item4 = new ItemStack(Material.OAK_SIGN, 1);
		ItemMeta meta4 = item4.getItemMeta();
		meta4.setDisplayName(("§cBack"));
		ArrayList<String> metalore4 = new ArrayList<String>();   
		
		metalore4.add("§aClick §7to go back");
		metalore4.add("§7§b");
		metalore4.add("");
		meta4.setLore(metalore4);
			
		item4.setItemMeta(meta4);
		MainInv.setItem(40, item4);	

		
		
		
		
		ItemStack item3 = new ItemStack(Material.ANVIL, 1);
		ItemMeta meta3 = item3.getItemMeta();
		meta3.setDisplayName(("§cCreate Hologram"));
		ArrayList<String> metalore3 = new ArrayList<String>();   
		
		metalore3.add("§aClick §7to create");
		metalore3.add("§7§bHolograms");
		metalore3.add("");
		meta3.setLore(metalore3);
			
		item3.setItemMeta(meta3);
		MainInv.setItem(43, item3);	
		player.openInventory(MainInv);
		int count = 0;
		for (String x :Main.cfgholo.getKeys(false)) {

			count++;

			player.sendMessage("Nummer "+count+": "+x);

			ItemStack tempitem = new ItemStack(Material.OAK_SIGN, 1);
			ItemMeta tempitemmeta = tempitem.getItemMeta();
			tempitemmeta.setDisplayName("§c"+Main.cfgholo.getString(x+".globalname"));
			ArrayList<String> tempitemlore = new ArrayList<String>();

			tempitemlore.add("§7UUID: §e"+x);
			tempitemlore.add("§7Location: §e"+Bukkit.getEntity(UUID.fromString(x)).getLocation().getBlockX()+" "+Bukkit.getEntity(UUID.fromString(x)).getLocation().getBlockY()+" "+Bukkit.getEntity(UUID.fromString(x)).getLocation().getBlockZ());
			tempitemlore.add("§7World: §e"+Bukkit.getEntity(UUID.fromString(x)).getWorld().getName());
			Main.cgholoreload();
			tempitemlore.add("§7Created by: §e"+Main.cfgholo.getString(x+".creator"));
			tempitemlore.add("§7Created on: §e"+Main.cfgholo.getString(x+".timecreated"));

			tempitemmeta.setLore(tempitemlore);

			tempitem.setItemMeta(tempitemmeta);
			MainInv.setItem(count-1, tempitem);

		}
		player.openInventory(MainInv);
	}

		
}






