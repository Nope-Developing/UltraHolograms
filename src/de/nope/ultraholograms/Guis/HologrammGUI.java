package de.nope.ultraholograms.Guis;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HologrammGUI {
  public static void openHoloGui(Player player) {
    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0F, 3.0F);
    Inventory MainInv = Bukkit.createInventory(null, 45, "§eUltraHolograms > Hologram List");
    ItemStack item4 = new ItemStack(Material.OAK_SIGN, 1);
    ItemMeta meta4 = item4.getItemMeta();
    meta4.setDisplayName("§cBack");
    ArrayList<String> metalore4 = new ArrayList<String>();
    metalore4.add("§aClick §7to go back");
    metalore4.add("§7§b");
    metalore4.add("");
    meta4.setLore(metalore4);
    item4.setItemMeta(meta4);
    MainInv.setItem(40, item4);
    player.openInventory(MainInv);
    ItemStack item3 = new ItemStack(Material.ANVIL, 1);
    ItemMeta meta3 = item3.getItemMeta();
    meta3.setDisplayName("§cCreate Hologram");
    ArrayList<String> metalore3 = new ArrayList<String>();
    metalore3.add("§aClick §7to create");
    metalore3.add("§7§bHolograms");
    metalore3.add("");
    meta3.setLore(metalore3);
    item3.setItemMeta(meta3);
    MainInv.setItem(43, item3);
    player.openInventory(MainInv);
  }
}
