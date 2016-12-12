/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;
/**
 * TimeBar is a bar dispalyed across the screen below the score
 * it has a timer and changed shrinks width-wise accordingly
 * as well as changing colors*/
public class TimeBar implements ActionListener{
  private int x, y;
  private int x2, y2;
  private Color color;
  private int colorValue;
  private int time;
  private boolean timeLeft;

  public TimeBar(){
    reset();

    Timer timer = new Timer(500, this);
    timer.setInitialDelay(5000);
    timer.start();
  }

  public void actionPerformed(ActionEvent ev) {
    tick();
  }

  public void draw(Graphics g){
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(30));
    g2.draw(new Line2D.Float(x, y, x2, y));
  }

  public void tick(){
    if(time-- == 0){
      timeLeft = false;
    }
    if(time%2 == 0){
      colorValue += 110990;
      color = new Color(colorValue);
    }
    if(x < x2){
      x += 10;
      x2 -= 10;
    }
    else{
      x = x2 = 600;
    }
  }

  public boolean time(){
    return timeLeft;
  }

  public void reset(){
    colorValue = 65535;
    color = new Color(colorValue);
    time = 60;
    timeLeft = true;
    x = 0;
    x2 = 1200;
  }


}