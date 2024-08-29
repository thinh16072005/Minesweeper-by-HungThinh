package controller;

import model.GameHandler;
import view.MinesweeperGame;

public class Launcher {
    public static int GRID_SIZE = 10;
    public static final int WIDTH = 720, HEIGHT = 720,
                            MINE_COUNT = (int) Math.round(GRID_SIZE * GRID_SIZE * .1);

    public Launcher() {
        GameHandler handler = new GameHandler();
        new MinesweeperGame(WIDTH, HEIGHT, GRID_SIZE, this, handler);
    }
}