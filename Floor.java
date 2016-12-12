/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.awt.*;

/*****************
 * Floor is the pink/white double triangle on the black background
 * it changes color depending on the active operator of OneRoom*/
public class Floor{
  private char operator;
  private Color color;

  public Floor(){
    operator = '+';
  }

  public Floor(char operator){
    this.operator = operator;
    initColor();
  }

  public void draw(Graphics g){
    g.setColor(color);
    g.drawPolygon(new int[] {125, 1075, 600}, new int[] {100, 100, 600}, 3);
    g.drawPolygon(new int[] {25, 1175, 600}, new int[] {50, 50, 700}, 3);

  }

  public void initColor(){
    int colorValue;
    if(operator == '-'){
      colorValue = 0xffffffff;
    }
    else{
      colorValue = 0xffff00ff;
    }
    color = new Color(colorValue);
  }

  public void setOperator(char operator){
    this.operator = operator;
    initColor();
  }

}