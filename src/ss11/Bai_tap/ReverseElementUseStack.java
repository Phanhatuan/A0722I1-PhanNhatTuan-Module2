package ss11.Bai_tap;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Stack;

public class ReverseElementUseStack {
    public static void reverseNumber(){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer> ();
        int n = 0 ;
        System.out.print("Input size :");
        n= sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Input element at " + i + " ");
            arr[i]= sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            stack.push(arr[i]);
        }
        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }
    }
    public static void reverseString(){
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String> ();
        String str;
        str = sc.nextLine();
        String[] result = str.split(" ");
        for (int i = 0; i < result.length; i++) {
            stack.push(result[i]);
        }
        while (!stack.isEmpty()) {
            System.out.print( stack.pop()+" ");
        }
    }
    public static void main(String[] args) {
        //  reverseNumber();
        reverseString();
    }
}
