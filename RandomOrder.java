public class RandomOrder {
    public static void main(String[] args) {
        int iterations = 10;

        // Creating both threads and letting them execute in parallel.
        Thread t1 = new RandomOrderAddThread(iterations, 1);
        Thread t2 = new RandomOrderAddThread(iterations, 2);
        
        // Starting both threads, here the order isn't well defined anymore.
        t1.start();
        t2.start();

        // Waiting for both to finish.
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Error whilst joining threads.");
        }

        System.out.println("Both threads finished.");
    }
}

// Thread which will print if its currently running.
class RandomOrderAddThread extends Thread {
    int iterations;
    int id;

    // Class constructor
    public RandomOrderAddThread(int iterations, int id) {
        this.iterations = iterations;
        this.id = id;
    }

    // Main running method
    public void run() {
        for (int i = 0; i < this.iterations; i++) {
            // Printing that its currently running, this locks on the stdout object.
            System.out.println("Thread " + this.id + " is currently running.");
        }
    }
}
