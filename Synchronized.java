public class Synchronized {
    public static void main(String[] args) {
        // Creating shared data
        IntegerReference data = new IntegerReference(0);
        int iterations = 10000;

        // Creating both threads and giving both the reference to the same data.
        Thread t1 = new SynchronizedAddThread(data, iterations);
        Thread t2 = new SynchronizedAddThread(data, iterations);
        
        // Starting both threads, here the behaviour isn't well defined anymore.
        t1.start();
        t2.start();

        // Waiting for both to finish.
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Error whilst joining threads.");
        }

        // Comparing the actual value with the expected value.
        System.out.println("Value of data is " + data.data + ", expected was " + 2*iterations + ".");
    }
}

