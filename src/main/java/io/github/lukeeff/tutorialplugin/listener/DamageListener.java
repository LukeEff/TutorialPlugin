package io.github.lukeeff.tutorialplugin.listener;

import io.github.lukeeff.tutorialplugin.TutorialPlugin;
import io.github.lukeeff.tutorialplugin.enchantments.EnchantmentCore;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DamageListener implements Listener {

    TutorialPlugin plugin;

    public DamageListener(TutorialPlugin instance) {
        plugin = instance;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if(!(event.getDamager() instanceof Player)) {
            return;
        }
        Entity hurtEntity = event.getEntity();
        Player attacker = (Player) event.getDamager();
        ItemStack weapon = attacker.getInventory().getItemInMainHand();
        //weapon.addUnsafeEnchantment(TutorialPlugin.LIGHTNING, 3);
        weapon.getItemMeta().getLore().stream().forEach(s -> Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + s));
        weapon.getEnchantments().forEach((s, n) -> Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + s.toString()));

        if(EnchantmentCore.hasEnchantment(weapon, TutorialPlugin.LIGHTNING)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Has enchantment");
            processEnchantmentAbility(hurtEntity, weapon);
        }

    }

    private void processEnchantmentAbility(Entity hurtEntity, ItemStack weapon) {
        double chanceOfAbility = EnchantmentCore.getLevel(weapon, TutorialPlugin.LIGHTNING) * 0.05;
        double random = Math.random();
        if(chanceOfAbility > random) {
            strikeTarget(hurtEntity);
        }

    }

    private void strikeTarget(Entity hurtEntity) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Striking target");
        Location location = hurtEntity.getLocation();
        World world = location.getWorld();
        world.strikeLightning(location);
        world.playSound(location, Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1f, 1f);

    }

}
