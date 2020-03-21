package interfaceConcept;

/**
 * Created by admin on 22/11/16.
 */
public class UseAbstractMethod {



    public static void main(String[] args) {
//        Interface1 var1 = Abstract1.
    }
}

interface Interface1 {

}

class ChildInterface implements Interface1 {

}

abstract class Abstract1 {

    private static Abstract1 instance = null;

    public static Abstract1 getInstance() {
        instance = ((instance!=null) ? instance : new ExtendingClass1());
        return instance;
    }

    public abstract Interface1 method1();
}

class ExtendingClass1 extends Abstract1 {
    public Interface1 method1() {
        return new ChildInterface();
    }
}