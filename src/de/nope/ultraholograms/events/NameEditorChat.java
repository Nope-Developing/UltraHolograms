package de.nope.ultraholograms.events;

import de.nope.ultraholograms.hashmaps.EditHash;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class NameEditorChat implements Listener {
  @EventHandler
  public void handleNameEditorChat(PlayerChatEvent event) {
    if (EditHash.NameEditor.containsKey(event.getPlayer())) {
      ArmorStand HOLO = (ArmorStand)EditHash.NameStand.get(event.getPlayer());
      
      if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
    	  String NAME = event.getMessage().replace("&", "§");
    	  event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 3);
          HOLO.setCustomName(NAME);
          event.setCancelled(true);
          EditHash.NameEditor.remove(event.getPlayer());
          EditHash.NameStand.remove(event.getPlayer());
      } else {
      String NAME = PlaceholderAPI.setPlaceholders(event.getPlayer(), event.getMessage());
      
      event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 3);
      HOLO.setCustomName(NAME);
      event.setCancelled(true);
      EditHash.NameEditor.remove(event.getPlayer());
      EditHash.NameStand.remove(event.getPlayer());
      }
    } 
  }
}
