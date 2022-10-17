package ss3.Bai_tap;

import java.util.Scanner;

public class InsertElement {

    public static void display (int arr[]){
        System.out.print("Mang la ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void insert(int arr[],int number,int index){
        if(index > 1  && index < arr.length){
            for (int i = arr.length-1; i > index-1; i--) {
                arr[i]=arr[i-1];
                if(i==index){
                    arr[index]=number;
                }
            }
            display(arr);
        }
        else {
            System.out.println("Nhap vi tri khong hop le");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number ;
        int index;
        int[] arr = {10, 4, 6, 7, 8, 0, 0, 0};
        display(arr);
        System.out.print("\nNhap so can them: ");
        number = scanner.nextInt();
        System.out.print("Nhap vi tri can them: ");
        index = scanner.nextInt();
        insert(arr,number,index);
    }
}
