package genericConcept;

public class GenericClassExample {
  public static void main(String args[]){
    MyGenericType<Integer> integerObj = new MyGenericType<Integer>();
    integerObj.set(5);

    MyGenericType<String> stringObj = new MyGenericType<String>();
    stringObj.set("StringVal");

    System.out.println(integerObj.get());
    System.out.println(stringObj.get());
  }
}

class MyGenericType<T> {
  private T obj;
  protected void set(T objValue){
    this.obj = objValue;
  }
  protected T get(){
    return this.obj;
  }
}
