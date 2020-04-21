package io.github.lukeeff.tutorialplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HalfHealth implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(10);
        player.sendMessage(ChatColor.GREEN + "Success. New health is 5 hearts.");
        return true;
    }
}
