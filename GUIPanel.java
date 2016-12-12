/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;

/********
 * boiler plate jpanel with specific functions i thought i
 * might implement... didn't change color*/
public class GUIPanel extends JPanel{

    public GUIPanel(){

    }

    public GUIPanel(int width, int height, int color){
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(color));
    }

    public void changeDimension(int width, int height){
        setPreferredSize(new Dimension(width, height));
    }

    public void changeColor(int color){
        setBackground(new Color(color));
    }

}