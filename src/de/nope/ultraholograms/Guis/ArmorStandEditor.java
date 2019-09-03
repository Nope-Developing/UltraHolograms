package de.nope.ultraholograms.Guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ArmorStandEditor {
	
	public static void openHoloEditGui(Player player) {
		player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 3);
		
		
		
		
		Inventory MainInv =	Bukkit.createInventory(null, 5*9, ("§eHologram Editor"));
		
		
		
		ItemStack item4 = new ItemStack(Material.BARRIER, 1);
		ItemMeta meta4 = item4.getItemMeta();
		meta4.setDisplayName(("§cRemove Hologram"));
		ArrayList<String> metalore4 = new ArrayList<String>();   
		
		metalore4.add("§aClick §7to remove the");
		metalore4.add("§7§bHologram");
		metalore4.add("");
		meta4.setLore(metalore4);
			
		item4.setItemMeta(meta4);
		MainInv.setItem(24, item4);	
		player.openInventory(MainInv);
		
		ItemStack item5 = new ItemStack(Material.PAPER, 1);
		ItemMeta meta5 = item5.getItemMeta();
		meta5.setDisplayName(("§cLine Editor"));
		ArrayList<String> metalore5 = new ArrayList<String>();   
		
		metalore5.add("§aRightclick §7to rename the");
		metalore5.add("§7first §bLine");
		metalore5.add("");
		meta5.setLore(metalore5);
			
		item5.setItemMeta(meta5);
		MainInv.setItem(4, item5);	
		player.openInventory(MainInv);
		
	}

}
