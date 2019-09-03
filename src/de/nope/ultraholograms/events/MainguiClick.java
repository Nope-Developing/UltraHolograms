package de.nope.ultraholograms.events;

import de.nope.ultraholograms.Guis.ArmorStandEditor;
import de.nope.ultraholograms.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.nope.ultraholograms.Guis.HologrammGUI;
import de.nope.ultraholograms.Guis.SettingsGUI;
import de.nope.ultraholograms.hashmaps.EditHash;

import java.util.ArrayList;
import java.util.UUID;

public class MainguiClick implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void handleMaindGuiClick(InventoryClickEvent event) {
		if (event.getView().getTitle().contains("UltraHolograms")) {
		if (event.getCurrentItem() == null) {
			
		} else {



			if (event.getCurrentItem().getType() == Material.NAME_TAG) {
				if (event.getWhoClicked() instanceof Player) {
					Player player = (Player) event.getWhoClicked();
					player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 3);
					HologrammGUI.openHoloGui(player);
					event.setCancelled(true);
				}
			} else {
				if (event.getWhoClicked() instanceof Player) {
					Player player = (Player) event.getWhoClicked();
					if (event.getCurrentItem().getType() == Material.ANVIL) {
						
					
						player.closeInventory();
						player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 3);
						player.sendTitle("§7Name your Hologram", "§eLeft Click to close");
						EditHash.HoloCreator.put(player, true);
						
					}else {
						if (event.getCurrentItem().getType() == Material.COMMAND_BLOCK) {
							SettingsGUI.openMainGui(player);
							
						} else {
						
						//Other ITems
						}
					}
						
						
					}
				event.setCancelled(true);
			}
			
		}
		}
		
	}

}
