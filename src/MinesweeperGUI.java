import javax.swing.*;
import java.awt.*;

public class MinesweeperGUI extends JFrame {

    public MinesweeperGUI(int width, int height, int gridSize, Launcher launcher) {
        super("Minesweeper");
        // Set UI size:
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new Grid(new GridLayout(gridSize, gridSize));
        setContentPane(panel);
        pack();
        // Set UI visibility:
        setVisible(true);
    }
}
