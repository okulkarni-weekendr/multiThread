package udemyConcurrency;


/**
 * ReentrantLock
 */

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Lock {

    private static int counter = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void increment(){
        counter++;
    }

    public static void main(String[] args){
        int sum = IntStream.range(0,10)
                        .peek(e -> System.out.println("Element to be mapped -> " + e))
                        .filter(n -> n % 3 == 0 || n % 5 == 0)
                        .peek(e -> System.out.println("Filtered element is -> " + e))
                        .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
