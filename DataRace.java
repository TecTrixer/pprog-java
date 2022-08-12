public class DataRace {
    public static void main(String[] args) {
        // Creating shared data
        IntegerReference data = new IntegerReference(0);
        int iterations = 10000;

        // Creating both threads and giving both the reference to the same data.
        Thread t1 = new AddThread(data, iterations);
        Thread t2 = new AddThread(data, iterations);
        
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

// Thread in which the data race occurs.
class AddThread extends Thread {
    IntegerReference data;
    int iterations;

    // Class constructor
    public AddThread(IntegerReference data, int iterations) {
        this.data = data;
        this.iterations = iterations;
    }

    // Main running method
    public void run() {
        // Adding 1 to the data for each iteration.
        for (int i = 0; i < this.iterations; i++) {
            // Data Race: Here both threads access the same data and manipulate it;
            this.data.data = this.data.data + 1;
        }
    }
}

// This is a replacement for Integer so it doesn't have weird behaviour.
class IntegerReference {
    public int data;
    IntegerReference(int data) {
        this.data = data;
    }
}
