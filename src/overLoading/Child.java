package overLoading;

public class Child extends Parent {
	
	public void childFunction(){
		System.out.println("Call from child function!!!");
	}

	public void display(){
		System.out.println("Child Class");
	}
	
	static void staticMeth(){
		System.out.println("Child Class static Method.");
	}
}
