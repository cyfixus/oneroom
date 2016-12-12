/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.util.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
 
 /***************
  * Controller is the controller of the MVC
  * is knows about the oneroom the gameview and the musicplayer
  * it plays the start up sound, has a timer to check for mouse
  * clicks, and to check if the timebar has time left
  * it relays clickede choices to OneRoom and plays sounds accordingly
  * it also executes resets if gameover detected from oneroom*/
public class Controller implements ActionListener{
  private OneRoom oneRoom;
  private GameView gameView;
  private MusicPlayer musicPlayer;
  private long score;
  
  public Controller(OneRoom oneRoom, GameView gameView, 
      MusicPlayer musicPlayer){
    this.oneRoom = oneRoom;
    this.gameView = gameView;
    this.musicPlayer = musicPlayer;
    gameView.getPanel().updateChoices(oneRoom.getChoices());

    Timer timer = new Timer(1, this);
    timer.setInitialDelay(0);
    timer.start();
    musicPlayer.playSound("wai.wav");
  }

  public void actionPerformed(ActionEvent ev) {
    if(!gameView.getPanel().getTimeBar().time()){
      gameOver();
    }
    if(gameView.getPanel().chosen()){
      int choice = gameView.getPanel().getChoice();
      play(choice);
      score = oneRoom.getScore();
      gameView.updateScore(score);
      gameView.getPanel().choose();
    }
  }

  public void play(int choice){
      oneRoom.setChoice(choice);
      oneRoom.operate(choice);
      oneRoom.newOperator();
      gameView.getPanel().getFloor().setOperator(oneRoom.getOperator());
    if(!oneRoom.checkPrime()){
      musicPlayer.playSound("hmm.wav");
      oneRoom.decLevel();
      if(oneRoom.getLevel() < 1){
        gameOver();
      }
  
    }
    else{
      musicPlayer.playSound("ahh.wav");
    }

  }

  public void gameOver(){
    JOptionPane.showMessageDialog(gameView,
                                " " + score + " ",
                                score + " ",
                                           JOptionPane.INFORMATION_MESSAGE);
      oneRoom.reset();
      gameView.getPanel().getTimeBar().reset();
      musicPlayer.playSound("wai.wav");
  }

}