package udemyConcurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerAndConsumer {

    private List<Integer> list = new ArrayList<>();
    private final int LIMIT = 5;
    private final int BOTTOM = 0;
    private final Object lock1 = new Object();

    void produce() throws InterruptedException {

        //intrinsic lock of given class
        synchronized (lock1){
            System.out.println("We are in producer method....");
            while(true){
                if(list.size() == LIMIT){
                    System.out.println("Waiting for items to be removed");
                }else{
                    while(list.size() < 5){
                        System.out.println("adding a new item in the list");
                        list.add(ThreadLocalRandom.current().nextInt());
                        lock1.notify(); //let other threads know that iteration is complete
                    }
                }
            }
        }
    }

     void consume() throws InterruptedException {
         //intrinsic lock of given class
         synchronized (lock1){
             System.out.println("We are in consumer method....");
             while(true){
                 if(list.size() == BOTTOM){
                     System.out.println("Waiting for items to be added");
                 }else{
                     while(list.size() == LIMIT || list.size() > LIMIT){
                         System.out.println("removing items in the list");
                         list.remove(0);
                         lock1.notify(); //let other threads know that iteration is complete
                     }
                 }
             }
         }
    }
}

class ProducerAndConsumerApp{

    public static void main(String[] args){
       ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();

        Thread t1 = new Thread(() -> {
            try {
                producerAndConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                producerAndConsumer.consume();
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
