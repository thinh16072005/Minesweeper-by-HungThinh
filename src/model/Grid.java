package model;

import controller.Launcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {
    private boolean picked = false;
    private final ArrayList<Integer> mines = new ArrayList<Integer>();
    public static ArrayList<Cells> cellsGrid = new ArrayList<Cells>();

    public Grid(GridLayout g, GameHandler h) {
        super(g);
        createCells(h);
        addCells();
    }

    public void createCells(GameHandler h) {
        // The main panel for the game:
        int bound = Launcher.GRID_SIZE * Launcher.GRID_SIZE;

        for (int i = 1; i <= Launcher.MINE_COUNT; i++) {
            while (!picked) {
                int minePosition = (int) (Math.random() * bound);
                if (!mines.contains(minePosition)) {
                    mines.add(minePosition);
                    picked = true;
                }
            }
            picked = false;
        }
        for (int i = 0; i < bound; i++) {
            if (mines.contains(i)) {
                cellsGrid.add(new Cells(1, i, false, false, h));
            } else if (i % Launcher.GRID_SIZE == 0) {
                if (mines.contains(i - Launcher.GRID_SIZE - 1) ||
                        mines.contains(i - Launcher.GRID_SIZE + 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Launcher.GRID_SIZE - 1) ||
                        mines.contains(i + Launcher.GRID_SIZE + 1))
                {
                    cellsGrid.add(new Cells(2, i, false, false, h));
                } else {
                    cellsGrid.add(new Cells(0, i, false, false, h));

                }
            } else if (i % Launcher.GRID_SIZE == Launcher.GRID_SIZE - 1) {
                if (mines.contains(i - Launcher.GRID_SIZE - 1) ||
                        mines.contains(i - Launcher.GRID_SIZE) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + Launcher.GRID_SIZE - 1) ||
                        mines.contains(i + Launcher.GRID_SIZE))
                {
                    cellsGrid.add(new Cells(2, i, false, false, h));
                } else {
                    cellsGrid.add(new Cells(0, i, false, false, h));
                }
            } else {
                if (mines.contains(i - Launcher.GRID_SIZE - 1) ||
                        mines.contains(i - Launcher.GRID_SIZE) ||
                        mines.contains(i - Launcher.GRID_SIZE + 1) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Launcher.GRID_SIZE - 1) ||
                        mines.contains(i + Launcher.GRID_SIZE) ||
                        mines.contains(i + Launcher.GRID_SIZE + 1))
                {
                    cellsGrid.add(new Cells(2, i, false, false, h));
                } else {
                    cellsGrid.add(new Cells(0, i, false, false, h));
                }
            }
        }
    }

    public void addCells() {
        for (Cells cells : cellsGrid) add(cells);
    }
}