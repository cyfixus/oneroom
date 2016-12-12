/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.awt.*;
import javax.swing.*;
import java.util.*;
/*************
 * Nodes are the colored ellipses on the screen, which secretly
 * have numbers attached to them.  I originally wanted the numbers
 * on top, but I have no clue how to get a jlabel on top of this thing
 * and it seems like thats a big question on the webs!
 * the Nodes draw themselves, positions and colors coorespond to the value
 * I tried to implement some randomness in terms of switching node positions
 * but I couldn't get it to work, so they stay where they are, and I always
 * planned to keep the colors the same*/
public class Node{
  private Color color;
  private int value;
  private int x, y;
  private Rectangle bounds;
  private Set<Integer> ints;

  private int diameter = 64;
  private Random random = new Random();

  public Node(int value){
    this.value = value;
    setColor(value);
    setPos(value);
    setBounds();
  }

  public void genRando(){
    int i;
    for(int j = 0; j < 9; j++){
      do{
        i = random.nextInt(8) + 1;
        if(!ints.contains(i)){
          ints.add(i);
          break;      
        }
      }while(ints.contains(i));
    }
  }


  public boolean equals(Object o){
    if(this== o){
      return true;
    }
    try{
      Node other = (Node)o;
      return value == other.value();
    } catch(ClassCastException e){
      return false;
    }
  }
  public int hashCode(){
    return x + 57 * y;
  }

  public void draw(Graphics g){
    g.setColor(color);
    g.fillOval(x, y, diameter, diameter);
  }

  public void set(int x, int y){
    this.x = x;
    this.y = y;
  }

  public void setPos(int value){
    switch(value){
      case 2: x = 700;
              y = 470;
              break;
      case 3: x = 440;
              y = 470;
              break;
      case 4: x = 850;
              y = 50;
              break;        
      case 5: x = 800;
              y = 355;
              break;
      case 6: x = 220;
              y = 229;
              break;          
      case 7: x = 250;
              y = 50;
              break; 
      case 8: x = 920;
              y = 229;
              break;
      case 9: x = 330;
              y = 355;
              break;
      default: x = 560;
               y = 50;
              break;
    }
  }

  public void setColor(int value){
    int colorValue;
    switch(value){
      case 2: colorValue = 0xff5555ff;
              break;
      case 3: colorValue = 0xff55ff55;
              break;
      case 4: colorValue = 0xff00ffff;
              break;        
      case 5: colorValue = 0xffff5555;
              break;
      case 6: colorValue = 0xffff00ff;
              break;          
      case 7: colorValue = 0xffffff55;
              break; 
      case 8: colorValue = 0xffffffff;
              break;
      case 9: colorValue = 0xffaaaaaa;
              break;
      default: colorValue = 0xffaa5500;
              break;
    }
    this.color = new Color(colorValue);
  }

  public void setBounds(){
        bounds = new Rectangle(x, y, diameter, diameter);
    }

    public int value(){
      return value;
    }

  public boolean inBounds(Point p){
    if(bounds.contains(p)){
      return true;
    }
    return false;
  }
}