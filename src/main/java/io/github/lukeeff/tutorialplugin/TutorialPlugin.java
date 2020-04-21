package io.github.lukeeff.tutorialplugin;

import io.github.lukeeff.tutorialplugin.commands.HalfHealth;
import io.github.lukeeff.tutorialplugin.commands.Sword;
import io.github.lukeeff.tutorialplugin.enchantments.combat.LightningWrapper;
import io.github.lukeeff.tutorialplugin.listener.DamageListener;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

public class TutorialPlugin extends JavaPlugin {

    static TutorialPlugin plugin;
    public static Enchantment LIGHTNING;

    @Override
    public void onEnable() {
        plugin = this;
        LIGHTNING = new LightningWrapper();
        LightningWrapper.registerEnchantment(LIGHTNING);
        this.getCommand("sword").setExecutor(new Sword());
        this.getCommand("halfhealth").setExecutor(new HalfHealth());
        this.getServer().getPluginManager().registerEvents(new DamageListener(this), this);
    }

    @Override
    public void onDisable() {

    }

    public static TutorialPlugin getPlugin() {
        return plugin;
    }

}
