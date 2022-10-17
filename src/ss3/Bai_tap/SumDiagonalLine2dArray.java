package ss3.Bai_tap;

public class SumDiagonalLine2dArray extends Array2dTemplate {
    public int diagonalSum(){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i][i];
        }
        return sum;
    }
    public static void main(String[] args) {
        SumDiagonalLine2dArray a = new SumDiagonalLine2dArray();
        do {
            a.input();
        }while(a.soDong != a.soCot);

        a.creat_2dArray();
        a.display();
        int sum = a.diagonalSum();
        System.out.println("Tổng các số ở đường chéo chính của ma trận vuông là: "+sum);

    }
}
