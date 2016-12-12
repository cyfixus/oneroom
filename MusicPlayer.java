/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

/*****************************
 * Boilerplate MusicPlayer reads in an unlimited number of
 * Strings as file names, puts them into an ArrayList
 * and has the functionality to loop through that list
 * I keep the background music playing the background music
 * and have another function to play the sounds*/
public class MusicPlayer implements Runnable{
  
  private ArrayList<String> musicFiles;
  private int songIndex;

  public MusicPlayer(String... files){
    musicFiles = new ArrayList<String>();
    for(String file: files){
      musicFiles.add(file);
    }
  }

  public void playBackground(String fileName){
    try{
      File soundFile = new File(fileName);
      AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
      AudioFormat format = ais.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, format);
      Clip clip = (Clip)AudioSystem.getLine(info);
      clip.open(ais);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      clip.start();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void playSound(String fileName){
    try{
      File soundFile = new File(fileName);
      AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
      AudioFormat format = ais.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, format);
      Clip clip = (Clip)AudioSystem.getLine(info);
      clip.open(ais);
      clip.start();
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public void run(){
    playBackground(musicFiles.get(0));
  }
}