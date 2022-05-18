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
    private Label TPSindicator = new Label("TPS: 0");
    private Label TPTindicator = new Label("Tacos Per Tick: 1");
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

        // s.add(new Label) is whitespace and/or a placeholder for the upgrade buttons which have not been initialized yet.
        s.add(new Label("Producers:"));

        s.add(taconum);
        taconum.setVisible(true);

        s.add(new Label("Upgrades:"));


        Buttons StreetStand = new Buttons("Street Stand");
        s.add(StreetStand);
        StreetStand.setVisible(true);
        System.out.println("Street Stand");
        StreetStand.changeName(Player.thisPlayer.getProducerAmount(0));

        s.add(new Label(""));

        UpgradeButtons Megaphone = new UpgradeButtons("Megaphone");
        s.add(Megaphone);
        Megaphone.setVisible(true);
        Megaphone.changename((Player.thisPlayer.getUpgrade(0)));

        Buttons TacoShop = new Buttons("Taco Shop");
        s.add(TacoShop);
        TacoShop.setVisible(true);
        TacoShop.changeName(Player.thisPlayer.getProducerAmount(1));

        s.add(TPSindicator);
        TPSindicator.setVisible(true);

        UpgradeButtons TortillaPress = new UpgradeButtons("Tortilla Press");
        s.add(TortillaPress);
        TortillaPress.setVisible(true);
        TortillaPress.changename((Player.thisPlayer.getUpgrade(1)));

        Buttons Restaurant = new Buttons("Restaurant");
        s.add(Restaurant);
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

        UpgradeButtons HotSauce = new UpgradeButtons("Hot Sauce");
        s.add(HotSauce);
        HotSauce.setVisible(true);
        HotSauce.changename(Player.thisPlayer.getUpgrade(2));

        Buttons Factory = new Buttons("Factory");
        s.add(Factory);
        Factory.setVisible(true);
        Factory.changeName(Player.thisPlayer.getProducerAmount(3));

        s.add(TPTindicator);
        TPTindicator.setVisible(true);

        UpgradeButtons AssemblyLine = new UpgradeButtons("Assembly Line");
        s.add(AssemblyLine);
        AssemblyLine.setVisible(true);
        AssemblyLine.changename(Player.thisPlayer.getUpgrade(3));

        Buttons Conglomerate = new Buttons("Conglomerate");
        s.add(Conglomerate);
        Conglomerate.setVisible(true);
        Conglomerate.changeName(Player.thisPlayer.getProducerAmount(4));

        s.add(new Label(""));

        UpgradeButtons Boardroom = new UpgradeButtons("Boardroom");
        s.add(Boardroom);
        Boardroom.setVisible(true);
        Boardroom.changename(Player.thisPlayer.getUpgrade(4));


        Buttons TacoTown = new Buttons("Taco Town");
        s.add(TacoTown);
        TacoTown.setVisible(true);
        TacoTown.changeName(Player.thisPlayer.getProducerAmount(5));

        s.add(new Label(""));

        UpgradeButtons Constitution = new UpgradeButtons("Constitution");
        s.add(Constitution);
        Constitution.setVisible(true);
        Constitution.changename(Player.thisPlayer.getUpgrade(5));

        Buttons PlanetTaco = new Buttons("Planet Taco");
        s.add(PlanetTaco);
        PlanetTaco.setVisible(true);
        PlanetTaco.changeName(Player.thisPlayer.getProducerAmount(6));

        s.add(new Label(""));

        UpgradeButtons LettuceLand = new UpgradeButtons("Lettuce Land");
        s.add(LettuceLand);
        LettuceLand.setVisible(true);
        LettuceLand.changename(Player.thisPlayer.getUpgrade(6));

        s.add(new Label(""));
        s.add(new Label(""));

        UpgradeButtons Bell = new UpgradeButtons("Bell");
        s.add(Bell);
        Bell.setVisible(true);
        Bell.changename(Player.thisPlayer.getUpgrade(7));

        s.add(new Label(""));
        s.add(new Label(""));

        UpgradeButtons TacoMakingGloves = new UpgradeButtons("Taco Making Gloves");
        s.add(TacoMakingGloves);
        TacoMakingGloves.setVisible(true);
        TacoMakingGloves.changename(Player.thisPlayer.getUpgrade(8));

        s.repaint();
        setVisible(true);
        s.revalidate();
        s.repaint();

    }
    public void tacoCountUpdate(Long i){
        taconum.setText("Number of Tacos: "+ String.format( "%,d\n", i ));
    }
    public void TPSUpdate(Long j){
        TPSindicator.setText("TPS: " + String.format("%,d\n", j));
    }
    public void TPTUpdate(int k){
        TPTindicator.setText("Tacos Per Tick: " + String.format("%,d\n", k));
    }
    public void actiontest(){
        Player.thisPlayer.addTacos(Player.thisPlayer.getTacosPerTick());
    }

}
