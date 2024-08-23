import javax.swing.*;

public class Cells extends JButton {
    private int type;
    private int position;
    private boolean discovered;
    private boolean flagged;

    public Cells(int type, int position, boolean discovered, boolean flagged) {
        this.type = type;
        this.position = position;
        this.discovered = discovered;
        this.flagged = flagged;
    }

    public int getType() {
        // Type = 0: Empty, 1: Mine, 2: Flagged
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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
}
