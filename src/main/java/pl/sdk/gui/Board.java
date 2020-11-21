package pl.sdk.gui;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<Point, Creature> map;

    Board() {
        map = new HashMap<>();
    }

    void add(Point aPoint, Creature aCreature) {
        map.put(aPoint, aCreature);
    }

    Creature get(int aX, int aY) {
        return map.getOrDefault(new Point(aX, aY), null);
    }
}
