package classConcept;

/*
		* A constructor that have no parameter is known as default constructor.
		* A constructor that have parameters is known as parameterized constructor.
		* If there is no constructor in a class, compiler automatically creates a default constructor.
		* Default constructor provides the default values to the object like 0, null etc. depending on the type.
		* Constructor must have no explicit return type
*/

public class Box {

	private double width;
	private double length;
	private double height;
	private static double DEFAULT_HEIGHT;

	Box(double width, double length, double height) {
		this.width = width;
		this.length = length;
		this.height = height;
	}

	Box(double width, double length) {
		this.width = width;
		this.length = length;
		this.height = DEFAULT_HEIGHT;
	}

	public static void main(String[] args) {
		Box box1 = new Box(10, 20);
		Box box2 = new Box(10, 20, Box.DEFAULT_HEIGHT);
		// As we already have two parameterized constructor for the Box class.
		// Thus the default constructor will not automatically be created by the compiler.
		// Box box3 = new Box();
	}
	
}
