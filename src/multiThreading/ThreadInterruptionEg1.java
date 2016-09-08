// This example has been taken from : http://www.javatpoint.com/interrupting-a-thread

package multiThreading;

public class ThreadInterruptionEg1  {
	
	public static void main(String args[]) {
		process1();
//		process2();
	}  
	
	static void process2(){
		NormalThreadHandlingInterrupt t1 = new NormalThreadHandlingInterrupt();
		t1.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t1.interrupt();
	}
	
	static void process1() {
		NormalThread t1 = new NormalThread();
		t1.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t1.interrupt();
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
		System.out.println("Thread is still alive");
	}
}

class NormalThreadHandlingInterrupt extends Thread {
	public void run() {
		try {
			for(int i=0; i<5; i++){
				System.out.println("Print time: " + System.currentTimeMillis());
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			// The execution of the Thread stops here.
			System.out.println("Thread interrupted..." + e);
		}
		System.out.println("Thread is still alive");
	}
}
