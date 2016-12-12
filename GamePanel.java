/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

/****
 * Gamepanel draws the triangle floor and all the nodes, and responds
 * to mouse clicks which are listened for in the controller*/
public class GamePanel extends JPanel implements ActionListener{

  private Floor floor = new Floor();
  private TimeBar timeBar = new TimeBar();
  private HashSet<Node> choices = new HashSet<Node>();
  private Mouse mouse;
  private int mouseX, mouseY;
  private boolean choiceMade = false;
  private int choice;

  public GamePanel(int width, int height, int color){
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(color));
        mouse = new Mouse();
        addMouseListener(mouse);
        
        Timer timer = new Timer(1, this);
        timer.setInitialDelay(0);
        timer.start();
    }
  public void actionPerformed(ActionEvent ev) {
    if(mouse.clicked()){
        mouseX = mouse.getX();
        mouseY = mouse.getY();
        for(Node node: choices){
          if(node.inBounds(mouse.getPoint())){
            choice = node.value();
            choose();
          }
        }
        mouse.click();
    }
    repaint();
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    floor.draw(g);
    timeBar.draw(g);
    drawNodes(g);
  }

  public void updateChoices(HashSet<Node> choices){
    this.choices = choices;
    repaint();
  }

  public void drawNodes(Graphics g){
    for(Node node: choices){
      node.draw(g);
    }
  }

  public boolean chosen(){
    return choiceMade;
  }

  public void choose(){
    choiceMade = !choiceMade;
    repaint();
  }

  public int getChoice(){
    return choice;
  }

  public Floor getFloor(){
    return floor;
  }

  public TimeBar getTimeBar(){
    return timeBar;
  }
}


