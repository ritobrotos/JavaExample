package multiThreading;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadInterruptionEg2 {
	public static void main(String[] args) {
		process2();
	}
	
	static void process2(){
		Thread t1 = new NormalThreadHandlingInterrupt();
		t1.start();		// The thread execution starts here
		try {
			Thread.sleep(6000);		// Making the main thread 
					// sleep for 6secs
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t1.interrupt();		// After 6secs we are interrupting the thread
	}
}

class NormalThreadHandlingInterrupt extends Thread {
	public void run() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		try {
			for(int i=0; i<5; i++){
				Date date = new Date();
				System.out.println("Current Time: " + dateFormat.format(date));
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			// The InterruptedException exception is caught here.
			System.out.println("Thread interrupted..." + e);
		}
		// This line gets printed as the thread is still alive
		System.out.println("Thread is still alive");
	}
}



