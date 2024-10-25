public class HelpDeskApp{
    public static void main(String[] args) {
        
        //Get the singleton instance
        CentralizedQueueSystem queueSystem = CentralizedQueueSystem.getInstance();

        System.out.println("Help Desk 1:");
        queueSystem.getNextQueueNo(); //serves 1st customer
        queueSystem.getNextQueueNo(); //serves next customer

        System.out.println("\nHelp Desk 2:");
        queueSystem.getNextQueueNo();

        System.out.println("\nHelp Desk 1 resets the queue: ");
        queueSystem.resetQueue(1); 

        queueSystem.getNextQueueNo(); //starts with 40

        System.out.println("\nPausing the queue for reoganization....");
        queueSystem.pauseQueue();
        queueSystem.getNextQueueNo(); //indicates the queue is being paused

        System.out.println("\nResuming the queue :)");
        queueSystem.resumeQuene();
        queueSystem.getNextQueueNo(); //resume and serves the next customer
    }
}