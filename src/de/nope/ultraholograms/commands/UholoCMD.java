package de.nope.ultraholograms.commands;

import de.nope.ultraholograms.Guis.Maingui;
import de.nope.ultraholograms.messages.messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UholoCMD implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      if (player.hasPermission("Uholo.Menu")) {
        Maingui.openMainGui(player);
        return true;
      } 
      player.sendMessage(String.valueOf(messages.Prefix) + " " + messages.NoPerms);
    } 
    return false;
  }
}
