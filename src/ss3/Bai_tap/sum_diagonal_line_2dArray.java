package ss3.Bai_tap;

public class sum_diagonal_line_2dArray extends Array2d_template{
    public int diagonalSum(){
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum2+=arr[i][i];
        }
        return sum2;
    }
    public static void main(String[] args) {
        sum_diagonal_line_2dArray a = new sum_diagonal_line_2dArray();
        do {
            a.input();
        }while(a.soDong != a.soCot);

        a.creat_2dArray();
        a.display();
        int sum = a.diagonalSum();
        System.out.println("Tổng các số ở đường chéo chính của ma trận vuông là: "+sum);

    }
}
