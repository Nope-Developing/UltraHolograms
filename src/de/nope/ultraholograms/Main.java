package de.nope.ultraholograms;

import java.io.File;
import java.io.IOException;
import java.util.List;

import de.nope.ultraholograms.events.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.nope.ultraholograms.commands.UholoCMD;


public class Main extends JavaPlugin {


	public static File players = new File("plugins/UltraHolograms", "messages.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(players);

	public static File holo = new File("plugins/UltraHolograms", "holograms.yml");
	public static FileConfiguration cfgholo = YamlConfiguration.loadConfiguration(holo);


	public static File customConfigFile;
	public static FileConfiguration customConfig;








	public void onEnable() {







		PluginManager pluginManager = Bukkit.getPluginManager();

		createCustomConfig("messages.yml");
		cfgreload();
		createCustomConfig("holograms.yml");
		cfgreload();



		// Commands

		getCommand("uholo").setExecutor(new UholoCMD());

		// Events

		pluginManager.registerEvents(new MainguiClick(), this);
		pluginManager.registerEvents(new CreateHoloEditor(), this);
		pluginManager.registerEvents(new SettingsClick(), this);
		pluginManager.registerEvents(new HologramsClick(), this);
		pluginManager.registerEvents(new HologramHitEditor(), this);
		pluginManager.registerEvents(new HologramEditorClick(), this);
		pluginManager.registerEvents(new NameEditorChat(), this);
		pluginManager.registerEvents(new HoloMover(), this);



	}


	 public void onDisable() {

	 }

	 private void createCustomConfig(String name) {


		    customConfigFile = new File(getDataFolder(), name);
		    if (!customConfigFile.exists()) {
		        customConfigFile.getParentFile().mkdirs();
		        saveResource(name, false);
		    }

		    customConfig= new YamlConfiguration();
		    try {
		        customConfig.load(customConfigFile);
		    } catch (IOException | InvalidConfigurationException e) {
		        e.printStackTrace();
		    }
		    }

	 public static void cfgreload() {
	    	cfg = YamlConfiguration.loadConfiguration(players);
	    	cfgholo = YamlConfiguration.loadConfiguration(holo);
	    }
	 public static void cgholoreload() {
	    	cfg = YamlConfiguration.loadConfiguration(holo);
	 }

	 public static void SaveConfig() {
			try {
				Main.cfg.save(Main.players);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }



	 public static void SaveholoConfig() {
			try {
				Main.cfgholo.save(Main.holo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }



















}
