package view;

import controller.Launcher;
import model.GameHandler;
import model.Grid;

import javax.swing.*;
import java.awt.*;

public class MinesweeperGame extends JFrame {

    public MinesweeperGame(int width, int height, int gridSize, String title, Launcher launcher, GameHandler handler) {
        super("Minesweeper - " + "Mines: " + Launcher.MINE_COUNT);
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


}
