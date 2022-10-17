package ss3.Bai_tap;

import java.util.Scanner;

public class SumCol2dArray extends Array2dTemplate {
    public int sum(int col){
        if(col>arr[0].length-1){
            System.out.println("Nhap col khong hop le");
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][col];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SumCol2dArray a = new SumCol2dArray();
         a.input();
         a.creat_2dArray();
         a.display();
         int col;
        System.out.println("Nhap cot muon tinh tong: ");
         col = scanner.nextInt();
         int sum = a.sum(col);
        System.out.println("Tong cua cot da chon la: "+sum);
    }
}
