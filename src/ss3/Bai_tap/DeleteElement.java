package ss3.Bai_tap;

import java.util.Scanner;

public class DeleteElement {
    public static int find(int arr[],int number){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==number){
                return i;
            }
        }
        return -1;
    }
    public static void display (int arr[]){
        System.out.print("Mang la ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number ;
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("Nhap so can xoa: ");
        number = scanner.nextInt();
        int indexDel = find(arr,number);
        if(indexDel != -1){
            for (int k = indexDel; k < arr.length-1; k++) {
                arr[k] = arr[k+1];
                if(k==5){
                    arr[6]=0;
                }
            }
        } else {
            System.out.println("So nhap vao khong co trong mang");
        }
        display(arr);
    }
}
