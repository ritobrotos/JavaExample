package mapVariety;

import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		TreeMap<Integer,String>  tm = new TreeMap<Integer,String>();
        tm.put(5 , "String 5");
        tm.put(1 , "String 1");
        tm.put(3 , "String 3");
        tm.put(2 , "String 2");
        tm.put(10, null);	// The value can be null
        
        // You will get a NullPointerException if you put the key as null
        tm.put(null, "String null");	
        
        System.out.println(tm);
	}

}
