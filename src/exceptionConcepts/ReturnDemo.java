package exceptionConcepts;

public class ReturnDemo {

	public static void main(String[] args) {
		System.out.println(fun());
	}
	
	static int fun(){
		int a=5, b=0, c;
		try {
			c = a/b;
		} catch(Exception e){
			return -1;
		} finally {
			return 0;
		}
	}

}
