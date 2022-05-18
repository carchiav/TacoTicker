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
        s.setLayout(new GridLayout(10,3, 50, 10));
        add(s);

        s.add(new Label(""));
        s.add(new Label(""));
        s.add(new Label(""));

        // s.add(new Label) is whitespace and/or a placeholder for the upgrade buttons which have not been initialized yet.
        s.add(new Label("Producers:"));

        s.add(taconum);
        taconum.setVisible(true);

        s.add(new Label("Upgrades:"));

        s.add(new Label(""));
        s.add(new Label(""));

        Buttons StreetStand = new Buttons("Street Stand");
        s.add(StreetStand);
        StreetStand.setVisible(true);
        System.out.println("Street Stand");
        StreetStand.changeName(Player.thisPlayer.getProducerAmount(0));

        s.add(new Label(""));
        s.add(new Label(""));

        Buttons TacoShop = new Buttons("Taco Shop");
        s.add(TacoShop);
        TacoShop.setLocation(getX(), getY());
        TacoShop.setVisible(true);
        TacoShop.changeName(Player.thisPlayer.getProducerAmount(1));

        s.add(new Label(""));
        s.add(new Label(""));

        Buttons Restaurant = new Buttons("Restaurant");
        s.add(Restaurant);
        Restaurant.setLocation(getX(), getY());
        Restaurant.setVisible(true);
        Restaurant.changeName(Player.thisPlayer.getProducerAmount(2));

        //Adds taco in the middle
        Icon taco = new ImageIcon("Tacoimage.jpg");
        JButton tacoClicker = new JButton(taco);
        tacoClicker.addActionListener(e -> actiontest());
        tacoClicker.setActionCommand("yes");
        tacoClicker.setPreferredSize(new Dimension(100, 100));
        s.add(tacoClicker);
        tacoClicker.setVisible(true);

        s.add(new Label(""));

        Buttons Factory = new Buttons("Factory");
        s.add(Factory);
        Factory.setLocation(getX(), getY());
        Factory.setVisible(true);
        Factory.changeName(Player.thisPlayer.getProducerAmount(3));

        s.add(new Label(""));
        s.add(new Label(""));

        Buttons Conglomerate = new Buttons("Conglomerate");
        s.add(Conglomerate);
        Conglomerate.setLocation(getX(), getY());
        Conglomerate.setVisible(true);
        Conglomerate.changeName(Player.thisPlayer.getProducerAmount(4));

        s.add(new Label(""));
        s.add(new Label(""));


        Buttons TacoTown = new Buttons("Taco Town");
        s.add(TacoTown);
        TacoTown.setLocation(getX(), getY());
        TacoTown.setVisible(true);
        TacoTown.changeName(Player.thisPlayer.getProducerAmount(5));

        s.add(new Label(""));
        s.add(new Label(""));

        Buttons PlanetTaco = new Buttons("Planet Taco");
        s.add(PlanetTaco);
        PlanetTaco.setLocation(getX(), getY());
        PlanetTaco.setVisible(true);
        PlanetTaco.changeName(Player.thisPlayer.getProducerAmount(6));

        s.add(new Label(""));
        s.add(new Label(""));

        s.add(new Label(""));
        s.add(new Label(""));
        s.add(new Label(""));

        s.add(new Label(""));
        s.add(new Label(""));
        s.add(new Label(""));
        s.repaint();
        setVisible(true);
        s.revalidate();
        s.repaint();

    }
    public void tacoCountUpdate(Long i){
        taconum.setText("Number of Tacos: "+ String.format( "%,d\n", i ));
    }
    public void actiontest(){
        Player.thisPlayer.addTacos(Player.thisPlayer.getTacosPerTick());
    }

}
