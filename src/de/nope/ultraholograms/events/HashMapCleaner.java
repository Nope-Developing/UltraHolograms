package de.nope.ultraholograms.events;

import de.nope.ultraholograms.hashmaps.EditHash;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class HashMapCleaner implements Listener {
	@EventHandler
	public void handleHashMapCleaner(InventoryCloseEvent event) {
		if (event.getView().getTitle().contains("Hologram Editor") &&
				EditHash.CurrentStand.containsKey(event.getPlayer()))
			EditHash.CurrentStand.remove(event.getPlayer());
	}
}