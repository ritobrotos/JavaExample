package exceptionConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnsupportedOperationExceptionExample {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>(5);
		
		for(int i=1; i<=5; i++)
			al.add(i);
		
		// This method returns an unmodifiable view of the specified list. 
		// This method allows modules to provide users with "read-only" 
		// access to internal lists.
		// Any attempt to modify the returned list, whether direct or via its 
		// iterator, result in an UnsupportedOperationException.
		List unmodifiableList = Collections.unmodifiableList(al);
		
		// This line throws UnsupportedOperationException
		unmodifiableList.add(6);
		
		System.out.println(unmodifiableList);
	}

}
