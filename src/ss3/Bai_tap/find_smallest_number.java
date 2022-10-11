package ss3.Bai_tap;
import java.util.Scanner;

public class find_smallest_number {
    public static void create_array(int arr[]){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
    }
    public static void display (int arr[]){
        System.out.print("Mang la ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int find_smalles_number(int arr[]){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr;
        int aSize;
        System.out.print("Nhap so phan tu mang  ");
        aSize = scanner.nextInt();
        arr = new int[aSize];
        create_array(arr);
        display(arr);
        int smallest = find_smalles_number(arr);
        System.out.println("\nPhan tu nho nhat la " + smallest);
    }
}
