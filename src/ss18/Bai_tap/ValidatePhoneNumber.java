package ss18.Bai_tap;

import java.util.Scanner;

public class ValidatePhoneNumber {
    private static final String PHONE_REGEX = "^(84|0[3|5|7|8|9])+([0-9]{8})\\b$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phoneNumber;
        do {
            System.out.print("Input phone number:");
            phoneNumber = scanner.nextLine();
        } while (!phoneNumber.matches(PHONE_REGEX));
    }
}
