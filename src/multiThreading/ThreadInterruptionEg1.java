// This example has been taken from : http://www.javatpoint.com/interrupting-a-thread

package multiThreading;

public class ThreadInterruptionEg1  {
	public static void main(String args[]) {
		process1();
	}  
	
	static void process1() {
		Thread t1 = new NormalThread();
		t1.start();		// The thread execution starts here
		try {
			Thread.sleep(4000);		// Making the main thread sleep for 
					// 4secs
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t1.interrupt();		// After 4secs we are interrupting the thread
	}
}

class NormalThread extends Thread {
	public void run() {
		try {
			for(int i=0; i<10; i++){
				System.out.println("Keep printing something!!!");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// The execution of the Thread stops here.
			throw new RuntimeException("Thread interrupted..." + e);
		}
		// This line won't get printed
		System.out.println("Thread is still alive");
	}
}


