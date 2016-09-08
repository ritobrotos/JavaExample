package multiThreading;

public class SynchronizedStatementExample {
	public static void main(String[] args) {
		City obj = new City();
		Thread t1 = new CityThread(obj);
		t1.start();
		Thread t2 = new CityThread(obj);
		t2.start();
	}
}

class CityThread extends Thread {
	City city;
	
	CityThread(City city){
		this.city = city;
	}
	
	public void run() {
		for(int i=0; i<5; i++)
			city.displayCityName();
    }
}

class City {
	String cityName[] = {"Auckland", "Perth", "Cuzco", "Bangkok", "Beirut",
			"Rome", "Barcelona", "Kyoto", "Florence", "Charleston"};
	int cityIndex = 0;
	
	void displayCityName(){
		synchronized(this){
			System.out.println(cityName[cityIndex]);
		}
		cityIndex++;
	}
}

