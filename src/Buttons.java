import javax.swing.*;
import java.awt.*;
import java.beans.ConstructorProperties;

public class Buttons extends JButton{
    private int x;
    private int y;
    private JButton screenButton;
    private String name;

    public Buttons(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
        screenButton = new JButton(name);
        setText(name);
        addActionListener(e -> actiontest());
        setPreferredSize(new Dimension(400, 400));
        setActionCommand("Yes");
        setVisible(true);

    }

    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY(){
        return y;
    }
    public void changeName(int i){
        setText(name + " number bought: " + i);
    }
    public void actiontest(){
        if (name.equals("Street Stand")) {
            Player.thisPlayer.buy(new StreetStand(Player.thisPlayer.getCost(0)));
            System.out.println("Street Stand bought");
            changeName(Player.thisPlayer.getProducerAmount(0));
        }
        else if(name.equals("Taco Shop")){
            Player.thisPlayer.buy(new TacoShop(Player.thisPlayer.getCost(1)));
            System.out.println("Taco Shop bought");
            changeName(Player.thisPlayer.getProducerAmount(1));
        }
        else if(name.equals("Restaurant")){
            Player.thisPlayer.buy(new Restaurant(Player.thisPlayer.getCost(2)));
            System.out.println("Restaurant bought");
            changeName(Player.thisPlayer.getProducerAmount(2));
        }
        else if(name.equals("Factory")){
            Player.thisPlayer.buy(new Factory(Player.thisPlayer.getCost(3)));
            System.out.println("Factory bought");
            changeName(Player.thisPlayer.getProducerAmount(3));
        }
        else if(name.equals("Conglomerate")){
            Player.thisPlayer.buy(new Conglomerate(Player.thisPlayer.getCost(4)));
            System.out.println("Conglomerate bought");
            changeName(Player.thisPlayer.getProducerAmount(4));
        }
        else if(name.equals("Taco Town")){
            Player.thisPlayer.buy(new TacoTown(Player.thisPlayer.getCost(5)));
            System.out.println("Taco Town bought");
            changeName(Player.thisPlayer.getProducerAmount(5));
        }
        else if(name.equals("Planet Taco")){
            Player.thisPlayer.buy(new PlanetTaco(Player.thisPlayer.getCost(6)));
            System.out.println("Planet Taco bought");
            changeName(Player.thisPlayer.getProducerAmount(6));
        }
        else{
            System.out.println("Error");
        }

    }
}
