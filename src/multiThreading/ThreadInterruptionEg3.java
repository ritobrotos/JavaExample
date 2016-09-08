package multiThreading;

public class ThreadInterruptionEg3 {

	public static void main(String[] args) {
		Thread t = new NormalThreadWithoutInterrupt();
		t.start();		// The thread execution starts here
		t.interrupt();	// Interrupting the thread here
		System.out.println("Interrupted");
	}

}


class NormalThreadWithoutInterrupt extends Thread {
	public void run() {
		for (int i = 1; i < 5000; i++) 
			System.out.print("Print value: " + i);
	}
}




