public class Launcher {
    public static final int WIDTH = 720, HEIGHT = 720, GRID_SIZE = 10, MINE_COUNT = 10;

    public Launcher() {
        new MinesweeperGUI(WIDTH, HEIGHT, GRID_SIZE, this);
    }
    public static void main(String[] args) {
        new Launcher();
    }
}
