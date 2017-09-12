package practice.Greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

//    static int countJobs(int[] s, int[] j){
//        Arrays.sort(s);
//    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
//            int jobs = sc.nextInt();
//            int[] s = new int[jobs];
//            int[] f = new int[jobs];

            List<Map.Entry<Integer, Integer>> lmap = new ArrayList<>();
//            for(int j = 0; j < jobs; j++){
//                s[j] = sc.nextInt();
//            }
//            for(int j = 0; j < jobs; j++){
//                f[j] = sc.nextInt();
//            }

            int s[] =  {1, 3, 0, 5, 8, 5};
            int f[] =  {2, 4, 6, 7, 9, 9};

            for( int j = 0; j < s.length; j++){
                System.out.print(s[j] + " " + f[j] + "|");
            }


            
            for(i = 0; i < s.length; i++){
                lmap.add(new AbstractMap.SimpleEntry<>(s[i], f[i]));
            }
            System.out.println();
            
            lmap.sort((o1, o2) -> (o1.getValue().compareTo(o2.getValue())));
            lmap.forEach((e) -> System.out.print(e.getKey() + " " + e.getValue() + "|"));

            System.out.println();
            int start = 0;
            System.out.print(start + " ");
            int countTotal = 0;
            for(i = 1; i < lmap.size(); i++){
                if(lmap.get(i).getKey() >= lmap.get(start).getKey()){
                    System.out.print(i + " ");
                    start = i;
                }
            }

            System.out.println("total jobs: " + countTotal);
        }
    }
}