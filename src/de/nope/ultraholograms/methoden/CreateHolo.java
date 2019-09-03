package de.nope.ultraholograms.methoden;

import de.nope.ultraholograms.Main;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CreateHolo {
  public static void createHoloLine(Player player, String Name, String Line1) {}
  
  public static void createHoloTest(Player player, String Name) {
    String NAMERAW = Name;
    Main.cfgholo.set(Name, Boolean.valueOf(true));
    Main.cfgholo.set(String.valueOf(Name) + ".Line1", "§7Hit me to Edit");
    String FIRSTNAME = Main.cfgholo.getString(String.valueOf(Name) + ".Line1");
    ArmorStand HOLOGRAM = (ArmorStand)player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
    HOLOGRAM.setGlowing(true);
    HOLOGRAM.setVisible(false);
    HOLOGRAM.setCustomNameVisible(true);
    HOLOGRAM.setCustomName(FIRSTNAME);
    HOLOGRAM.setAI(false);
    HOLOGRAM.setGravity(false);
    HOLOGRAM.setSilent(true);
    HOLOGRAM.setInvulnerable(true);
    HOLOGRAM.setSmall(true);
    Main.cfg.set("" + HOLOGRAM.getUniqueId(), "true");
    Main.SaveConfig();
  }
}
