package pl.sdk.gui;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Point, Creature> board;

    Board() {
        board = new HashMap<>();
    }
}
