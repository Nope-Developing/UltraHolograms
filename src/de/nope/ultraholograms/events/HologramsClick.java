package de.nope.ultraholograms.events;

import de.nope.ultraholograms.Guis.ArmorStandEditor;
import de.nope.ultraholograms.Main;
import de.nope.ultraholograms.hashmaps.EditHash;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.nope.ultraholograms.Guis.Maingui;

import java.util.ArrayList;
import java.util.UUID;

public class HologramsClick implements Listener {
	

	

	
	@EventHandler
	public void handleMaindGuiClick(InventoryClickEvent event) {
		if (event.getView().getTitle().contains("Hologram List")) {
			Player player = (Player) event.getWhoClicked();
		if (event.getCurrentItem() == null) {
			
			
			
		} else {
			if (event.getSlot() == 46) {
				Maingui.openMainGui(player);
				
				
			} else {
				ArrayList<String> temporaryList = new ArrayList<String>();
				for (String x : Main.cfgholo.getKeys(false)) {
					temporaryList.add(x);
				}
				for (int i=0; i<temporaryList.size(); i++) {
				if (event.getSlot() == i) {
					ArmorStand HOLO = (ArmorStand) Bukkit.getEntity(UUID.fromString(temporaryList.get(i)));
					EditHash.CurrentStand.put(player, HOLO);
					ArmorStandEditor.openHoloEditGui(player);
					if (HOLO.isGlowing())
						HOLO.setGlowing(false);
				}
				}



			}
		}
			
		}
			
		}
	


}



