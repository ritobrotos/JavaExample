// This example has been taken from: 
// http://www.journaldev.com/122/java-concurrenthashmap-example-iterator

package mapVariety;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		Map<String,String> myMap = new ConcurrentHashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		
		Iterator<String> it = myMap.keySet().iterator();

		while(it.hasNext()){
			String key = it.next();
			if(key.equals("3")){
				// This modification to the map object while iterating through
				// the map is possible only with ConcurrentHashMap. You cannot
				// perform the same operation with HashMap as you will get the
				// ConcurrentModificationException
				myMap.put(key+"new", "new3");
			}
		}
		
		System.out.println(myMap);
	}

}
