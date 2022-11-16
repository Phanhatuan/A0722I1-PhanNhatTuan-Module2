package ss13.Bai_tap;

import java.util.Scanner;

public class BinarySearchUsingRecursion {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    static int binarySearchRecursion(int[] list, int key,int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            // If found at mid, then return it
            if (list[mid] == key)
                return mid;
            // Search the left half
            if (list[mid] > key)
                return binarySearchRecursion(list, key, low, mid - 1);
            // Search the right half
            return binarySearchRecursion(list, key, mid + 1, high);
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchUsingRecursion ob = new BinarySearchUsingRecursion();
        int array[] = { 3, 4, 5, 6, 7, 8, 9 };
        int n = array.length;
        int x = sc.nextInt();
        int result = ob.binarySearchRecursion(array, x, 0, n - 1);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }
}
