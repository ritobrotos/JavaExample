package overLoading;

public class ParentChildTester {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.display();
		System.out.println(p1.getClass() + "\n");
		
		Parent p = new Child();
		p.display();		// The child class will overrirde the display method.
//		p.childFunction();		// You can't call childFunction here because the instance type is of parent.
		p.staticMeth();		// You cannot override a static method.
		System.out.println(p.getClass() + "\n");

		Child c = new Child();
		c.display();
		c.childFunction();
		System.out.println(c.getClass());
		Child.staticMeth();
	}

}
