package multiThreading;

public class HelloRunnable implements Runnable {
	public void run() {
		// The code that should be executed by the Thread 
		// is written inside the run method.
        System.out.println("Hello from a thread!");
    }
	
    public static void main(String args[]) {
    	// Create an instance of the Runnable class
    	HelloRunnable obj = new HelloRunnable();
    	
    	// Instantiate a new thread and pass the Runnable 
    	// object to the thread constructor.
    	Thread thread = new Thread(obj);
    	
    	// Begin the execution of the thread
    	thread.start();
    }
}



