package ss11.Bai_tap;

import java.util.*;

public class CheckPalindrome{

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String> ();
        Queue<String> queue = new ArrayDeque<String>();

        String str = "able was I ere I saw elba";
        String[] result = str.split("");

        for (int i = 0; i < result.length; i++) {
            stack.push(result[i]);
            queue.offer(result[i]);
        }

        int count = 0;

        for (int i = 0; i < result.length; i++) {
            String stackValue =  stack.pop();
            String queueValue =  queue.poll();
            if(stackValue.equals(queueValue)){
                count++;
            }
        }

        if(count == result.length){
            System.out.println("This is Palindrome");
        }

    }


}
