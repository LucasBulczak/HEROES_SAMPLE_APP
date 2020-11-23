package pl.sdk.gui;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<Point, Creature> map;

    Board() {
        map = new HashMap<>();
    }

    void add(Point aPoint, Creature aCreature) {
        if (map.containsKey(aPoint)) {
            throw new IllegalArgumentException("You cannot place the creature on a non-empty field!");
        }
        map.put(aPoint, aCreature);
    }

    Creature get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }
}
