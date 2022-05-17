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
    private Label taconum = new Label("Number of Tacos: 0");
    public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(w, h);
        setResizable(false);
        setTitle("Taco Ticker...");
        init();

    }
    public void init(){
        setLocationRelativeTo(null);

        s = new Panel(w, h);
        add(s);
        s.add(taconum);
        taconum.setVisible(true);
        Icon taco = new ImageIcon("Tacoimage.jpg");
        JButton tacoClicker = new JButton(taco);
        tacoClicker.addActionListener(e -> actiontest());
        tacoClicker.setActionCommand("yes");
        tacoClicker.setPreferredSize(new Dimension(100, 100));
        tacoClicker.setLocation(0,0);
        s.add(tacoClicker);
        tacoClicker.setVisible(true);

        Buttons StreetStand = new Buttons("Street Stand", 300, 400);
        s.add(StreetStand);
        StreetStand.setLocation(StreetStand.getX(), StreetStand.getY());
        StreetStand.setVisible(true);
        System.out.println("Street Stand");

        Buttons TacoShop = new Buttons("Taco Shop", 400, 400);
        s.add(TacoShop);
        TacoShop.setLocation(getX(), getY());
        TacoShop.setVisible(true);

        Buttons Restaurant = new Buttons("Restaurant", 500, 400);
        s.add(Restaurant);
        Restaurant.setLocation(getX(), getY());
        Restaurant.setVisible(true);

        Buttons Factory = new Buttons("Factory", 600, 400);
        s.add(Factory);
        Factory.setLocation(getX(), getY());
        Factory.setVisible(true);

        Buttons Conglomerate = new Buttons("Conglomerate", 700, 400);
        s.add(Conglomerate);
        Conglomerate.setLocation(getX(), getY());
        Conglomerate.setVisible(true);

        Buttons TacoTown = new Buttons("Taco Town", 800, 400);
        s.add(TacoTown);
        TacoTown.setLocation(getX(), getY());
        TacoTown.setVisible(true);

        Buttons PlanetTaco = new Buttons("Planet Taco", 300, 700);
        s.add(PlanetTaco);
        PlanetTaco.setLocation(getX(), getY());
        PlanetTaco.setVisible(true);



        setVisible(true);

    }
    public void tacoCountUpdate(Long i){
        taconum.setText("Number of Tacos: " + i);
    }
    public void actiontest(){
        System.out.println("Working");
    }
    public static void main(String[] args){

        Frame test = new Frame();

    }
}
