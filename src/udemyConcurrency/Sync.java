package udemyConcurrency;

public class Sync {

    private static int counter;

    public static synchronized void increment(String s){
        System.out.println(s);
        ++counter;
    }
    private static void process(int counter) throws InterruptedException {
        Thread t1 = new Thread( new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                   increment("first");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
//                   System.out.println("t2 is running");
                   increment("second");      
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        counter = 0;
        process(counter);
        System.out.println(counter);
        
    }

    


    
}
