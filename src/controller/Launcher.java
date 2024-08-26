package controller;

import model.GameHandler;
import view.MinesweeperGUI;

public class Launcher {
    public static final int WIDTH = 720, HEIGHT = 720, GRID_SIZE = 10,
                            MINE_COUNT = 10;

    public Launcher() {
        GameHandler handler = new GameHandler();
        new MinesweeperGUI(WIDTH, HEIGHT, GRID_SIZE, "Minesweeper - " ,this, handler);
        MinesweeperGUI.update(0);
    }
    public static void main(String[] args) {
        new Launcher();
    }
}
