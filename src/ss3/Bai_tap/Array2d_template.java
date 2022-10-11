package ss3.Bai_tap;

import java.util.Scanner;

public class Array2d_template {
    int soDong;
    int soCot;
    int[][] arr;
    public void input(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhap so dong: ");
            soDong=scanner.nextInt();
            System.out.print("Nhap so cot: ");
            soCot=scanner.nextInt();
        }while(soDong < 0 && soCot < 0);
        if(soCot > 0 & soDong > 0){
            arr = new int[soDong][soCot];
        }
    }
    public void creat_2dArray(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Nhập phần tử thứ [" + i + ", " + j + "]: ");
                arr[i][j] = scanner.nextInt();
            }
        }
    }
    public void display(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
