/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.util.*;
/**************************
 * In this game, I tried to implement the MVC method
 * this being the method.  I wrote it first after
 * reading the title oneroom. I immediately thought
 * of this horror movie from when I was a kid, cube or
 * something like that where everybody dies, until
 * the savant realizes prime numbers are the safe doors
 * this isn't quite that dramatic, and you can never 
 * "win", the goal is to build the biggest prime number
 * the fastest. But I wanted that to be sort of ambiguous
 * and let players figure out how to play.
 * The room has 9 panels/ aka nodes and this program
 * creates a hashset of 9 random nodes, presents them to
 * the user, the OneRoom has its own operator "+" or "-" 
 * which changes after each choice and operation is complete
 * the choice is either added or subtracted to the total
 * of the previous choices, if the new total is a prime
 * number, the choices remain the same. if the new total
 * is not a prime number, 3 nodes are randomly removed
 * each wrong choice until no choices remain and the
 * total is presented to the player*/
public class OneRoom{

  private long score;
  private char operator;
  private int level;
  private HashSet<Node> choices;
  private int choice;
  private Random random;

  public OneRoom(){
    level = 3;
    operator = '+';
    score = 0;
    initChoices();
    random = new Random();
  }
  
  public void initChoices(){
    score = 0;
    choices = new HashSet<Node>();
    reset();
  }

  public void reset(){
    choices.clear();
    score = 0;
    level = 3;
    for(int i = 1; i < 10; i++){
      choices.add(new Node(i));
    }
  }

  public void killChoices(){
    HashSet<Integer> ints = new HashSet<Integer>();
    ints = fillInts(ints);
    choices.clear();
    for(Integer i: ints){
      choices.add(new Node(i));
    }

  }

  public HashSet<Integer> fillInts(HashSet<Integer> ints){
    int i = random.nextInt(8) + 1;;
    for(int j = 0; j < (level * 3); j++){
      do{
        i = random.nextInt(8) + 1;
        if(!ints.contains(i)){
          ints.add(i);
          break;      
        }
      }while(ints.contains(i));
    }
    return ints;
  }

  public void decLevel(){
    level --;
    killChoices();
  }


  public boolean checkPrime(){
    if(score <= 2){
      return false;
    }
    for(int i = 2; i <= score / 2; i++)
    {
      if(score % i == 0){
        return false;
      }
    }
    return true;
  }

  public void operate(int choice){
    switch(operator){
      case '-': score -= choice;
                break;
      default:  score += choice;
                break;
    }
  }

  public void newOperator(){
    int i = random.nextInt(2);
    switch(i){
      case 0: operator = '+';
              break;
      case 1: operator = '-';
              break;
    }
  }

  public long getScore(){
    return score;
  }

  public char getOperator(){
    return operator;
  }

  public void setChoice(int choice){
    this.choice = choice;
  }
  public int getChoice(){
    return choice;
  }

  public int getLevel(){
    return level;
  }

  public HashSet<Node> getChoices(){
    return choices;
  }

}