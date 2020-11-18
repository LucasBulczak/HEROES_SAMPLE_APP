package pl.sdk.gui;

public class CreatureFactory {

    public static final String BEHEMOTH = "Behemoth";
    public static final String AIR_ELEMENTAL = "Air Elemental";
    public static final String WATER_ELEMENTAL = "Water Elemental";
    public static final String EARTH_ELEMENTAL = "EarthElemental";
    public static final String FIRE_ELEMENTAL = "Fire Elemental";

    public static Creature create(String aCreatureName) {
        switch (aCreatureName) {
            case AIR_ELEMENTAL:
                return new Creature(100, 30, 5, AIR_ELEMENTAL, 7, 5,
                        new ElementalCalculateStrategy());
            case WATER_ELEMENTAL:
                return new Creature(100, 30, 5, WATER_ELEMENTAL, 7, 5,
                        new ElementalCalculateStrategy());
            case EARTH_ELEMENTAL:
                return new Creature(100, 30, 5, EARTH_ELEMENTAL, 7, 5,
                        new ElementalCalculateStrategy());
            case FIRE_ELEMENTAL:
                return new Creature(100, 30, 5, FIRE_ELEMENTAL, 7, 5,
                        new ElementalCalculateStrategy());
            case BEHEMOTH:
                return new Creature(160, 50, 17, BEHEMOTH, 6, 6,
                        new ReduceArmorPercentageCalculateStrategy(60));
            default:
                throw new UnsupportedOperationException("Not recognized creature" + aCreatureName);
        }
    }
}
