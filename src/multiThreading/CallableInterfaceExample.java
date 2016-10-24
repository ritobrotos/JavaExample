package multiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableInterfaceExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		Future<Integer> callableFuture = executorService.submit(new Callable<Integer>(){
		    public Integer call() throws Exception {
		    	int a=0, b=1, c;
		    	c = a + b;
		    	int counter = 3;
		    	int seriesNumber = 6;
		    	while(true){
		    		a = b; b = c;
		    		c = a+b;
		    		counter++;
		    		if(counter == seriesNumber)
		    			return c;
		    	}
		    }
		});
		
		try {
			// The Callable's result can be obtained via the Future object returned by the 
			// submit(Callable) method. 
			System.out.println("Value = " + callableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}
}


