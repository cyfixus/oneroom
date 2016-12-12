/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.*;

/************
 * Gameview is the JFrame with custom size icon etc..
 * in it exists the mainpanel gamepanel and scorepanel
 * and getPanel() so the controller can talk to the 
 * game panel and an update score function*/
public class GameView extends JFrame{
  private final int BLACK = 0xff000000;
  private int width = 1200;
  private int height = 800;
  private GUIPanel mainPanel;
  private GamePanel gamePanel;
  private GUILabel scoreLabel;

  public GameView(){
    super("oneroom");
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(new Color(BLACK));
    super.setIconImage(new ImageIcon("ico.png").getImage());
    setup();
  }


  public void setup(){
    mainPanel = new GUIPanel(width, height, BLACK);
    gamePanel = new GamePanel(width, height - 100, BLACK);
    scoreLabel = new GUILabel(" 0 ");
    scoreLabel.initLabel();
    mainPanel.add(scoreLabel, BorderLayout.NORTH);
    mainPanel.add(gamePanel, BorderLayout.CENTER);
    super.getContentPane().add(mainPanel);
    super.pack();
    super.setVisible(true);
  }

  public GamePanel getPanel(){
    return gamePanel;
  }

  public void updateScore(long score){
    scoreLabel.setText(" " + score + " ");
  }

}
