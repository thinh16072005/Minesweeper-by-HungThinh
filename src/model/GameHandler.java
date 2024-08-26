package model;

import controller.Launcher;
import view.MinesweeperGUI;

import java.util.ArrayList;

public class GameHandler {
    private final ArrayList<Cells> current = new ArrayList<Cells>();
    private final ArrayList<Cells> queue = new ArrayList<Cells>();
    // Number of flagged cells:
    private static int flaggedCells = 0;

    public void clickCell(Cells cell) {
        // Instantiate whether the cells are discovered:
        int discoveredCells = 0;
        if (!cell.isFlagged()) {
            cell.setEnabled(false);
            cell.setDiscovered(true);

            int position = cell.getPosition();
            if (cell.getType() == 0) {
                if (position < Launcher.GRID_SIZE) {
                    // Top row:
                    if (position % Launcher.GRID_SIZE == 0) {
                        queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE));
                        queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1));
                        queue.add(Grid.cellsGrid.get(position + 1));
                    } else if (position % Launcher.GRID_SIZE == Launcher.GRID_SIZE - 1) {
                        queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE));
                        queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1));
                        queue.add(Grid.cellsGrid.get(position - 1));
                    } else {
                        queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE));
                        queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1));
                        queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1));
                        queue.add(Grid.cellsGrid.get(position + 1));
                        queue.add(Grid.cellsGrid.get(position - 1));
                    }
                    // Bottom row:
                } else if (position >= (Launcher.GRID_SIZE * (Launcher.GRID_SIZE - 1))) {
                    if (position % Launcher.GRID_SIZE == 0) {
                        queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE));
                        queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE + 1));
                        queue.add(Grid.cellsGrid.get(position + 1));
                    } else if (position % Launcher.GRID_SIZE == Launcher.GRID_SIZE - 1) {
                        queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE));
                        queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE - 1));
                        queue.add(Grid.cellsGrid.get(position - 1));
                    } else {
                        queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE));
                        queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE + 1));
                        queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE - 1));
                        queue.add(Grid.cellsGrid.get(position + 1));
                        queue.add(Grid.cellsGrid.get(position - 1));
                    }
                    // Left row:
                } else if (position % Launcher.GRID_SIZE == 0) {
                    queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE));
                    queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE));
                    queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE + 1));
                    queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1));
                    queue.add(Grid.cellsGrid.get(position + 1));
                    // Right row:
                } else if (position % Launcher.GRID_SIZE == Launcher.GRID_SIZE - 1) {
                    queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE));
                    queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE));
                    queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE - 1));
                    queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1));
                    queue.add(Grid.cellsGrid.get(position - 1));
                } else {
                    queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE));
                    queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE));
                    // Top and Bottom left
                    queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE - 1));
                    queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1));
                    // Top and Bottom right
                    queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE + 1));
                    queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1));
                    // Right and Left side
                    queue.add(Grid.cellsGrid.get(position - 1));
                    queue.add(Grid.cellsGrid.get(position + 1));
                }

                // Case 2: The cells are flagged:
            } else if (cell.getType() == 2) {
                int dangerCount = 0;
                if (position < Launcher.GRID_SIZE) {
                    if ((position % Launcher.GRID_SIZE) == 0) {
                        if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position + 1).getType() == 1) dangerCount++;
                    } else if (position % Launcher.GRID_SIZE == Launcher.GRID_SIZE - 1) {
                        if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position - 1).getType() == 1) dangerCount++;
                    } else {
                        if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position + 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position - 1).getType() == 1) dangerCount++;
                        System.out.println(dangerCount);
                    }
                } else if (position >= (Launcher.GRID_SIZE * (Launcher.GRID_SIZE - 1))) {
                    if ((position % Launcher.GRID_SIZE) == 0) {
                        if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position + 1).getType() == 1) dangerCount++;
                    } else if (position % Launcher.GRID_SIZE == Launcher.GRID_SIZE - 1) {
                        if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE - 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position - 1).getType() == 1) dangerCount++;
                    } else {
                        if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE - 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position + 1).getType() == 1) dangerCount++;
                        if (Grid.cellsGrid.get(position - 1).getType() == 1) dangerCount++;
                    }
                } else if (position % Launcher.GRID_SIZE == 0) {
                    if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + 1).getType() == 1) dangerCount++;
                } else if (position % Launcher.GRID_SIZE == Launcher.GRID_SIZE - 1) {
                    if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE - 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position - 1).getType() == 1) dangerCount++;
                } else {
                    if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE - 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position - Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position - 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + 1).getType() == 1) dangerCount++;
                }
                cell.setText(String.valueOf(dangerCount));

                // Case 1: Some of the cells are mines:
            } else if (cell.getType() == 1) {
                for (int i = 0; i < Grid.cellsGrid.size(); i++) {
                    Grid.cellsGrid.get(i).setEnabled(false);
                    Grid.cellsGrid.get(i).setText("");
                    if (Grid.cellsGrid.get(i).getType() == 1) Grid.cellsGrid.get(i).setText("X");
                }
                cell.setText("*");
            }

            for (Cells cells : queue) {
                if (!cells.isDiscovered()) {
                    current.add(cells);
                    cells.setDiscovered(true);
                }
            }
            queue.clear();
            // Check if current cells are not empty:
            while (!current.isEmpty()) {
                Cells temp = current.getFirst();
                current.removeFirst();
                temp.leftClickButton();
            }

            for (int i = 0; i < Grid.cellsGrid.size(); i++) {
                if (Grid.cellsGrid.get(i).getType() == 1) {
                    discoveredCells++;
                }
            }

            if (discoveredCells == Grid.cellsGrid.size() - Launcher.MINE_COUNT) {
                for (int i = 0; i < Grid.cellsGrid.size(); i++) {
                    // Indicates that the cell has a mine in it
                    if (Grid.cellsGrid.get(i).getType() == 1) {
                        Grid.cellsGrid.get(i).setEnabled(false);
                        Grid.cellsGrid.get(i).setText("X");
                    } else { // If player successfully completes the game:
                        Grid.cellsGrid.get(i).setEnabled(false);
                        Grid.cellsGrid.get(i).setText(":3");
                    }
                }
            }
        }
    }

    public void rightClick(Cells cell) {
        if (!cell.isDiscovered()) {
            if (!cell.isFlagged()) {
                cell.setFlagged(true);
                cell.setText("F");
                flaggedCells++;
                MinesweeperGUI.update(flaggedCells);
            } else {
                cell.setFlagged(false);
                cell.setText("");
                flaggedCells--;
                MinesweeperGUI.update(flaggedCells);
            }
        }
    }
}
