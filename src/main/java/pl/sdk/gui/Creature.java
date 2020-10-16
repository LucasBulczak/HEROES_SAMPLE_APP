package pl.sdk.gui;


public class Creature {

    private final int maxHp;
    private final Integer attack;
    private final Integer armor;
    private int amount;
    private final String name;
    private int currentHp;
    private final int moveRange;
    private boolean counterAttack;

    public Creature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount) {
        maxHp = aMaxHp;
        attack = aAttack;
        armor = aArmor;
        amount = aAmount;
        currentHp = maxHp;
        name = aName;
        moveRange = aMoveRange;
    }

    public void attack(Creature aDefender) {
        if (isAlive()) {
            int damageToDeal = countDamageToDeal(this, aDefender);
            damageToDeal = considerElementalMechanic(this, aDefender, damageToDeal);
            applyDamage(aDefender, damageToDeal);

            // counterattack
            counterattack(aDefender);
        }
    }

    protected void counterattack(Creature aDefender) {
        if (canCounterAttack(aDefender)) {
            int damageToDealInCounterAttack = countDamageToDeal(aDefender, this);
            damageToDealInCounterAttack = considerElementalMechanic(aDefender, this, damageToDealInCounterAttack);
            applyDamage(this, damageToDealInCounterAttack);
            counterAttack = true;
        }
    }

    private boolean canCounterAttack(Creature aDefender) {
        return !aDefender.counterAttack && aDefender.currentHp > 0 && aDefender.amount > 0;
    }

    private void applyDamage(Creature aDefender, int damageToDeal) {
        int killedUnits = damageToDeal / aDefender.maxHp;
        int lostHp = damageToDeal % aDefender.maxHp;
        aDefender.amount = aDefender.amount - killedUnits;
        aDefender.currentHp = aDefender.currentHp - lostHp;
    }

    private int considerElementalMechanic(Creature aAttacker, Creature aDefender, int damageToDeal) {
        if (aAttacker.name.equals("Water Elemental")) {
            if (aDefender.name.equals("Fire Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.name.equals("Earth Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        } else if (aAttacker.name.equals("Fire Elemental")) {
            if (aDefender.name.equals("Air Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.name.equals("Water Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        } else if (aAttacker.name.equals("Air Elemental")) {
            if (aDefender.name.equals("Earth Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.name.equals("Fire Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        } else if (aAttacker.name.equals("Earth Elemental")) {
            if (aDefender.name.equals("Water Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.name.equals("Air Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        }
        return damageToDeal;
    }

    private int countDamageToDeal(Creature aAttacker, Creature aDefender) {
        int damageToDeal = (aAttacker.attack - aDefender.armor) * aAttacker.amount;
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }
        return damageToDeal;
    }

    private boolean isAlive() {
        return currentHp > 0 && amount > 0;
    }

    int getMoveRange() {
        return moveRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String[] splitName = name.split(" ");
        for (int i = 0; i < splitName.length; i++) {
            sb.append(splitName[i]);
            if (i != splitName.length - 1) {
                sb.append(System.lineSeparator());
            }
        }
        sb.append(System.lineSeparator());
        sb.append(amount);
        sb.append(System.lineSeparator());
        sb.append(currentHp);
        sb.append("/");
        sb.append(maxHp);
        return sb.toString();
    }

    int getCurrentHp() {
        return currentHp;
    }

    public int getAmount() {
        return amount;
    }
}
