package pl.sdk.gui;

public class ElementalCalculateStrategy implements CalculateStrategy {

    public int calculateDamageToDeal(Creature aDefender, Creature aAttacker) {
        int damageToDeal = (aAttacker.getAttack() - aDefender.getArmor()) * aAttacker.getAmount();
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }
        damageToDeal = considerElementalMechanic(aAttacker, aDefender, damageToDeal);

        return damageToDeal;
    }

    private int considerElementalMechanic(Creature aAttacker, Creature aDefender, int damageToDeal) {
        if (aAttacker.getName().equals("Water Elemental")) {
            if (aDefender.getName().equals("Fire Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.getName().equals("Earth Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        } else if (aAttacker.getName().equals("Fire Elemental")) {
            if (aDefender.getName().equals("Air Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.getName().equals("Water Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        } else if (aAttacker.getName().equals("Air Elemental")) {
            if (aDefender.getName().equals("Earth Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.getName().equals("Fire Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        } else if (aAttacker.getName().equals("Earth Elemental")) {
            if (aDefender.getName().equals("Water Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.getName().equals("Air Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        }
        return damageToDeal;
    }
}
