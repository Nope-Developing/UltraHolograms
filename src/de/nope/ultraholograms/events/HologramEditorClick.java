package de.nope.ultraholograms.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.nope.ultraholograms.Main;
import de.nope.ultraholograms.hashmaps.EditHash;

public class HologramEditorClick implements Listener {
	
	@EventHandler
	public void handleHoloEditorClick(InventoryClickEvent event) {
		if (event.getView().getTitle().contains("Hologram Editor")) {
			if (event.getCurrentItem() == null) {
				
			} else {
			if (event.getCurrentItem().getType() == Material.BARRIER) {
				event.setCancelled(true);
				if (EditHash.CurrentStand.containsKey(event.getWhoClicked())) {
					ArmorStand HOLO = EditHash.CurrentStand.get(event.getWhoClicked());
					HOLO.setCustomName("§cDeleting Holo ...");
					HOLO.setHealth(0);
					Main.cfgreload();
					if (Main.cfgholo.contains(HOLO.getUniqueId().toString())) {
						Main.cfgholo.set(HOLO.getUniqueId().toString(), null);
						Main.SaveholoConfig();
						
					}
					event.getWhoClicked().closeInventory();
				}
			}
				
			}
		}
	}

}
