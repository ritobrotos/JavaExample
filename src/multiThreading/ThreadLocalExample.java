package multiThreading;

import java.util.ArrayList;

public class ThreadLocalExample {
  public static void main(String[] args) {
    MyRunnable sharedRunnableInstance = new MyRunnable();

    Thread thread1 = new Thread(sharedRunnableInstance);
    Thread thread2 = new Thread(sharedRunnableInstance);

    thread1.start();
    thread2.start();

    try {
      thread1.join(); //wait for thread 1 to terminate
      thread2.join(); //wait for thread 2 to terminate
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  static class MyRunnable implements Runnable {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private ThreadLocal<ArrayList<Integer>> list = new ThreadLocal<ArrayList<Integer>>();

    private double normalDouble = 0.0D;

    @Override
    public void run() {
      threadLocal.set( (int) (Math.random() * 100D) );
      normalDouble = Math.random() * 100D;

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }

      System.out.println("ThreadLocal value: " + threadLocal.get());
      System.out.println("NormalDouble value: " + normalDouble);
    }
  }
}
