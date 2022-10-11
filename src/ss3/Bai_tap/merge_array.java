package ss3.Bai_tap;
import java.util.Scanner;

public class merge_array {
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
    public static void merge(int arr[],int arr1[],int arr2[]){
        for (int i = 0; i < arr.length; i++) {
            arr2[i]=arr[i];
        }
        int l = 0;
        for (int k = arr.length; k < arr2.length; k++) {
            arr2[k]=arr1[l];
            l++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr;
        int aSize;
        System.out.print("Nhap so phan tu mang thu nhat ");
        aSize = scanner.nextInt();
        arr = new int[aSize];
        create_array(arr);
        display(arr);
        System.out.println();

        int[] arr1;
        int aSize1;
        System.out.print("Nhap so phan tu mang thu hai ");
        aSize1 = scanner.nextInt();
        arr1 = new int[aSize1];
        create_array(arr1);
        display(arr1);
        System.out.println();

        int[] arr2;
        int aSize2 = aSize + aSize1;
        arr2 = new int[aSize2];
        merge(arr,arr1,arr2);
        display(arr2);
    }
}
