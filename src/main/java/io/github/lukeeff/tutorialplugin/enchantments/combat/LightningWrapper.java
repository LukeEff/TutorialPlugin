package io.github.lukeeff.tutorialplugin.enchantments.combat;

import io.github.lukeeff.tutorialplugin.enchantments.CustomEnchantmentWrapper;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;

public class LightningWrapper extends CustomEnchantmentWrapper {

    private final String name = "Thor's Blessing";
    private final int maxLevel = 8;
    private final int startLevel = 0;
    private final boolean isCursed = false;
    private final boolean isTreasure = false;
    private final EnchantmentTarget enchantmentTarget = null;

    public LightningWrapper() {
        super("lightning");
    }

    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if(registered){
            // It's been registered!
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMaxLevel() {
        return this.maxLevel;
    }

    @Override
    public int getStartLevel() {
        return this.startLevel;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return this.enchantmentTarget;
    }

    @Override
    public boolean isTreasure() {
        return this.isTreasure;
    }

    @Override
    public boolean isCursed() {
        return this.isCursed;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return false;
    }
}
