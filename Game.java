/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import javax.swing.*;

/********
 * Game is the main class. it has a swing protector, then creates the gamespace
 * by calling the model(oneroom) controller gameview and musicplayer, then 
 * putting the music player on the threadpool to loop in the background*/
public class Game{
  public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        initGame();
      }
    });
  }
  public static void initGame() {
      ThreadPool pool = new ThreadPool(2);
      OneRoom oneRoom = new OneRoom();
      GameView gameView = new GameView();
      MusicPlayer musicPlayer = new MusicPlayer("000000011.wav", "hmm.wav", 
        "ahh.wav", "wai.wav");
      Controller controller = new Controller(oneRoom, gameView, musicPlayer);
      pool.runTask(musicPlayer);
      pool.join();
    }
}