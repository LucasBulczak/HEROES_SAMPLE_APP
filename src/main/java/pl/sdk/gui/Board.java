package pl.sdk.gui;

import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;

    private final Map<Point, Creature> map;

    Board() {
        map = new HashMap<>();
    }

    void add(Point aPoint, Creature aCreature) {
        throwExceptionWhenFieldIsTaken(aPoint);
        map.put(aPoint, aCreature);
    }

    Creature get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }

    void move(Point from, Point to) {
        throwExceptionWhenFieldIsTaken(to);
        Creature creatureFromSourcePoint = map.get(from);
        map.remove(from);
        map.put(to, creatureFromSourcePoint);
    }

    private void throwExceptionWhenFieldIsTaken(Point aPoint) {
        if (!isOnBoard(aPoint) || map.containsKey(aPoint)) {
            throw new IllegalArgumentException("You cannot place the creature on a non-empty field!");
        }
    }

    private boolean isOnBoard(Point aPoint) {
        return aPoint.getX() >= 0 &&
                aPoint.getX() <= WIDTH &&
                aPoint.getY() >= 0 &&
                aPoint.getY() <= HEIGHT;
    }
}
