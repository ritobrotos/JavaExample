// The code has been taken from: 
// http://www.java67.com/2012/12/producer-consumer-problem-with-wait-and-notify-example.html
// The explanation of Producer Consumer Solution can be found here:
// https://www.youtube.com/watch?v=u3MUdI1B-X8

package multiThreading;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerSolution {

	public static void main(String args[]) {
        Vector sharedQueue = new Vector();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
        prodThread.start();
        consThread.start();
    }
}

class Producer implements Runnable {
	private final Vector sharedQueue;
	private final int SIZE;

	public Producer(Vector sharedQueue, int size){
		this.sharedQueue = sharedQueue;
		this.SIZE = size;
	}

	@Override
	public void run() { 
		for(int i=0; i<7; i++){
			System.out.println("Produced: " + i);
			try {
				produce(i);
			} catch(InterruptedException ex){
				Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		while(sharedQueue.size() == SIZE){	// wait if queue is full
			synchronized(sharedQueue){	// We have put an intrinsic lock on the sharedQueue object
				System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting, size: " + sharedQueue.size());
				sharedQueue.wait();		// Since the sharedQueue is full now so the Producer thread will stop producing and will wait
			}
		}

		synchronized(sharedQueue){	// We have put an intrinsic lock on the sharedQueue object
			sharedQueue.add(i);
			sharedQueue.notifyAll();
		}
	}
}


class Consumer implements Runnable {
	private final Vector sharedQueue;
	private final int SIZE;

	public Consumer(Vector sharedQueue, int size){
		this.sharedQueue = sharedQueue;
		this.SIZE = size;
	}

	@Override
	public void run(){
		while(true){
			try{
				System.out.println("Consumed: " + consume());
				Thread.sleep(50);
			} catch(InterruptedException ex){
				Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private int consume() throws InterruptedException {
		while(sharedQueue.isEmpty()){
			synchronized(sharedQueue){
				System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting, size: " + sharedQueue.size());
				sharedQueue.wait();
			}
		}

		synchronized(sharedQueue){
			sharedQueue.notifyAll();
			return (Integer) sharedQueue.remove(0);
		}
	}
}