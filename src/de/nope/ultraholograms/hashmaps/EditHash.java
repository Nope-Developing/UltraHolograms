package de.nope.ultraholograms.hashmaps;

import java.util.HashMap;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class EditHash {
	
	
  public static HashMap<Player, Boolean> HoloCreator = new HashMap<>(); 
  public static HashMap<Player, ArmorStand> CurrentStand = new HashMap<>();  
  public static HashMap<Player, Boolean> StandLine = new HashMap<>();
  
  
  
  public static HashMap<Player, Boolean> NameEditor = new HashMap<>(); 
  public static HashMap<Player, ArmorStand> NameStand = new HashMap<>();
  
  
  public static HashMap<Player, Boolean> StandMove = new HashMap<>();
  public static HashMap<Player, ArmorStand> StandMoving = new HashMap<>();
}
