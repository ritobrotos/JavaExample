package multiThreading;

public class SynchronizedMethodExample {
	public static void main(String[] args) {
		Counter counter = new Counter();
	    Thread  t1 = new CounterThread(counter);
	    t1.start();
	    Thread  t2 = new CounterThread(counter);
	    t2.start();
	}
}

class CounterThread extends Thread{
    protected Counter counter = null;

    public CounterThread(Counter counter){
       this.counter = counter;
    }

    public void run() {
    	Thread t = Thread.currentThread();
        String name = t.getName();
        
//    	for(int i=0; i<10; i++)
//    		counter.add(1);
//    	System.out.println(counter.count);
        
        for(int i=0; i<5; i++){
        	counter.add(1);
        	counter.print(name + " " + i + "    value: " + counter.count);
        }
        System.out.println("   " + counter.count);
    }
}

class Counter{
    long count = 0;
    public synchronized void add(long value){
    	this.count += value;
    }
    
    public synchronized void print(String val){
		System.out.println(val);
	}
}
