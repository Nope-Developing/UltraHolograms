package de.nope.ultraholograms.events;

import de.nope.ultraholograms.Guis.HologrammGUI;
import de.nope.ultraholograms.Guis.SettingsGUI;
import de.nope.ultraholograms.hashmaps.EditHash;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainguiClick implements Listener {
  @SuppressWarnings("deprecation")
@EventHandler
  public void handleMaindGuiClick(InventoryClickEvent event) {
    if (event.getView().getTitle().contains("UltraHolograms") && 
      event.getCurrentItem() != null)
      if (event.getCurrentItem().getType() == Material.NAME_TAG) {
        if (event.getWhoClicked() instanceof Player) {
          Player player = (Player)event.getWhoClicked();
          player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0F, 3.0F);
          HologrammGUI.openHoloGui(player);
          event.setCancelled(true);
        } 
      } else {
        if (event.getWhoClicked() instanceof Player) {
          Player player = (Player)event.getWhoClicked();
          if (event.getCurrentItem().getType() == Material.ANVIL) {
            player.closeInventory();
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0F, 3.0F);
            player.sendTitle("�7Name your Hologram", "�eLeft Click to close");
            EditHash.HoloCreator.put(player, Boolean.valueOf(true));
          } else if (event.getCurrentItem().getType() == Material.COMMAND_BLOCK) {
            SettingsGUI.openMainGui(player);
          } 
        } 
        event.setCancelled(true);
      }  
  }
}
