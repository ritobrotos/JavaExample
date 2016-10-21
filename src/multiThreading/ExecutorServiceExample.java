// The example has been taken from: 
// http://tutorials.jenkov.com/java-util-concurrent/executorservice.html

package multiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		// Creates an Executor that uses a single worker thread operating off an unbounded queue. 
		// (Note however that if this single thread terminates due to a failure during execution 
		// prior to shutdown, a new one will take its place if needed to execute subsequent tasks.) 
		// Tasks are guaranteed to execute sequentially, and no more than one task will be active 
		// at any given time.
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();

		// Creates a thread pool that reuses a fixed number of threads operating off a shared 
		// unbounded queue. At any point, at most nThreads threads will be active processing tasks. 
		// If additional tasks are submitted when all threads are active, they will wait in the queue 
		// until a thread is available. If any thread terminates due to a failure during execution prior 
		// to shutdown, a new one will take its place if needed to execute subsequent tasks. The threads 
		// in the pool will exist until it is explicitly shutdown.
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);

		// Creates a thread pool that can schedule commands to run after a given delay, or to 
		// execute periodically.
		ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
		
		// The execute(Runnable) method takes a java.lang.Runnable object, and executes it asynchronously. 
		// Note that there is no way of obtaining the result of the executed Runnable.
		executorService1.execute(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task execute");
		    }
		});
		executorService1.shutdown();
		
		// The submit(Runnable) method also takes a Runnable implementation, but returns a Future object. 
		// This Future object can be used to check if the Runnable has finished executing.
		Future future = executorService2.submit(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task with future");
		    }
		});
		try {
			Object ob = future.get();		//returns null if the task has finished correctly.
			if(ob == null)
				System.out.println("Task completed successfully!!!");
			else
				System.out.println("Task not completed successfully!!!");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService2.shutdown();
		
		// The submit(Callable) method is similar to the submit(Runnable) method except for the type of 
		// parameter it takes. The Callable instance is very similar to a Runnable except that its call() 
		// method can return a result. The Runnable.run() method cannot return a result.
		Future callableFuture = executorService3.submit(new Callable(){
		    public Object call() throws Exception {
		        System.out.println("Asynchronous Callable");
		        return "Callable Result";
		    }
		});
		try {
			// The Callable's result can be obtained via the Future object returned by the 
			// submit(Callable) method. 
			System.out.println("future.get() = " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService3.shutdown();
		// To terminate the threads inside the ExecutorService you call its shutdown() method. The  
		// ExecutorService will not shut down immediately, but it will no longer accept new tasks, and  
		// once all threads have finished current tasks, the ExecutorService shuts down.

	}

}
