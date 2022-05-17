import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.*;

public class Frame extends JFrame{
    Panel s;
    private int w = 1000;
    private int h = 1000;
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

        s.setLayout(null);

        Icon taco = new ImageIcon("Tacoimage.jpg");
        JButton tacoClicker = new JButton(taco);
        tacoClicker.addActionListener(e -> actiontest());
        tacoClicker.setActionCommand("yes");
        tacoClicker.setPreferredSize(new Dimension(100, 100));
        s.add(tacoClicker);

        Buttons TacoStand = new Buttons("Taco Stand", 300, 400);
        s.add(TacoStand);
        TacoStand.setLocation(getX(), getY());
        setVisible(true);
    }
    public void actiontest(){
        System.out.println("Working");
    }
    public static void main(String[] args){

        Frame test = new Frame();

    }
}
