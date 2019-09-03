package de.nope.ultraholograms.Guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class SettingsGUI {
	
	
	public static void openMainGui(Player player) {
		
		player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 3);
		Inventory MainInv =	Bukkit.createInventory(null, 5*9, (ChatColor.RED + "§eUltraHolograms > Settings "));
		
		ItemStack item = new ItemStack(Material.OAK_SIGN, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(("§cBack"));
		ArrayList<String> metalore = new ArrayList<String>();   
		
		metalore.add("§aClick §7to go back");
		metalore.add("§7");
		metalore.add("");
		meta.setLore(metalore);
			
		item.setItemMeta(meta);
		MainInv.setItem(40, item);	
		player.openInventory(MainInv);
	}

}
