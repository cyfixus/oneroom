/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import javax.swing.*;
import java.awt.*;
/*****************************
 * boilerplate jlabel with my favorite font*/
public class GUILabel extends JLabel{
    private Font font = new Font("Nimbus Mono L", Font.BOLD, 60);

    private String defaultText = " 0 ";

    public GUILabel(){
        super();
    }

    public GUILabel(String label){
        super(label);
    }

    public void initLabel(){
        this.setFont(font);
        this.setForeground(new Color(0xffff00ff));
    }
    
}