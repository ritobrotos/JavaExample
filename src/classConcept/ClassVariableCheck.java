package classConcept;

public class ClassVariableCheck {

	public static void main(String[] args) {
		
	}

}

class DemoClass {
	
	public static void getVal(){
		// Declaring a variable static is not 
		// allowed inside a method, thus it is 
		// showing error here.
//		static int varA = 10;
		
		int varB = 12;
		
		// You can not use any access modifier like
		// private, protected or public while 
		// declaring a variable inside a method.
//		private int varC = 14;
//		public int varD = 15;
//		protected int varE = 16;
		
		// You are only use field modifier final
		// while declaring a variable inside a 
		// method.
		final int varF = 17;
	}
}





