import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.*;

public class Frame extends JFrame{
    Panel s;
    private int w = 640;
    private int h = 480;
    public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(w, h);
        setResizable(false);
        setTitle("Taco Ticker...");
        init();
    }
    public void init(){
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 1, 0, 0));

        s = new Panel(w, h);
        add(s);
        Icon taco = new ImageIcon("Tacoimage.jpg");
        JButton tacoClicker = new JButton(taco);
        tacoClicker.setPreferredSize(new Dimension(100, 100));
        s.add(tacoClicker);
        setVisible(true);
    }
    public static void main(String[] args){

        Frame test = new Frame();

    }
}
