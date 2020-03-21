package staticConcept;

/**
 * Created by admin on 31/01/17.
 */
public class Example1 {
  public static void main(String args[]){
    Example1Part.met1();

    // A static method can be called from the object of the class.
    new Example1Part().met1();
  }
}

class Example1Part {
  protected static void met1() {
    System.out.println("met1 Method is called.");
  }
}
