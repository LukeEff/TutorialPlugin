package io.github.lukeeff.tutorialplugin;

import io.github.lukeeff.tutorialplugin.commands.Sword;
import io.github.lukeeff.tutorialplugin.lottery.Lottery;
import org.bukkit.plugin.java.JavaPlugin;

public class TutorialPlugin extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getCommand("sword").setExecutor(new Sword());
    }

    @Override
    public void onDisable() {

    }

}
