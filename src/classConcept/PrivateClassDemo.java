package classConcept;

public class PrivateClassDemo {
	public static void main(String[] args) {
		OuterClass obj = new OuterClass();
		
		// We can access the Teacher class from here.
		OuterClass.Teacher teacher = obj.new Teacher();
		teacher.methodOne();
		
		// The scope of the Student class is restricted only to 
		// the outer class, since it is declared as private. It
		// is not visible outside the OuterClass
//		OuterClass.Student student = obj.new Student();
	}
}

class OuterClass {
	private class Student {
		int aVar = 5;
		
		void methodOne(){
			System.out.println(aVar);
		}
	}
	
	class Teacher {
		int aVar = 7;
		
		void methodOne(){
			System.out.println(aVar);
		}
	}
	
	void outerMethod(){
		// The Student class is accessible only to the outer
		// class.
		Student stu = new Student();
		stu.methodOne();
		System.out.println(stu.aVar);
	}
}

