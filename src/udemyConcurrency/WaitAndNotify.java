package udemyConcurrency;

public class WaitAndNotify {
    public void produce() throws InterruptedException {

        //intrinsic lock of given class
        synchronized (this){
            System.out.println("We are in producer method....");
            wait();  // other thread in the same class can get the intrinsic lock on the same class
            System.out.println("Again producer method....");
        }
    }

    public void consume() throws InterruptedException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            System.out.println("Consumer method....");
            notify();
        }
    }
}

class WaitAndNotifyApp{
    
    public static void main(String[] args){
        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread t1 = new Thread(() -> {
            try {
                waitAndNotify.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                waitAndNotify.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
