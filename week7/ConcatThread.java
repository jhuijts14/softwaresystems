package ss.week7;


public class ConcatThread extends Thread {
    private static String text = ""; // global variable
    private String toe;
    
    public static Object lock = new Object();
    

    public ConcatThread(String toeArg) {
        this.toe = toeArg;
    }

    public String getText() {
    	return text;
    }
    public void run() {
    	synchronized (lock) {
    		if (text.equals("two;")) {
    			try {
    				lock.wait();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    		
    		text = text.concat(toe);
    		
    		lock.notifyAll();
    		
    	}
    }
    

    public static void main(String[] args) {
        
    	Thread concat1 = new ConcatThread("one;");
    	Thread concat2 = new ConcatThread("two;");
    	
    	concat1.start();
        concat2.start();
        
        
        try {
        	concat1.join();
        	concat2.join();
        } catch (InterruptedException e) {
        	System.out.println("Couldn't join the threads!");
        	e.printStackTrace();
        }
        
        
        System.out.println(text);
        
    }
}
