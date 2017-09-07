package practice;

import java.util.*;
import java.util.stream.Collectors;

public class StackUsingQueues {
    static class Stack{
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        void push(int num){
            if(q1.isEmpty()){
                q1.offer(num);
                if(!q2.isEmpty()){
                    while(!q2.isEmpty()){
                        q1.offer(q2.poll());
                    }
                }
            }else{
                q2.offer(num);
                while(!q1.isEmpty()){
                    q2.offer(q1.poll());
                }
            }
        }

        void pop(){
            if(!q1.isEmpty()) q1.poll();
            else if(!q2.isEmpty()) q2.poll();
        }

        boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        int top(){
            if(!q1.isEmpty()) return q1.poll();
            else return q2.poll();
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        int[] a = new int[]{1,2,3,4,5};
        for(int i = 0; i < 5; i++){
//            int num  = sc.nextInt();
            stack.push(a[i]);
        }

        for(int i = 0; i < 5; i++){
            if(!stack.isEmpty()){
                System.out.print(stack.top() + " ");
                stack.pop();
            }
        }
        System.out.println();
    }
}
