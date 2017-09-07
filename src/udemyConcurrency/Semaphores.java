package udemyConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *  - semaphore maintains a set of permits
 *  - acquire() -> if a permit is available then takes it
 *  - release() -> adds a permit
 *
 *  - Semaphores keep count of the number available
 *      new Semaphore(int permits, boolean fair) // fair -> longest waiting thread
 *      will get the lock
 */

/**
 * Threadsafe execution using enum and singleton pattern vs orthodox impl
 */
enum Downloader {
    INSTANCE;

    private Semaphore semaphore = new Semaphore(3, true);

    public void downloadData(){
        try {
            semaphore.acquire();
            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    private void download(){
        System.out.println("Downloading from the web....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Semaphores {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 12; i++){
            executorService.execute(Downloader.INSTANCE::downloadData);
        }
    }
}

