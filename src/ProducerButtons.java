import javax.swing.*;

public class ProducerButtons extends JButton{
    private JButton screenButton;
    private String name;
    public ProducerButtons(String name){
        this.name = name;
        screenButton = new JButton(name);
        setText(name + ": ");
        addActionListener(e -> actiontest());
        setActionCommand("Yes");
        setVisible(true);

    }
    public void changeName(int i, long price, int TPS){
        setText(name + ": " + i+"\n"+" Price: "+String.format( "%,d\n",price)+" TPS: "+String.format( "%,d\n",TPS));
    }
    public void actiontest(){
        if (name.equals("Street Stand")) {
            if(Player.thisPlayer.buy(new StreetStandClass(Player.thisPlayer.getCost(0))))
                System.out.println("Street Stand bought");
            else System.out.println("Not enough tacos!");

        }
        else if(name.equals("Taco Shop")){
            if(Player.thisPlayer.buy(new TacoShopClass(Player.thisPlayer.getCost(1))))
                System.out.println("Taco Shop bought" +Player.thisPlayer.getCost(1));
            else System.out.println("Not enough tacos!");


        }
        else if(name.equals("Restaurant")){
            if(Player.thisPlayer.buy(new RestaurantClass(Player.thisPlayer.getCost(2))))
                System.out.println("Restaurant bought");
            else System.out.println("Not enough tacos!");


        }
        else if(name.equals("Factory")){
            if(Player.thisPlayer.buy(new FactoryClass(Player.thisPlayer.getCost(3))))
                System.out.println("Factory bought");
            else System.out.println("Not enough tacos!");
            changeName(Player.thisPlayer.getProducerAmount(3),Player.thisPlayer.getCost(3), FactoryClass.thisTPS);
        }
        else if(name.equals("Conglomerate")){
            if(Player.thisPlayer.buy(new ConglomerateClass(Player.thisPlayer.getCost(4))))
                System.out.println("Conglomerate bought");
            else System.out.println("Not enough tacos!");
            changeName(Player.thisPlayer.getProducerAmount(4),Player.thisPlayer.getCost(4), ConglomerateClass.thisTPS);
        }
        else if(name.equals("Taco Town")){
            if(Player.thisPlayer.buy(new TacoTownClass(Player.thisPlayer.getCost(5))))
                System.out.println("Taco Town bought");
            else System.out.println("Not enough tacos!");
            changeName(Player.thisPlayer.getProducerAmount(5),Player.thisPlayer.getCost(5), TacoTownClass.thisTPS);
        }
        else if(name.equals("Planet Taco")){
            if(Player.thisPlayer.buy(new PlanetTacoClass(Player.thisPlayer.getCost(6))))
                System.out.println("Planet Taco bought");
            else System.out.println("Not enough tacos!");
            changeName(Player.thisPlayer.getProducerAmount(6),Player.thisPlayer.getCost(6), PlanetTacoClass.thisTPS);
        }
        else{
            System.out.println("Error");
        }

    }
}
