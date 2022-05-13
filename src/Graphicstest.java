import java.awt.*;       // Using AWT's Graphics and Color
import javax.swing.*;    // Using Swing's components and containers

/** Custom Drawing Code Template */
// A Swing application extends javax.swing.JFrame
public class Graphicstest extends JFrame {
    // Define constants
    public static final int CANVAS_WIDTH  = 640;
    public static final int CANVAS_HEIGHT = 480;
    public Graphicstest(){
        Window one = new Window(null);
        one.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        one.setVisible(true);
    }

}