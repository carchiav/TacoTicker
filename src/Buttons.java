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
        setPreferredSize(new Dimension(50, 50));
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
    public void actiontest(){
        System.out.println(name);
    }
}
