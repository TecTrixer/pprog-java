public class LockTestThread2Threads extends Thread {
    Lock2Threads lock;
    boolean isP;
    IntegerReference data;
    int iterations;
    public LockTestThread2Threads(Lock2Threads lock, boolean isP, IntegerReference data, int iterations) {
        this.lock = lock;
        this.isP = isP;
        this.data = data;
        this.iterations = iterations;
    }
    public void run() {
        if (isP) {
            for (int i = 0; i < this.iterations; i++) {
                this.lock.lockP();
                this.data.data += 1;
                this.lock.unlockP();
            }
        } else {
            for (int i = 0; i < this.iterations; i++) {
                this.lock.lockQ();
                this.data.data += 1;
                this.lock.unlockQ();
            }
        }
    }
}
