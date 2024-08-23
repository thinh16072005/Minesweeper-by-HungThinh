import java.util.ArrayList;

public class GameHandler {
    private final ArrayList<Cells> current = new ArrayList<Cells>();
    private final ArrayList<Cells> queue = new ArrayList<Cells>();

    public void clickCell(Cells cell) {
        // Instantiate whether the cells
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
                queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE));
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
                queue.add(Grid.cellsGrid.get(position - Launcher.GRID_SIZE - 1));
                queue.add(Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1));
                // Right and Left side
                queue.add(Grid.cellsGrid.get(position - 1));
                queue.add(Grid.cellsGrid.get(position + 1));
            }
        // Case 2: The cells are flagged:
        } else if (cell.getType() == 2) {
            int dangerCount = 0;
            if (position < Launcher.GRID_SIZE) {
                if ((position & Launcher.GRID_SIZE) == 0) {
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + 1).getType() == 1) dangerCount++;
                } else if (position % Launcher.GRID_SIZE == Launcher.GRID_SIZE - 1) {
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position - 1).getType() == 1) dangerCount++;
                } else {
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE + 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + Launcher.GRID_SIZE - 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position + 1).getType() == 1) dangerCount++;
                    if (Grid.cellsGrid.get(position - 1).getType() == 1) dangerCount++;
                }
            } if (position >= (Launcher.GRID_SIZE * (Launcher.GRID_SIZE - 1))) {

            } else if (position % Launcher.GRID_SIZE == 0) {
                
            } else if (position % Launcher.GRID_SIZE == Launcher.GRID_SIZE - 1) {
                
            } else {

            }
        // Case 1: Some of the cells are mines:
        } else if (cell.getType() == 1) {

        }
        for (Cells cells : queue) {
            current.add(cells);
            cells.setDiscovered(true);
        }
        queue.clear();
        // Check if current cells are not empty:
        while (!current.isEmpty()) {
            Cells temp = current.get(0);
            current.removeFirst();
        }
    }
}
