package mineplicity.hub.main;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InfinitePotionEffect extends PotionEffect {

    //Makes the potion effect Infinite
    public InfinitePotionEffect(PotionEffectType type, int amplifier) {
        super(type, Integer.MAX_VALUE, amplifier, false);
    }
}
