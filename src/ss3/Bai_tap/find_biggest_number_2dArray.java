package ss3.Bai_tap;
import java.util.Scanner;

public class find_biggest_number_2dArray extends Array2d_template{
    public int find_max(){
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]>max){
                    max= arr[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        find_biggest_number_2dArray a = new find_biggest_number_2dArray();
        a.input();
        a.creat_2dArray();
        a.display();
        int max = a.find_max();
        System.out.println("Max la: " + max);
    }
}
