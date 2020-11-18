package pl.sdk.gui;

public class CreatureFactory {

    public static final String BEHEMOTH = "Behemoth";

    static Creature create(String aCreatureName) {
        switch(aCreatureName) {
            case BEHEMOTH:
                return new Creature(160, 50, 17, BEHEMOTH, 6, 6,
                        new ReduceArmorPercentageCalculateStrategy(60));
            default:
                throw new UnsupportedOperationException("Not recognized creature" + aCreatureName);
        }
    }
}
