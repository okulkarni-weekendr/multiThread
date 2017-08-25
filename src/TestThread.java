public class TestThread{

    public static void main(String[] args){
        System.out.println("Entering main()");

        //create deamon thread
        final Boolean daemonThread = args.length > 0;

        //create appropriate type of thread
        UserOrDeamonThread thr = new UserOrDeamonThread(daemonThread);

        thr.start();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Leaving main()");
    }
}
