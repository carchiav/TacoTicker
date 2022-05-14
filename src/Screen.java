import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Screen extends JPanel{
    private final BufferedImage image;

    public Screen(){
        try {
            image = ImageIO.read(new File("Tacoimage.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repaint();
    }
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, 200, 200, null);
    }
}
