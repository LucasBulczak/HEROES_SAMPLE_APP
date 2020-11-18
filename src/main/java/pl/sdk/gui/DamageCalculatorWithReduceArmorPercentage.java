package pl.sdk.gui;

public class DamageCalculatorWithReduceArmorPercentage extends DamageCalculator {

    private int armorPercentageReduce;

    DamageCalculatorWithReduceArmorPercentage(int armorPercentageReduce) {
        this.armorPercentageReduce = armorPercentageReduce;
    }

    @Override
    int calculateDamageToDeal(Creature aAttacker, Creature aDefender) {
        int reducedArmor = aDefender.getArmor() - aDefender.getArmor() * armorPercentageReduce / 100;
        int damageToDeal = (aAttacker.getAttack() - reducedArmor) * aAttacker.getAmount();
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }
        return damageToDeal;
    }
}
