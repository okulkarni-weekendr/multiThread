package udemyConcurrency;

import static java.lang.Thread.sleep;

public class Worker implements Runnable{
    private volatile boolean isTerminated = false;

    @Override
    public void run() {
        while(!isTerminated){
            System.out.println("Hello from worker class...");

            try{
                sleep(400);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated(){
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }
}

class App{
    public static void main(String[] args){

        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.setTerminated(true);
        System.out.println("Finished...");

    }
}
