import java.util.concurrent.Semaphore;
public class MTQueue {
	
	private Semaphore sem = new Semaphore(1);
	
	private java.util.Queue<String> statQ;
	
	public MTQueue(){
		statQ = new java.util.LinkedList<String>();
		Thread readThread = new Thread();
		readThread.start();
		Thread writeThread = new Thread();
		writeThread.start();
	}
	
	public void MTPut(String qe){
		try{
			sem.acquire();
			statQ.offer(qe);
		}
		catch(InterruptedException ex){
			
		}
		finally{
			sem.release();
		}
	}
	
	public String MTGet(){
		String retVal = new String();
		try{
			sem.acquire();
			retVal = statQ.poll();
		}
		catch(InterruptedException ex){
			
		}
		finally{
			sem.release();
		}
		return retVal;
	}

}
