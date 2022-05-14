import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame{
    Screen s;
    private int w = 640;
    private int h = 480;
    public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(w, h);
        setResizable(false);
        setTitle("window");

        init();
    }
    public void init(){
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 1, 0, 0));

        s = new Screen();
        add(s);

        setVisible(true);
    }
    public static void main(String[] args){

        Frame test = new Frame();

    }
}
