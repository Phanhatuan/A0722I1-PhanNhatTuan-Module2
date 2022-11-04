package ss11.Bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer> ();
        while(number > 0){
            if(number % 2 == 0){
                stack.push(0);
            }
            else {
                stack.push(1);
            }
            number = number / 2;
        }
        System.out.println("Binary number is: ");
        while (!stack.isEmpty()) {
            System.out.print( stack.pop());
        }
    }
}
