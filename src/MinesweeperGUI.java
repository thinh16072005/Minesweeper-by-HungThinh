import javax.swing.*;
import java.awt.*;

public class MinesweeperGUI extends JFrame {
    public static final int GRID_SIZE = 10;
    public static final int MINE_COUNT = 10;

    public MinesweeperGUI() {
        super("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        addGuiComponent();
    }

    private void addGuiComponent() {
        JPanel panel = new Grid(new GridLayout(gridSize, gridSize));
    }
}
