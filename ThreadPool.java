/***************************
 *cyfixus 2016dec  LD 37   *
 **************************/
import java.util.*;

/*********
 * ThreadPool is a boiler plate thred pooling class to manage
 * the game state and music player, for the lovely background music*/
public class ThreadPool extends ThreadGroup{

  private boolean alive;
  private List<Runnable> taskQueue;
  private IDAssigner poolID = new IDAssigner(1);
  private int id;



  public ThreadPool(int numThreads){
    super("ThreadPool");
    this.id = poolID.getID();
    setDaemon(true);
    taskQueue = new LinkedList<Runnable>();
    alive = true;
    for(int i = 0; i < numThreads; i++){
      new PooledThread(this).start();
    }
  }

  public synchronized void runTask(Runnable task){
    if(!alive){
      throw new IllegalStateException("ThreadPool deadPool: " + id);
    }
    if(task != null){
      taskQueue.add(task);
      notify();
    }
  }

  public synchronized void close(){
    if(!alive){
      return;
    }
    alive = false;
    taskQueue.clear();
    interrupt();
  }

  public void join(){
    synchronized(this){
      alive = false;
      notifyAll();
    }

    Thread[] threads = new Thread[activeCount()];
    int count = enumerate(threads);

    for(int i = 0; i < count; i++){
      try{
        threads[i].join();
      }catch(InterruptedException e){

      }
    }
  }

  protected synchronized Runnable getTask() throws InterruptedException{
    while(taskQueue.size() == 0){
      if(!alive){
        return null;
      }
      wait();
    }
    return taskQueue.remove(0);
  }
  
}