package multiThreading;

public class JoinFunExample {
	public static void main(String[] args) {
		SpareThread obj1 = new SpareThread();
		Thread t1 = new Thread(obj1);
		t1.start();
		try {
			t1.join();		// The main thread will not execute any further
					// until and unless the thread t1 has completed its execution.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SpareThread obj2 = new SpareThread();
		Thread t2 = new Thread(obj2);
		t2.start();
	}
}

class SpareThread implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("Executing : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}