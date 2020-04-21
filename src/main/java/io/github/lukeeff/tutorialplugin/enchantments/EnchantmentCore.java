package io.github.lukeeff.tutorialplugin.enchantments;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.Map;

public class EnchantmentCore {

    private static final String[] NUMERALS = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };


    // ItemMeta#hasEnchant() may also work for this function
    public static boolean hasEnchantment(ItemStack item, Enchantment enchant){
        if(item.getItemMeta() != null && item.getItemMeta().getEnchants() != null && item.getItemMeta().getEnchants().size() > 0){
            for (Iterator<Map.Entry<Enchantment, Integer>> it = item.getItemMeta().getEnchants().entrySet().iterator(); it.hasNext();) {
                java.util.Map.Entry<Enchantment, Integer> e = it.next();
                if(e.getKey().equals(enchant)){
                    return true;
                }
            }
        }
        return false;
    }
    // ItemMeta#getEnchantLevel() may also work for this function
    public static int getLevel(ItemStack item, Enchantment enchant){
        if(item.getItemMeta() != null && item.getItemMeta().getEnchants() != null && item.getItemMeta().getEnchants().size() > 0){
            for (Iterator<java.util.Map.Entry<Enchantment, Integer>> it = item.getItemMeta().getEnchants().entrySet().iterator(); it.hasNext();) {
                java.util.Map.Entry<Enchantment, Integer> e = it.next();
                if(e.getKey().equals(enchant)){
                    return e.getValue();
                }
            }
        }
        return 0;
    }

    public static String returnEnchantmentName(Enchantment ench, int enchLevel){
        if(enchLevel == 1 && ench.getMaxLevel() == 1){
            return ench.getName();
        }
        if(enchLevel > 10 || enchLevel <= 0){
            return ench.getName() + " enchantment.level." + enchLevel;
        }

        return ench.getName() + " " + NUMERALS[enchLevel- 1];
    }

}
