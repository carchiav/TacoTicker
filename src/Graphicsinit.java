import java.awt.*;
import java.io.File;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.*;
public class Graphicsinit{
    private final Image clickIcon;
    public Graphicsinit(){
        try {
            clickIcon = ImageIO.read(new File("Tacoimage.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public abstract boolean drawImage(clickIcon, 320, 240, null, null){
        return true;
    }
}
