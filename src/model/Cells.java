package model;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cells extends JButton {
    private final int type;
    private final int position;
    private boolean discovered;
    private boolean flagged;
    private final GameHandler handler;

    public Cells(int type, int position, boolean discovered, boolean flagged, GameHandler handler) {
        this.type = type;
        this.position = position;
        this.discovered = discovered;
        this.flagged = flagged;
        this.handler = handler;

        // Add click functionality:
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) rightClickButton();
                else leftClickButton();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public int getType() {
        // Type = 0: Empty, 1: Mine, 2: Flagged
        return type;
    }

    public int getPosition() {
        return position;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    // Functions for left and right-click:
    public void leftClickButton() {
        handler.clickCell(this);
    }

    public void rightClickButton() {
        handler.rightClick(this);
    }
}
