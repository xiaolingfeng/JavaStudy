package threadTest;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {

  }
}

class RunnableDemo implements Runnable{
  private Thread t;
  private String threadName;
  RunnableDemo(String threadName){
    this.threadName = threadName;
    System.out.println("Creating Thread:" + threadName);
  }

  /**
   * @author Martin
   * @param {}
   * @return void
   */
  public void run(){
    System.out.println("Running " + threadName);
    try{
      for(int i = 0 ; i < 4 ; i++){
        System.out.println("Thread:" + threadName + ", " + i);
      }
    }catch (Exception e){
      System.out.println("Thread " + threadName + " Interrupted");
    }
    System.out.println("Thread " + threadName + " exiting");
  }

  public void start(){
    System.out.println("Starting" + threadName);
    if(t == null){
      t = new Thread(this, threadName);
      t.start();
    }
  }
}

class TestThread{
  public static void main(String[] args) {
    RunnableDemo R1 = new RunnableDemo("Thread-1");
    R1.start();

    RunnableDemo R2 = new RunnableDemo("Thread-2");
    R2.start();
  }
}

class ThreadDemo extends Thread{
  private Thread t;
  private final String threadName;

  ThreadDemo(String name){
    threadName = name;
    System.out.println("Creating " + threadName);
  }

  @Override
  public void run() {
    System.out.println("Running "+threadName);
    for (int i = 0 ; i < 4 ; i++){
      System.out.println("Thread " + threadName + ", " + i);
      System.out.println("Thread State" + (t.isDaemon() ? "daemon" : "Users"));
    }
    System.out.println("Thread " + threadName + "exiting");
  }

  public void start() {
    System.out.println("Thread " + threadName  + "Start");
    if(t == null){
      t = new Thread(this, threadName);
      t.start();
    }
  }
}

class ThreadTest2{
  public static void main(String[] args) {
    ThreadDemo R1 = new ThreadDemo("Thread-1");
    R1.start();

    ThreadDemo R2 = new ThreadDemo("Thread-2");
    R2.start();

  }
}