package pl.sdk.gui;

public class ReduceArmorPercentageCalculateStrategy extends ElementalCalculateStrategy {

    private int armorPercentageReduce;

    ReduceArmorPercentageCalculateStrategy(int armorPercentageReduce) {
        this.armorPercentageReduce = armorPercentageReduce;
    }

    @Override
    public int calculateDamageToDeal(Creature aDefender, Creature aAttacker) {
        int reducedArmor = aDefender.getArmor() - aDefender.getArmor() * armorPercentageReduce / 100;
        int damageToDeal = (aAttacker.getAttack() - reducedArmor) * aAttacker.getAmount();
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }
        return damageToDeal;
    }
}
