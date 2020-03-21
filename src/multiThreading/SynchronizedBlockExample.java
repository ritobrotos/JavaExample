package multiThreading;

public class SynchronizedBlockExample {
  private StringBuilder strA = new StringBuilder("A");
  private StringBuilder strB = new StringBuilder("B");

  public static void main(String args[]) {
    SynchronizedBlockExample obj = new SynchronizedBlockExample();
    obj.performOperation();
  }

  private void performOperation() {
    method1(strA);
    method2(strB);
    System.out.println(strA);
    System.out.println(strB);
  }

  private void method1(StringBuilder str) {
    synchronized(this) {
      str.append("Z");
    }
  }

  private void method2(StringBuilder str) {
    synchronized(this) {
      str.append("Y");
    }
  }
}
