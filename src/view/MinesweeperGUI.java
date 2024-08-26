package view;

import controller.Launcher;
import model.GameHandler;
import model.Grid;

import javax.swing.*;
import java.awt.*;

public class MinesweeperGUI extends JFrame {

    private static JFrame frame;
    private static String title;

    public MinesweeperGUI(int width, int height, int gridSize, String title, Launcher launcher, GameHandler handler) {
        MinesweeperGUI.title = title;
        frame = new JFrame(title);
        // Set UI size:
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new Grid(new GridLayout(gridSize, gridSize), handler);
        setContentPane(panel);
        pack();
        // Set UI visibility:
        setVisible(true);
    }

    public static void update(int flagged) {
        frame.setTitle(title + "Mines: " + Launcher.MINE_COUNT + " - Flags: " + flagged);
    }
}
