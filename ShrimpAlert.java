import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import java.io.File;

public class ShrimpAlert extends JFrame {
    public ShrimpAlert() {
        super();
        setTitle("Shrimp Alert");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon icon = new ImageIcon("shrimp.jpeg");
        BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        icon.paintIcon(null, img.getGraphics(), 0, 0);

        int screenHeight = getHeight();
        double scale = (double) screenHeight / img.getHeight();
        int newWidth = (int) (img.getWidth() * scale);

        BufferedImage scaled = new BufferedImage(newWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        scaled.getGraphics().drawImage(img, 0, 0, newWidth, screenHeight, null);

        JLabel label = new JLabel(new ImageIcon(scaled));
        add(label);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();
        setVisible(true);

        playShrimpSound();
    }

    private void playShrimpSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("laugh(1).wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ShrimpAlert();
    }
}
