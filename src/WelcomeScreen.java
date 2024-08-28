import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JFrame {
    public WelcomeScreen() {
        super("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setResizable(true);
        setLayout(null);
        setLocationRelativeTo(null);
        addComponents();
    }

    public void addComponents() {
        // Title text:
        JLabel title = new JLabel("Welcome to Minesweeper!");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 20));
        title.setBounds(-55, 0, 500, 39);
        add(title);

        // Add grid size label:
        JLabel gridSizeLabel = new JLabel("Enter your grid size:");
        gridSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridSizeLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        gridSizeLabel.setBounds(-140, 50, 500, 39);
        add(gridSizeLabel);
        // Add grid size field:
        JTextArea gridSizeField = new JTextArea();
        gridSizeField.setBounds(200, 55, 30, 30);
        gridSizeField.setFont(new Font("Dialog", Font.PLAIN, 20));
        gridSizeField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(gridSizeField);

        // Play button:
        JButton play = new JButton("Play");
        play.setFont(new Font("Dialog", Font.BOLD, 20));
        play.setBounds(140, 100, 100, 39);
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(play);
    }

    public static void main(String[] args) {
        WelcomeScreen w = new WelcomeScreen();
        w.setVisible(true);
    }
}
