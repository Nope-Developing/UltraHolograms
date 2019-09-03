package de.nope.ultraholograms.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.nope.ultraholograms.Guis.Maingui;
import de.nope.ultraholograms.messages.messages;

public class UholoCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("Uholo.Menu")) {
				Maingui.openMainGui(player);
				return true;
				
			} else {
				player.sendMessage( messages.Prefix + " " + messages.NoPerms );
				
			}
		}
		
		
		
		
		
		
		
		
		
		return false;
	}
	
	

}
