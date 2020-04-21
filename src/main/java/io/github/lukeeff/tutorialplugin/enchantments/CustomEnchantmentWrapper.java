package io.github.lukeeff.tutorialplugin.enchantments;

import io.github.lukeeff.tutorialplugin.TutorialPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

public abstract class CustomEnchantmentWrapper extends Enchantment {
    public CustomEnchantmentWrapper(String nameSpace) {
        super(new NamespacedKey(TutorialPlugin.getPlugin(), nameSpace));
    }
}
