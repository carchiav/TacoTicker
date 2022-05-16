import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel{
    private final BufferedImage image;
    private int width;
    private int height;

    public Panel(int w, int h){
        width = w;
        height = h;
        try {
            image = ImageIO.read(new File("Tacoimage.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repaint();
    }
    public void paint(Graphics g){
       // g.drawImage(image, (width/2)-100, (height/2)-100, 200, 200, null);
    }
}
