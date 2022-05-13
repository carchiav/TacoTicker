import java.awt.*;       // Using AWT's Graphics and Color
import javax.swing.*;    // Using Swing's components and containers
import java.io.File;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.*;
/** Custom Drawing Code Template */
// A Swing application extends javax.swing.JFrame
public class Graphicstest extends JFrame {
    // Define constants
    public static final int CANVAS_WIDTH  = 640;
    public static final int CANVAS_HEIGHT = 480;

    private final Image clickIcon;
    public Graphicstest(){
        Window one = new Window(null);
        one.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        one.setVisible(true);
        one.toFront();
        Graphicsinit traco = new Graphicsinit();
    }
    public int getwidth(){
        return CANVAS_WIDTH;
    }
    public int getheight(){
        return CANVAS_HEIGHT;
    }

}