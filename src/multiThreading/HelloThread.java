package multiThreading;

public class HelloThread extends Thread {
	
	public void run() {
		// The code that is to be executed is written
		// inside the run method.
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
    	// Create an object of the Thread subclass.
    	HelloThread obj = new HelloThread();
    	
    	// Begin the execution of the thread.
        obj.start();
    }
}


