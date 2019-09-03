package de.nope.ultraholograms.events;

import de.nope.ultraholograms.Guis.Maingui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingsClick implements Listener {
  @EventHandler
  public void handleMaindGuiClick(InventoryClickEvent event) {
    if (event.getView().getTitle().contains("Settings")) {
      Player player = (Player)event.getWhoClicked();
      if (event.getCurrentItem() != null)
        if (event.getCurrentItem().getType() == Material.OAK_SIGN)
          Maingui.openMainGui(player);  
    } 
  }
}
