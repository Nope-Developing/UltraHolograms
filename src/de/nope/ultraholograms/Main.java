package de.nope.ultraholograms;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.nope.ultraholograms.commands.UholoCMD;
import de.nope.ultraholograms.events.CreateHoloEditor;
import de.nope.ultraholograms.events.HoloMover;
import de.nope.ultraholograms.events.HologramEditorClick;
import de.nope.ultraholograms.events.HologramHitEditor;
import de.nope.ultraholograms.events.HologramsClick;
import de.nope.ultraholograms.events.MainguiClick;
import de.nope.ultraholograms.events.NameEditorChat;
import de.nope.ultraholograms.events.SettingsClick;

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
    getCommand("uholo").setExecutor(new UholoCMD());
    pluginManager.registerEvents(new MainguiClick(), this);
    pluginManager.registerEvents(new CreateHoloEditor(), this);
    pluginManager.registerEvents(new SettingsClick(), this);
    pluginManager.registerEvents(new HologramsClick(), this);
    pluginManager.registerEvents(new HologramHitEditor(), this);
    pluginManager.registerEvents(new HologramEditorClick(), this);
    pluginManager.registerEvents(new NameEditorChat(), this);
    pluginManager.registerEvents(new HoloMover(), this);
  }
  
  public void onDisable() {}
  
  private void createCustomConfig(String name) {
    customConfigFile = new File(getDataFolder(), name);
    if (!customConfigFile.exists()) {
      customConfigFile.getParentFile().mkdirs();
      saveResource(name, false);
    } 
    customConfig = new YamlConfiguration();
    try {
      customConfig.load(customConfigFile);
    } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
      e.printStackTrace();
    } 
  }
  
  public static void cfgreload() { cfg = YamlConfiguration.loadConfiguration(players); }
  
  public static void cgholoreload() { cfg = YamlConfiguration.loadConfiguration(holo); }
  
  public static void SaveConfig() {
    try {
      cfg.save(players);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public static void SaveholoConfig() {
    try {
      cfgholo.save(holo);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}
