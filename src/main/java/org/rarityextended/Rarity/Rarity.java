package org.rarityextended.Rarity;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.random.Random;

public class Rarity {
    public enum Types {

        COMMON("common", Text.translatable("rarityextended.common"), 0.3),
        UNCOMMON("uncommon", Text.translatable("rarityextended.uncommon").formatted(Formatting.GREEN), 0.25),
        RARE("rare", Text.translatable("rarityextended.rare").formatted(Formatting.BLUE), 0.1),
        EPIC("epic", Text.translatable("rarityextended.epic").formatted(Formatting.LIGHT_PURPLE), 0.03),
        LEGENDARY("legendary", Text.translatable("rarityextended.legendary").formatted(Formatting.YELLOW), 0.01),
        MYTHIC("mythic", Text.translatable("rarityextended.mythic").formatted(Formatting.DARK_PURPLE), 0.007);

        private final String id;
        private final MutableText Name;
        private final double Weight;

        Types(String id, MutableText Name, double Weight) {
            this.id = id;
            this.Name = Name;
            this.Weight = Weight;
        }

        @Override
        public String toString() {
            return id;
        }

        public MutableText getName() {
            return Name;
        }

        public double getWeight() {
            return Weight;
        }

    }

    public static Rarity.Types calculateType() {
        Rarity.Types result = null;

        double totalWeight = 0;

        for (var rarity : Rarity.Types.values()) {
            totalWeight += rarity.getWeight();
        }

        var rnd = Random.create().nextDouble() * totalWeight;
        double cWeight = 0;

        for (var rarity : Rarity.Types.values()) {
            cWeight += rarity.getWeight();
            if (rnd <= cWeight) {
                return rarity;
            }
        }

        return Rarity.Types.COMMON;
    }
}

