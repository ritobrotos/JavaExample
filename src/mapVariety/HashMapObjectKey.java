package mapVariety;

import java.util.HashMap;

public class HashMapObjectKey {

	public static void main(String[] args) {
		Person p1 = new Person("Rito", 12);
		Person p2 = new Person("Rito", 12);
		
		HashMap<Person, String> hm = new HashMap<Person, String>(); 
		hm.put(p1, "abc");
		hm.put(p2, "xyz");
		
		System.out.println(hm.size());
		
		ModifiedPerson mp1 = new ModifiedPerson("Rito", 12);
		ModifiedPerson mp2 = new ModifiedPerson("Rito", 12);
		HashMap<ModifiedPerson, String> mphm = new HashMap<ModifiedPerson, String>();
		mphm.put(mp1, "abc");
		mphm.put(mp2, "xyz");
		
		if(mp1.equals(mp2)){
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		System.out.println(mphm.size());
		
//		ModifiedPerson mp3 = new ModifiedPerson("Rito", 12);
//		System.out.println(mphm.get(mp3));
	}

}

class Person {
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
}

class ModifiedPerson {
	String name;
	int age;
	
	ModifiedPerson(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		int hashVal = 0;
        if(name != null){
        	for(int i=0; i<name.length(); i++){
        		hashVal += name.charAt(i);
        	}
        }
        hashVal += age;
        return hashVal;
    }
	
	@Override
	public boolean equals(Object obj){
		ModifiedPerson mpVal = (ModifiedPerson) obj;
		if(mpVal.name.equals(name) && mpVal.age == age){
			return true;
		} else {
			return false;
		}
	}
}
