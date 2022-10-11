package ss3.Bai_tap;

import java.util.Scanner;

public class sum_col_2dArray extends Array2d_template{
    public int sum(int col){
        if(col>arr[0].length-1){
            System.out.println("Nhap col khong hop le");
            return 0;
        }
        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][col];
        }
        return sum1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sum_col_2dArray a = new sum_col_2dArray();
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
