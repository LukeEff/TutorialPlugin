package io.github.lukeeff.tutorialplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Sword implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Inventory playerInventory = player.getInventory();

        if(inventoryIsFull(playerInventory)) {
            handleFullInventory(player);
        } else {
            givePlayerSword(playerInventory);
            player.sendMessage(ChatColor.AQUA + "Received diamond sword in your first hot bar slot!");
        }
        return true;
    }

    /**
     * Checks if a passed inventory is full
     * @param playerInventory the target inventory
     * @return true when the inventory is full and false when it is not full
     */
    private boolean inventoryIsFull(Inventory playerInventory) {
        final int fullInventoryIndex = -1;
        final int openSlotIndex = playerInventory.firstEmpty();
        if(openSlotIndex == fullInventoryIndex) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a diamond sword into a param inventory
     * @param playerInventory the target inventory
     */
    private void givePlayerSword(Inventory playerInventory) {
        final ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        playerInventory.addItem(diamondSword);
    }

    /**
     * Pays a title for a target player
     * @param player the target player
     */
    private void playTitle(Player player) {
        final String title = ChatColor.DARK_RED + "Your inventory is full!";
        final String subTitle = ChatColor.DARK_RED + "Clean up your inventory!";
        final int duration = 100;
        final int fadeIn = 15;
        final int fadeOut = 20;
        player.sendTitle(title, subTitle, fadeIn, duration, fadeOut);
    }

    /**
     * Plays a sound at the location of a player
     * @param player the target player
     */
    private void playSound(Player player) {
        final Location location = player.getLocation();
        final Sound fullInventorySound = Sound.ENTITY_VILLAGER_NO;
        final float volume = 1;
        final float pitch = 1;
        player.playSound(location, fullInventorySound, volume, pitch);
    }

    /**
     * Executes instructions for when a player's inventory is full
     * @param player the target player with the full inventory
     */
    private void handleFullInventory(Player player) {
        playTitle(player);
        playSound(player);
    }

}
