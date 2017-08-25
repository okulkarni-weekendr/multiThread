public class Main implements Runnable {

    public static void main(String[] args) {

        TestThread t1 = new TestThread();
        System.out.println("Hello World!");
    }


    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("Runnable1: " + i);
        }
    }
}
                                                                          