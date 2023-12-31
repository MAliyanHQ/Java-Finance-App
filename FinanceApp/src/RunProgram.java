/**
 * @author sufiy
 */
import java.awt.*;
import javax.swing.*;

public class RunProgram extends JWindow {

    Image splashScreen;
    ImageIcon imageIcon;

    public RunProgram() {
        splashScreen = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/splash.jpg"));
        // Create ImageIcon from Image
        imageIcon = new ImageIcon(splashScreen);
        // Set JWindow size from image size
        setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
        // Get current screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Get x coordinate on screen for make JWindow locate at center
        int x = (screenSize.width - getSize().width) / 2;
        // Get y coordinate on screen for make JWindow locate at center
        int y = (screenSize.height - getSize().height) / 2;
        // Set new location for JWindow
        setLocation(x, y);
        // Make JWindow visible
        setVisible(true);
    }
    // Paint image onto JWindow

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(splashScreen, 0, 0, this);
    }

    public static void main(String[] args) {
        RunProgram splash = new RunProgram();
        try {
            // Make JWindow appear for 10 seconds before disappear
            Thread.sleep(8000);
            new Registration().setVisible(true);
            splash.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
