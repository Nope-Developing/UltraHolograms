package de.nope.ultraholograms.methoden;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import de.nope.ultraholograms.events.HologramEditorClick;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;

import de.nope.ultraholograms.Main;


public class CreateHolo  {
	
	 public static void createHoloLine(Player player, String Name, String Line1) {
			
		}

	

	
	
	
	
	public static void createHoloTest(Player player, String Name) {

		String NAMERAW = Name;
		Boolean exists = false;
		for (String x : Main.cfgholo.getKeys(false)) {

			if (Main.cfgholo.getString(x+".globalname").equalsIgnoreCase(Name)) {
				exists = true;
			}
		}

		if (exists == true) {
			player.sendMessage("§cThis Hologram with that name already exists");
		} else if (exists == false) {
			String FIRSTNAME = "§7Click me to §a§nEdit";

			ArmorStand HOLOGRAM = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);

			HOLOGRAM.setGlowing(true);
			HOLOGRAM.setVisible(false);
			HOLOGRAM.setCustomNameVisible(true);
			HOLOGRAM.setCustomName(FIRSTNAME);
			HOLOGRAM.setAI(false);
			HOLOGRAM.setGravity(false);
			HOLOGRAM.setSilent(true);
			HOLOGRAM.setInvulnerable(true);
			HOLOGRAM.setSmall(true);


			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Main.cfgholo.createSection(HOLOGRAM.getUniqueId().toString());
			Main.cfgholo.set(HOLOGRAM.getUniqueId().toString() + ".globalname", Name);
			Main.cfgholo.set(HOLOGRAM.getUniqueId().toString() + ".creator", player.getName());
			Main.cfgholo.set(HOLOGRAM.getUniqueId().toString() + ".lines", FIRSTNAME);
			Main.cfgholo.set(HOLOGRAM.getUniqueId().toString() + ".timecreated", format.format(now));
			Main.SaveholoConfig();


		}
	}
	
	

}
