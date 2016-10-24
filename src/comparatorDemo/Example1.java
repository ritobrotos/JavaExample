package comparatorDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// This example has been taken from:
// http://www.javatpoint.com/Comparator-interface-in-collection-framework

public class Example1 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();  
		al.add(new Student(101, "Vijay", 23));  
		al.add(new Student(106, "Ajay", 27));  
		al.add(new Student(105, "Jai", 21));  
		
		Collections.sort(al, new AgeComparator());
		
		Iterator it = al.iterator();
		while(it.hasNext()){
			Student st = (Student) it.next();
			System.out.println(st.getName());
		}
	}

}

class Student {
	private int rollno;
	private String name;
	private int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
	
	int getAge() {
		return age;
	}
	
	String getName(){
		return name;
	}
}

class AgeComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;

		if (s1.getAge() == s2.getAge())
			return 0;
		else if (s1.getAge() > s2.getAge())
			return 1;
		else
			return -1;
	}
}