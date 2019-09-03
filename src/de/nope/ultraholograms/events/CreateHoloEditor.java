package de.nope.ultraholograms.events;

import de.nope.ultraholograms.hashmaps.EditHash;
import de.nope.ultraholograms.methoden.CreateHolo;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class CreateHoloEditor implements Listener {
  @EventHandler
  public void handleInCreatorChat(PlayerChatEvent event) {
    if (EditHash.HoloCreator.get(event.getPlayer()) != null)
      if (EditHash.HoloCreator.get(event.getPlayer()) != null && (
        (Boolean)EditHash.HoloCreator.get(event.getPlayer())).booleanValue()) {
        Player player = event.getPlayer();
        String NAME = event.getMessage();
        EditHash.HoloCreator.remove(player);
        CreateHolo.createHoloTest(player, NAME);
        event.setCancelled(true);
      }  
  }
}
