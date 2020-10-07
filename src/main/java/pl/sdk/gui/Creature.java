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
        int damageToDeal = attack - aDefender.armor;
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }

        int killedUnits = damageToDeal / aDefender.maxHp;
        int lostHp = damageToDeal % aDefender.maxHp;
        aDefender.amount = aDefender.amount - killedUnits;
        aDefender.currentHp = aDefender.currentHp - lostHp;

        // counterattack
        if (!aDefender.counterAttack && aDefender.currentHp > 0) {
            int damageToDealInCounterAttack = aDefender.attack - armor;
            if (damageToDealInCounterAttack < 0) {
                damageToDealInCounterAttack = 0;
            }
            int killedUnitsAfterCounterAttack = damageToDealInCounterAttack / maxHp;
            int lostHpAfterCounterAttack = damageToDealInCounterAttack % maxHp;
            amount = amount - killedUnitsAfterCounterAttack;
            currentHp = currentHp - lostHpAfterCounterAttack;

            counterAttack = true;
        }
    }

    int getMoveRange() {
        return moveRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
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
