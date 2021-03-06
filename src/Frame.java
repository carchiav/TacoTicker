import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class Frame extends JFrame{
    Panel s;
    Panel a;
    private int w = 1400;
    private String ack;
    private int h = 700;
    private Label[] achievementlist;
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
        ProducerButtons[] ProducerButtonsList = new ProducerButtons[7];
        s = new Panel(w, h);
        s.setLayout(new GridLayout(10,3, 50, 10));
        add(s);
        s.setVisible(false);
        // s.add(new Label) is whitespace and/or a placeholder for the upgrade buttons which have not been initialized yet.
        s.add(new Label("Producers:"));

        s.add(taconum);
        taconum.setVisible(true);

        s.add(new Label("Upgrades:"));


        ProducerButtons StreetStand = new ProducerButtons("Street Stand",1);
        ProducerButtonsList[0] = StreetStand;
        s.add(StreetStand);
        StreetStand.setVisible(true);
        System.out.println("Street Stand");
        StreetStand.changeName(Player.thisPlayer.getProducerAmount(0),Player.thisPlayer.getCost(0),1);

        s.add(new Label(""));

        UpgradeButtons Megaphone = new UpgradeButtons("Megaphone");
        s.add(Megaphone);
        Megaphone.setVisible(true);
        Megaphone.changename((Player.thisPlayer.getUpgrade(0)),200);

        ProducerButtons TacoShop = new ProducerButtons("Taco Shop",5);
        ProducerButtonsList[1] = TacoShop;
        s.add(TacoShop);
        TacoShop.setVisible(true);
        TacoShop.changeName(Player.thisPlayer.getProducerAmount(1),Player.thisPlayer.getCost(1),5);

        s.add(TPSindicator);
        TPSindicator.setVisible(true);

        UpgradeButtons TortillaPress = new UpgradeButtons("Tortilla Press");
        s.add(TortillaPress);
        TortillaPress.setVisible(true);
        TortillaPress.changename(Player.thisPlayer.getUpgrade(1),1600);

        ProducerButtons Restaurant = new ProducerButtons("Restaurant",40);
        ProducerButtonsList[2] = Restaurant;
        s.add(Restaurant);
        Restaurant.setVisible(true);
        Restaurant.changeName(Player.thisPlayer.getProducerAmount(2),Player.thisPlayer.getCost(2),40);

        //Adds taco in the middle
        Icon taco = new ImageIcon("Tacoimage.jpg");
        JButton tacoClicker = new JButton(taco);
        tacoClicker.addActionListener(e -> actiontest());
        tacoClicker.setActionCommand("yes");
        s.add(tacoClicker);
        tacoClicker.setVisible(true);

        UpgradeButtons HotSauce = new UpgradeButtons("Hot Sauce");
        s.add(HotSauce);
        HotSauce.setVisible(true);
        HotSauce.changename(Player.thisPlayer.getUpgrade(2),18000);

        ProducerButtons Factory = new ProducerButtons("Factory",200);
        ProducerButtonsList[3] = Factory;
        s.add(Factory);
        Factory.setVisible(true);
        Factory.changeName(Player.thisPlayer.getProducerAmount(3),Player.thisPlayer.getCost(3),200);

        s.add(TPTindicator);
        TPTindicator.setVisible(true);

        UpgradeButtons AssemblyLine = new UpgradeButtons("Assembly Line");
        s.add(AssemblyLine);
        AssemblyLine.setVisible(true);
        AssemblyLine.changename(Player.thisPlayer.getUpgrade(3),200000);

        ProducerButtons Conglomerate = new ProducerButtons("Conglomerate",1200);
        ProducerButtonsList[4] = Conglomerate;
        s.add(Conglomerate);
        Conglomerate.setVisible(true);
        Conglomerate.changeName(Player.thisPlayer.getProducerAmount(4),Player.thisPlayer.getCost(4),1200);

        s.add(new Label(""));

        UpgradeButtons Boardroom = new UpgradeButtons("Boardroom");
        s.add(Boardroom);
        Boardroom.setVisible(true);
        Boardroom.changename(Player.thisPlayer.getUpgrade(4),1200000);


        ProducerButtons TacoTown = new ProducerButtons("Taco Town",8000);
        ProducerButtonsList[5] = TacoTown;
        s.add(TacoTown);
        TacoTown.setVisible(true);
        TacoTown.changeName(Player.thisPlayer.getProducerAmount(5),Player.thisPlayer.getCost(5),8000);

        s.add(new Label(""));

        UpgradeButtons Constitution = new UpgradeButtons("Constitution");
        s.add(Constitution);
        Constitution.setVisible(true);
        Constitution.changename(Player.thisPlayer.getUpgrade(5),15000000);

        ProducerButtons PlanetTaco = new ProducerButtons("Planet Taco",40000);
        ProducerButtonsList[6] = PlanetTaco;
        s.add(PlanetTaco);
        PlanetTaco.setVisible(true);
        PlanetTaco.changeName(Player.thisPlayer.getProducerAmount(6),Player.thisPlayer.getCost(6),40000);

        s.add(new Label(""));

        UpgradeButtons LettuceLand = new UpgradeButtons("Lettuce Land");
        s.add(LettuceLand);
        LettuceLand.setVisible(true);
        LettuceLand.changename(Player.thisPlayer.getUpgrade(6),300000000);

        s.add(new Label(""));

        Label recentAchivements = new Label("Most recent achievement: ");
        s.add(recentAchivements);
        recentAchivements.setVisible(true);

        UpgradeButtons Bell = new UpgradeButtons("Bell");
        s.add(Bell);
        Bell.setVisible(true);
        Bell.changename(Player.thisPlayer.getUpgrade(7),10000 + 300*Player.thisPlayer.calcTPS());


        JButton achievement = new JButton("Go to Achievements");
        achievement.addActionListener(e-> gotoAchievements());
        tacoClicker.setActionCommand("yes");
        s.add(achievement);
        achievement.setVisible(true);

        s.add(new Label(""));

        UpgradeButtons TacoMakingGloves = new UpgradeButtons("Taco Making Gloves");
        s.add(TacoMakingGloves);
        TacoMakingGloves.setVisible(true);
        TacoMakingGloves.changename(Player.thisPlayer.getUpgrade(8),1000 + 100*Player.thisPlayer.calcTPS());


        s.setVisible(true);
        setVisible(true);
        s.revalidate();

        TimerTask labelTask = new TimerTask(){
            @Override
            public void run() {
                Bell.changename(Player.thisPlayer.getUpgrade(7), 100000 + 300 * Player.thisPlayer.calcTPS());
                TacoMakingGloves.changename(Player.thisPlayer.getUpgrade(8), 10000 + 100 * Player.thisPlayer.calcTPS());

                for (int i = 0; i < 7; i++){
                    if (Player.thisPlayer.getUpgrade(i) && Player.thisPlayer.getUpgrade(7))
                        ProducerButtonsList[i].changeName(Player.thisPlayer.getProducerAmount(i),Player.thisPlayer.getCost(i), (ProducerButtonsList[i].thisTPS()*4));
                    else if (Player.thisPlayer.getUpgrade(i)|| Player.thisPlayer.getUpgrade(7))
                        ProducerButtonsList[i].changeName(Player.thisPlayer.getProducerAmount(i),Player.thisPlayer.getCost(i), (ProducerButtonsList[i].thisTPS()*2));
                    else
                        ProducerButtonsList[i].changeName(Player.thisPlayer.getProducerAmount(i),Player.thisPlayer.getCost(i), ProducerButtonsList[i].thisTPS());
                }
                ack = Player.thisPlayer.achievementsCheck();
                if (ack != null){
                    recentAchivements.setText("Most recent Achievement: " + ack);
                }
            }

            };
        new Timer().schedule(labelTask,0,100);

    }
    public void gotoAchievements(){

        setVisible(false);
        s.setVisible(false);
        achievementinit();
    }
    public void achievementinit(){
        a = new Panel(w, h);
        a.setLayout(new GridLayout(4, 5, 10, 10));
        add(a);
        achievementlist = new Label[18];

        achievementlist[0] = new Label("Welcome to TacoTicker: Buy a Street Stand");
        a.add(achievementlist[0]);

        achievementlist[1] = new Label("Ramping up Production: Buy a Taco Shop");
        a.add(achievementlist[1]);

        achievementlist[2] = new Label("Franchiser: Buy a Restaurant");
        a.add(achievementlist[2]);

        achievementlist[3] = new Label("Industrial Revolution: Buy a Factory");
        a.add(achievementlist[3]);

        achievementlist[4] = new Label("Horizon-taco-l Integration: Buy a Conglomerate");
        a.add(achievementlist[4]);

        achievementlist[5] = new Label("Won't You Take Me: Buy a Taco Town");
        a.add(achievementlist[5]);

        achievementlist[6] = new Label("Bring Me To Your Tortilla: Buy a Planet Taco");
        a.add(achievementlist[6]);

        achievementlist[7] = new Label("Return Customer: Buy 100 Street Stands");
        a.add(achievementlist[7]);

        achievementlist[8] = new Label("Average Taco Enjoyer: Buy 100 Taco Shops");
        a.add(achievementlist[8]);

        achievementlist[9] = new Label("I'll have my usual, please: Buy 100 Restaurants");
        a.add(achievementlist[9]);

        achievementlist[10] = new Label("Economies of Scale: Buy 100 Factories");
        a.add(achievementlist[10]);

        achievementlist[11] = new Label("Elon: Buy 100 Conglomerates");
        a.add(achievementlist[11]);

        achievementlist[12] = new Label("Did you know that the name of this producer was inspired by an SNL sketch with Bill Hader and Andy Samberg?: Buy 100 Taco Towns");
        a.add(achievementlist[12]);

        achievementlist[13] = new Label("I don't believe that you got this achievement legitimately: Buy 100 Planet Tacos");
        a.add(achievementlist[13]);

        achievementlist[14] = new Label("Carpal Tunnel: Click 1000 times");
        a.add(achievementlist[14]);

        achievementlist[15] = new Label("Efficiency Expert: Buy every upgrade");
        a.add(achievementlist[15]);

        achievementlist[16] = new Label("Completionist: Buy EVERYTHING");
        a.add(achievementlist[16]);

        achievementlist[17] = new Label("Nice Round Number: Get exactly 1,000,000,000 tacos");
        a.add(achievementlist[17]);

        JButton goBack = new JButton("Go Back");
        a.add(goBack);
        goBack.addActionListener(e-> backScreen());

        Label Testing = new Label("Achievements will appear when unlocked.");
        a.add (Testing);
        Testing.setVisible(true);


        achievementVisible();
        setVisible(true);

    }
    public void achievementVisible(){
        for(int i = 0; i <18; i++){
            if(Player.thisPlayer.getAchievement(i) == true){
                achievementlist[i].setVisible(true);
            }
            else achievementlist[i].setVisible(false);
        }
    }
    public void backScreen(){
        a.setVisible(false);
        s.setVisible(true);
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
        Player.thisPlayer.addToTotalTicks();
    }

}
