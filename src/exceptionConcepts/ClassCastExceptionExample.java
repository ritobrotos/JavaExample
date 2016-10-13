package exceptionConcepts;

public class ClassCastExceptionExample {

	public static void main(String[] args) {
		Object obj = new Integer(100);
	    System.out.println((String) obj);
	}

}
