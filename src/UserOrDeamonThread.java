import java.util.Random;

public class UserOrDeamonThread extends Thread {
   final private String threadType;

   private final int MAX_ITERATIONS = 1000000;

    public UserOrDeamonThread(Boolean daemonType) {
        if(daemonType){
            //becomes a daemon thread
            setDaemon(true);
            threadType = "daemon";
        }else threadType = "user";
    }

    private int getGCD(int a, int b){
        if(a == 0 || b == 0){
            return 0;
        }

        if(b == 0){
            return a;
        }
        else return getGCD(b, (a%b));
    }

    //hook method running for max iterations
    public void run(){
        final String threadString = " with "
                                    + threadType
                                    + " thread id "
                                    + Thread.currentThread();


        // Create a new Random number generator.  We need to allocate
        // a new Random object dynamically since we can't inherit from
        // Random since we already inherit from Thread and Java only
        // allows single inheritance.
        Random random = new Random();

        try{
        // Iterate for the given # of iterations.
            for (int i = 0; i < MAX_ITERATIONS; ++i) {
                // Generate two random numbers.
                int number1 = random.nextInt();
                int number2 = random.nextInt();

                // Print results every 10 million iterations.
                if ((i % 10000) == 0)
                    System.out.println("In run()"
                            + threadString
                            + " the GCD of "
                            + number1
                            + " and "
                            + number2
                            + " is "
                            + getGCD(number1,
                            number2));
            }
        }finally{
            System.out.println("Leaving run() "
                    + threadString);
        }

    }
}

