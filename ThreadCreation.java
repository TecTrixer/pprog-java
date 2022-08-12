public class ThreadCreation {
    public static void main(String[] args) {
        // Creating both threads 
        Thread t = new Thread(new RunnableThread());
        Thread t2 = new ComputeThread();
        // Starting both threads...
        t.start();
        t2.start();
        // Join both threads...
        try {
            t.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Error whilst joining threads:" + e.toString());
        }
        System.out.println("Joined both threads");
    }
}

// Using this you at first need to create a thread object out of the runnable.
// This is useful if your object should extend another class.
class RunnableThread implements Runnable {
    public void run() {
        System.out.println("Started RunnableThread");
    }
}

// This is the easiest method, you can simply call t.start() to create a new thread.
class ComputeThread extends Thread {
    public void run() {
        System.out.println("Started ComputeThread");
    }
}
