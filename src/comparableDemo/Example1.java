// This example has been taken from 
// http://www.javatpoint.com/Comparable-interface-in-collection-framework

package comparableDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Example1 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();  
		al.add(new Student(101, "Vijay", 23));  
		al.add(new Student(106, "Ajay", 27));  
		al.add(new Student(105, "Jai", 21));

		Collections.sort(al);
		
		Iterator it = al.iterator();
		while(it.hasNext()){
			Student st = (Student) it.next();
			System.out.println(st.name);
		}
	}

}

class Student implements Comparable<Student> {
	int rollNo;
	String name;
	int age;

	Student(int rollNo, String name, int age){
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student st){
		if(age == st.age)
			return 0;
		else if(age > st.age)
			return 1;
		else 
			return -1;
	}

}