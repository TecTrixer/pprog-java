// Thread in which the data race is being prevented by using synchronized.
public class SynchronizedAddThread extends Thread {
    IntegerReference data;
    int iterations;

    // Class constructor
    public SynchronizedAddThread(IntegerReference data, int iterations) {
        this.data = data;
        this.iterations = iterations;
    }

    // Main running method
    public void run() {
        // Adding 1 to the data for each iteration.
        for (int i = 0; i < this.iterations; i++) {
            // Using synchronized to lock the data object for modification
            synchronized (this.data) {
                this.data.data = this.data.data + 1;
            }
        }
    }
}

