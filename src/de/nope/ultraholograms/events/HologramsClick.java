package de.nope.ultraholograms.events;

import de.nope.ultraholograms.Guis.Maingui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class HologramsClick implements Listener {
  @EventHandler
  public void handleMaindGuiClick(InventoryClickEvent event) {
    if (event.getView().getTitle().contains("Hologram List")) {
      Player player = (Player)event.getWhoClicked();
      if (event.getCurrentItem() != null)
        if (event.getCurrentItem().getType() == Material.OAK_SIGN)
          Maingui.openMainGui(player);  
    } 
  }
}
