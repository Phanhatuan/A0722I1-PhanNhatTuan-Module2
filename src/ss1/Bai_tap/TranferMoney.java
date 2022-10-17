package ss1.Bai_tap;
import java.util.Scanner;

public class TranferMoney {
    public static void main(String[] args) {
        System.out.println("Enter money want to tranfer: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int VND = number * 23000;
        System.out.println("VND: "+VND);

    }
}
