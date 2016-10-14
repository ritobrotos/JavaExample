// The example can be found here: https://www.youtube.com/watch?v=6pLEwJP1Afk
// 
package stringConcept;

public class Example1 {

	public static void main(String[] args) {
		
		String s1 = "Hello";	// cached in the String pool
		
		// Since the value of s1 and s2 are same Java String Interning will make s2 point
		// the same String object in the string pool.
		String s2 = "Hello";	
		
		// The answer will be true as both of them are pointing to the same memory location
		System.out.println("Do they have same rference? " + (s1==s2));
		
		s2 = "World";
		// The answer is false now as s2 is now pointing to different memory location 
		System.out.println("Do they have same rference? " + (s1==s2));
		
		String s3 = new String("Hello");	// JVM will create a separate object for this string
		// The answer will be false, as JVM allocated separate  memory for s3
		System.out.println("Do they have same rference? " + (s1==s3));
		
		String s4 = s3.intern();
		// The answer is true, because after applying the intern method on s3, it looked for the
		// s3 content in the String pool and since it was already there it made s4 refer to that
		// String object.
		System.out.println("Do they have same rference? " + (s1==s4));
		
	}

}
