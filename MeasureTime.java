public class MeasureTime {
    public static void main(String[] args) {
        Thread t = new MeasureTimeThread(1234);
        System.out.println("Starting thread.");
        long startTime = System.nanoTime();
        t.start();
        try {
            System.out.println("Stopping thread.");
            t.join();
        } catch (Exception e) {
            System.out.println("Error whilst joining thread.");
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1.0e9;
        double roundedDuration = (double)((int)(duration * 1000))/1000;
        System.out.println(roundedDuration + "s elapsed.");
    }
}

class MeasureTimeThread extends Thread {
    int sleepTime;
    MeasureTimeThread(int sleepTime) {
        this.sleepTime = sleepTime;
    }
    public void run() {
        try {
            Thread.sleep(this.sleepTime);
        } catch (Exception e) {
            System.out.println("Error whilst sleeping.");
        }
    }
}
