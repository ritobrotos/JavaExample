package overLoading;

public class HideInstanceVariableEg1 extends Point {

	double x = 4.5, y = 5.7;
	
	public static void main(String[] args) {
		HideInstanceVariableEg1 obj = new HideInstanceVariableEg1();
		obj.printFunction();
	}
	
	void printFunction(){
		System.out.println(x + " , " + y);
		System.out.println(super.x + " , " + super.y);
	}

}

class Point {
	static int x = 2;
	int y = 5;
}
