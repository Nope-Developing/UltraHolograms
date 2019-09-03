package de.nope.ultraholograms.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.nope.ultraholograms.Main;
import de.nope.ultraholograms.Guis.ArmorStandEditor;
import de.nope.ultraholograms.hashmaps.EditHash;

public class HologramHitEditor implements Listener {
	@EventHandler
	public void handleArmorStandHit(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player) {
			Player player = (Player)event.getDamager();
			if (player.hasPermission("uh.edit") &&
					Main.cfgholo.contains(event.getEntity().getUniqueId().toString())) {
				ArmorStand HOLO = (ArmorStand)event.getEntity();
				EditHash.CurrentStand.put(player, HOLO);
				ArmorStandEditor.openHoloEditGui(player);
				if (HOLO.isGlowing())
					HOLO.setGlowing(false);
			}
		}
	}
}
