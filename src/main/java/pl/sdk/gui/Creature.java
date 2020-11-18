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
    private CalculateStrategy calculateStrategy;

    Creature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount) {
        this(aMaxHp, aAttack, aArmor, aName, aMoveRange, aAmount, new DefaultCalculateStrategy());
    }

    Creature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount, CalculateStrategy aCalculateStrategy) {
        maxHp = aMaxHp;
        attack = aAttack;
        armor = aArmor;
        amount = aAmount;
        currentHp = maxHp;
        name = aName;
        moveRange = aMoveRange;
        calculateStrategy = aCalculateStrategy;
    }

    public void attack(Creature aDefender) {
        if (isAlive()) {
            int damageToDeal = this.calculateStrategy.calculateDamageToDeal(aDefender, this);
            applyDamage(aDefender, damageToDeal);

            // counterattack
            counterattack(aDefender);
        }
    }

    protected void counterattack(Creature aDefender) {
        if (canCounterAttack(aDefender)) {
            int damageToDealInCounterAttack = aDefender.calculateStrategy.calculateDamageToDeal(this, aDefender);
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

    private boolean isAlive() {
        return currentHp > 0 && amount > 0;
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

    public int getMoveRange() {
        return moveRange;
    }

    int getCurrentHp() {
        return currentHp;
    }

    int getAmount() {
        return amount;
    }

    String getName() {
        return name;
    }

    Integer getAttack() {
        return attack;
    }

    Integer getArmor() {
        return armor;
    }
}
