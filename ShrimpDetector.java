import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

public class ShrimpDetector extends JFrame {
    public ShrimpDetector() {
        super();
        setTitle("Shrimp Detector");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JLabel question = new JLabel("Are you shrimp?  ", SwingConstants.CENTER);
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        add(question, BorderLayout.NORTH);

        JButton button = new JButton("YES");
        button.addActionListener(e -> detectShrimp());
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        add(button, BorderLayout.SOUTH);

    }

    private void detectShrimp() {
        new ShrimpAlert();
    }

    public static void main(String[] args) {
        new ShrimpDetector();
    }
}