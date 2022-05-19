import javax.swing.*;
public class UpgradeButtons extends JButton{
    private JButton screenButton;
    private String name;
    public UpgradeButtons(String name){
        this.name = name;
        screenButton = new JButton(name);
        setText(name);
        addActionListener(e -> actiontest());
        setActionCommand("Yes");
    }
    public void changename(boolean isPurchased, int cost){
        if(isPurchased == true){
            setText(name + ": Purchased");
        }
        else{
            setText(name+ " Price: "+ cost);
        }
    }
    public void changename(boolean isPurchased, long cost){
        if(isPurchased == true){
            setText(name + ": Purchased");
        }
        else{
            setText(name+ " Price: "+ cost);
        }
    }
    public void actiontest(){
        if(name.equals("Megaphone")) {
            if (!Player.thisPlayer.getUpgrade(0)) {
                if (Player.thisPlayer.buyMegaphone()) {
                    System.out.println(name + " Bought");
                    changename(true,0);
                }
                else{
                    System.out.println("Not enough tacos");
                }
            }
            else{
                System.out.println("You already have this upgrade");
            }
        }
        if(name.equals("Tortilla Press")) {
            if (!Player.thisPlayer.getUpgrade(1)) {
                if (Player.thisPlayer.buyTortillaPress()) {
                    System.out.println(name + " Bought");
                    changename(true,0);
                }
                else{
                    System.out.println("Not enough tacos");
                }
            }
            else{
                System.out.println("You already have this upgrade");
            }
        }
        if(name.equals("Hot Sauce")) {
            if (!Player.thisPlayer.getUpgrade(2)) {
                if (Player.thisPlayer.buyHotSauce()) {
                    System.out.println(name + " Bought");
                    changename(true,0);
                }
                else{
                    System.out.println("Not enough tacos");
                }
            }
            else{
                System.out.println("You already have this upgrade");
            }
        }
        if(name.equals("Assembly Line")) {
            if (!Player.thisPlayer.getUpgrade(3)) {
                if (Player.thisPlayer.buyAssemblyLine()) {
                    System.out.println(name + " Bought");
                    changename(true,0);
                }
                else{
                    System.out.println("Not enough tacos");
                }
            }
            else{
                System.out.println("You already have this upgrade");
            }
        }
        if(name.equals("Boardroom")) {
            if (!Player.thisPlayer.getUpgrade(4)) {
                if (Player.thisPlayer.buyBoardroom()) {
                    System.out.println(name + " Bought");
                    changename(true,0);
                }
                else{
                    System.out.println("Not enough tacos");
                }
            }
            else{
                System.out.println("You already have this upgrade");
            }
        }
        if(name.equals("Constitution")) {
            if (!Player.thisPlayer.getUpgrade(5)) {
                if (Player.thisPlayer.buyConstitution()) {
                    System.out.println(name + " Bought");
                    changename(true,0);
                }
                else{
                    System.out.println("Not enough tacos");
                }
            }
            else{
                System.out.println("You already have this upgrade");
            }
        }
        if(name.equals("Lettuce Land")) {
            if (!Player.thisPlayer.getUpgrade(6)) {
                if (Player.thisPlayer.buyLettuceLand()) {
                    System.out.println(name + " Bought");
                    changename(true,0);
                }
                else{
                    System.out.println("Not enough tacos");
                }
            }
            else{
                System.out.println("You already have this upgrade");
            }
        }
        if(name.equals("Bell")) {
            if (!Player.thisPlayer.getUpgrade(7)) {
                if (Player.thisPlayer.buyBell()) {
                    System.out.println(name + " Bought");
                    changename(true,0);
                }
                else{
                    System.out.println("Not enough tacos");
                }
            }
            else{
                System.out.println("You already have this upgrade");
            }
        }
        if(name.equals("Taco Making Gloves")) {
            if (!Player.thisPlayer.getUpgrade(8)) {
                if (Player.thisPlayer.buyTacoMakingGloves()) {
                    System.out.println(name + " Bought");
                    changename(true,0);
                }
                else{
                    System.out.println("Not enough tacos");
                }
            }
            else{
                System.out.println("You already have this upgrade");
            }
        }
    }
}
