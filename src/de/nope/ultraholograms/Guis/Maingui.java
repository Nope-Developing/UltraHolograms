package de.nope.ultraholograms.Guis;

import de.nope.ultraholograms.messages.messages;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Maingui {
  public static void openMainGui(Player player) {
    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0F, 3.0F);
    Inventory MainInv = Bukkit.createInventory(null, 45, "§eUltraHolograms " + messages.Version);
    ItemStack item = new ItemStack(Material.COMMAND_BLOCK, 1);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName("§cSettings");
    ArrayList<String> metalore = new ArrayList<String>();
    metalore.add("§aClick §7to open the Settings");
    metalore.add("§7");
    metalore.add("");
    meta.setLore(metalore);
    item.setItemMeta(meta);
    MainInv.setItem(40, item);
    ItemStack item3 = new ItemStack(Material.NAME_TAG, 1);
    ItemMeta meta3 = item3.getItemMeta();
    meta3.setDisplayName("§cHologramms");
    ArrayList<String> metalore3 = new ArrayList<String>();
    metalore3.add("§aClick §7to open a list");
    metalore3.add("§7of all §bHolograms");
    metalore3.add("");
    meta3.setLore(metalore3);
    item3.setItemMeta(meta3);
    MainInv.setItem(19, item3);
    player.openInventory(MainInv);
  }
}
