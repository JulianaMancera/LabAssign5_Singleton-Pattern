public class CentralizedQueueSystem{
    
    public static CentralizedQueueSystem instance;
    private int currentQueueNo;
    private boolean isQueueInProgess;

    // Private constructor
    private CentralizedQueueSystem(){
        currentQueueNo = 1;
        isQueueInProgess = true;

    }

    //singleton instance of CentralizedQueueSystem
    public static synchronized CentralizedQueueSystem getInstance(){
        if (instance == null){
            instance = new CentralizedQueueSystem(); 
        }
        return instance;
    }

    // Check if queue is in progress
    public synchronized boolean isQueueInProgress() {
        return isQueueInProgess;
    }
    
    // Retrieve the next queue number
    public synchronized int getNextQueueNo(){
        if(isQueueInProgess){
            System.out.println("Serving customer with Queue Number: "+currentQueueNo);
            return currentQueueNo++;
        }

        else{
            System.out.println("Queue is reset. Please wait");
            return -1; //it means no customer is served
        }
    }

    // Reset the queue number to a specified value
    public synchronized void resetQueue(int newQueueNo){
        currentQueueNo = newQueueNo;
        isQueueInProgess = true;
        System.out.println("Queue has been reset to start from: "+newQueueNo);
    }

     // Pause the queue 
    public synchronized void pauseQueue(){
        isQueueInProgess = false;
        System.out.println("Queue is temporary paused.");
    }

     // Pause the queue [if paused]
    public synchronized void resumeQuene(){
        isQueueInProgess = true;
        System.out.println("Queue is resumed.");
    }

}