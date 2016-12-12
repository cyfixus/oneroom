/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/***************
 * I couldn't get the listeners to cooperate so I made an implementation
 * of mouselistener and motion  added some boolean tracking for clicks*/
public class Mouse implements MouseListener, MouseMotionListener{
  
  private static int mouseX = -1;
  private static int mouseY = -1;
  private static int mouseB = -1; 
  private boolean clicked;
  
  public static int getX(){
      return mouseX;
  }
  
  public static int getY(){
      return mouseY;
  }
  
  public static int getButton(){
      return mouseB;
  }
  
  public void mouseDragged(MouseEvent e) {
      mouseX = e.getX();
      mouseY = e.getY();
    
  }
  public void mouseMoved(MouseEvent e) {
      mouseX = e.getX();
      mouseY = e.getY();
    
  }
  public void mouseClicked(MouseEvent e) {
      mouseB = e.getButton();
      mouseX = e.getX();
      mouseY = e.getY();
      click();
  }
  public void mouseEntered(MouseEvent e) {
    
  }
  public void mouseExited(MouseEvent e) {
    
  }
  public void mousePressed(MouseEvent e) {
      mouseB = e.getButton();    
  }
  public void mouseReleased(MouseEvent e) {
      mouseB = MouseEvent.NOBUTTON;
    
  }

  public void click(){
    clicked = !clicked;
  }

  public boolean clicked(){
    return clicked;
  }

  public Point getPoint(){
    Point point = new Point(mouseX, mouseY);
    return point;
  }

}