package overLoading;

public class ParentChildTester {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.display();
		System.out.println(p1.getClass());
		
		Parent p = new Child();
		p.display();
//		p.childFunction();		// You can't call childFunction here because the instance type is of parent.
		System.out.println(p.getClass());
		
		Child c = new Child();
		c.display();
		c.childFunction();
		System.out.println(c.getClass());
	}

}
