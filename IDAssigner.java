/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
/********
 * makes sure pooledthreads have unique ids*/
public class IDAssigner{
  private int baseID;

  public IDAssigner(int baseID){
     this.baseID = baseID;
  }

  public int next(){
    return baseID++;
  }

  public int getID(){
    return baseID;
  }
}