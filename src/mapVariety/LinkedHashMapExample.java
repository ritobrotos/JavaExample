package mapVariety;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(5, "Value 5");
		lhm.put(8, null);		// The value can be null
		lhm.put(1, "Value 1");
		lhm.put(null, "Null Value");	// The key can be bull
		
		System.out.println(lhm);
	}

}
