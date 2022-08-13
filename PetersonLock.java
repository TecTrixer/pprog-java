import java.util.concurrent.atomic.AtomicIntegerArray;

public class PetersonLock implements Lock2Threads {
    volatile boolean victimIsP = true;
    AtomicIntegerArray flag = new AtomicIntegerArray(2);
    public void lockP() {
        flag.set(0, 1);
        victimIsP = true;
        while (flag.get(1) == 1 && victimIsP) {
            // Wait
        }
    }

    public void lockQ() {
        flag.set(1, 1);
        victimIsP = false;
        while (flag.get(0) == 1 && !victimIsP) {
            // Wait
        }
    }

    public void unlockP() {
        flag.set(0,0);
    }

    public void unlockQ() {
        flag.set(1,0);
    }

    public static void main(String[] args) {
        IntegerReference data = new IntegerReference(0);
        PetersonLock lock = new PetersonLock();
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
