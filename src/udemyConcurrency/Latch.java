package udemyConcurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Countdown Latch, give a countdown to block task until count reaches zero for a thread
 */
public class Latch {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CountDownLatch latch = new CountDownLatch(5);
        
        for(int i = 0; i < 5; i++){
            executorService.execute(new WorkerLatch(i+1, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All the prerequisites are done...");
        executorService.shutdown();
    }

    static class nestedWorkerLatch{
        private int id;
        private CountDownLatch countDownLatch;
    }
    
}

class WorkerLatch implements Runnable {

    private int id;
    private CountDownLatch countDownLatch;
    private Random random;

    public WorkerLatch(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        doWork();
    }

    void doWork(){
       System.out.println("Thread with id " + this.id + " starts working...." );
       try{
           Thread.sleep(1000);
       }catch(InterruptedException e){
           e.printStackTrace();
       }
    }
}
