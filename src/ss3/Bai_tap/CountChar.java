package ss3.Bai_tap;
import java.util.Scanner;
public class CountChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi:");
        String str = scanner.nextLine();
        System.out.println("Nhập ký tự:");
        char letter = scanner.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==letter){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện là " + count);
    }
}
