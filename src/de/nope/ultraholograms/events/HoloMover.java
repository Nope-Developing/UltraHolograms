package de.nope.ultraholograms.events;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import de.nope.ultraholograms.hashmaps.EditHash;

public class HoloMover implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void handleMoveHologram(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (EditHash.StandMove.containsKey(player)) {
			if (event.getItem() == null) {
				
			} else {
			if (event.getItem().getType() == Material.ARMOR_STAND) {
			event.setCancelled(true);
			
			ArmorStand HOLO = EditHash.StandMoving.get(player);
			player.setItemInHand(null);	
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, (float) 0.3);
			Location LOC = HOLO.getLocation();
			
			
			HOLO.teleport(player);
			
			
			EditHash.StandMoving.remove(player);
			EditHash.StandMove.remove(player);
			
			for (Player players : Bukkit.getOnlinePlayers()) {
				if (players.getName() == event.getPlayer().getName()) {
					
				} else {
				player.playSound(LOC, Sound.ENTITY_ENDERMAN_TELEPORT, 100, (float) 0.1);
				}
			}
			}
				
			}
		}
	}

}
