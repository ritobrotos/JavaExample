package mapVariety;

import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(null, "Null key");		// The key can be null in hashmap
		hm.put(1, "Value one");
		hm.put(2, null);	// The value can be null
		hm.put(null, null);		// Both key and value can also be null
		
		System.out.println(hm);
	}

}
