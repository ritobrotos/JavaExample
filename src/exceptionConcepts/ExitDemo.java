package exceptionConcepts;

public class ExitDemo {

	public static void main(String[] args) {
		System.out.println(fun());
	}
	
	static int fun(){
		int a=5, b=0, c;
		try {
			c = a/b;
		} catch(Exception e){
			System.exit(1);
		} finally {
			System.out.println("The finally block.");
		}
		return 0;
	}
}



