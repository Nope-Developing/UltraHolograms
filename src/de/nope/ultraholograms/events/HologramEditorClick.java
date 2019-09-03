package de.nope.ultraholograms.events;

import de.nope.ultraholograms.Main;
import de.nope.ultraholograms.hashmaps.EditHash;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HologramEditorClick implements Listener {
	@EventHandler
	public void handleHoloEditorClick(InventoryClickEvent event) {
		if (event.getView().getTitle().contains("Hologram Editor") &&
				event.getCurrentItem() != null)
			if (event.getCurrentItem().getType() == Material.BARRIER) {
				event.setCancelled(true);
				if (EditHash.CurrentStand.containsKey(event.getWhoClicked())) {
					ArmorStand HOLO = (ArmorStand)EditHash.CurrentStand.get(event.getWhoClicked());
					HOLO.setCustomName("§cDeleting Holo ...");
					HOLO.setHealth(0.0D);
					if (Main.cfgholo.contains(HOLO.getUniqueId().toString()))
						Main.cfgholo.set(HOLO.getUniqueId().toString(), null);
					Main.SaveholoConfig();
					event.getWhoClicked().closeInventory();
				}
			} else if (event.getCurrentItem().getType() == Material.PAPER) {
				event.setCancelled(true);
				if (event.getClick() == ClickType.RIGHT) {
					ArmorStand HOLO = (ArmorStand)EditHash.CurrentStand.get(event.getWhoClicked());
					EditHash.NameEditor.put((Player)event.getWhoClicked(), Boolean.valueOf(true));
					EditHash.NameStand.put((Player)event.getWhoClicked(), HOLO);
					event.getWhoClicked().closeInventory();
					Player player = (Player)event.getWhoClicked();
					player.sendTitle("§7Set the Line 1", "§eLeft");
				}
			}  else if (event.getCurrentItem().getType() == Material.ARMOR_STAND)  {
				Player player = (Player) event.getWhoClicked();
				ArmorStand HOLO = EditHash.CurrentStand.get(player);
				EditHash.StandMoving.put(player, HOLO);
				EditHash.StandMove.put(player, true);

				player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 3);
				ItemStack item3 = new ItemStack(Material.ARMOR_STAND, 1);
				ItemMeta meta3 = item3.getItemMeta();
				meta3.setDisplayName(HOLO.getCustomName());
				ArrayList<String> metalore3 = new ArrayList<String>();
				metalore3.add("");
				metalore3.add("§aRightclick §7to move the");
				metalore3.add("§7§bHologram ");
				metalore3.add("§7");
				metalore3.add("");
				metalore3.add("§aLines §7:");
				metalore3.add(HOLO.getCustomName());
				meta3.setLore(metalore3);
				item3.setItemMeta(meta3);
				player.getInventory().addItem(item3);
				player.closeInventory();
				player.sendTitle("§7Place the Armorstand", "§eTo move the Hologram");

			}


	}
}