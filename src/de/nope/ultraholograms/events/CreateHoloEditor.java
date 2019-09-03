package de.nope.ultraholograms.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import de.nope.ultraholograms.hashmaps.EditHash;
import de.nope.ultraholograms.methoden.CreateHolo;

@SuppressWarnings("deprecation")
public class CreateHoloEditor implements Listener {
	
	
	
	@EventHandler
	public void handleInCreatorChat(PlayerChatEvent event) {
		
		
 if (EditHash.HoloCreator.get(event.getPlayer()) == null) {
	 
			
		} else {
			if (EditHash.HoloCreator.get(event.getPlayer()) != null) {
			if (EditHash.HoloCreator.get(event.getPlayer()) == true) {
				
			
			
				Player player = event.getPlayer();
				String NAME = event.getMessage();
				EditHash.HoloCreator.remove(player);
				CreateHolo.createHoloTest(player, NAME);
				
				
				player.sendMessage("" + NAME );
				event.setCancelled(true);
			
				
			
				
				
			}
			
			
				
			}
			
			}
			
			
			
			
			
		}  
			
			
			
		

		
		

	

}
