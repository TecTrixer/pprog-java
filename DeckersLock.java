public class DeckersLock implements Lock2Threads {
    volatile boolean wantp = false;
    volatile boolean wantq = false;
    volatile int turn = 1;
    public void lockP() {
        wantp = true;
        while (wantq) {
            if (turn == 2) {
                wantp = false;
                while (turn != 1) {
                    // Wait
                }
                wantp = true;
            }
        }
    }

    public void lockQ() {
        wantq = true;
        while (wantp) {
            if (turn == 1) {
                wantq = false;
                while (turn != 2) {
                    // Wait
                }
                wantq = true;
            }
        }

    }

    public void unlockP() {
        turn = 2;
        wantp = false;
    }

    public void unlockQ() {
        turn = 1;
        wantq = false;

    }

    public static void main(String[] args) {
        IntegerReference data = new IntegerReference(0);
        DeckersLock lock = new DeckersLock();
        int iterations = 10000;
        LockTestThread2Threads t1 = new LockTestThread2Threads(lock, true, data, iterations);
        LockTestThread2Threads t2 = new LockTestThread2Threads(lock, false, data, iterations);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Error whilst joining threads.");
        }
        System.out.println("Value of data is " + data.data + ", expected was " + 2*iterations + ".");
    }
}
