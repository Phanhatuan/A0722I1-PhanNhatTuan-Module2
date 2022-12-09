package final_exam.controller;

import final_exam.model.BankAccount;
import final_exam.service.BankServiceImpl;

import java.util.Scanner;

public class BankController {
    static Scanner sc = new Scanner(System.in);
    public static void mainMenu(){
        int number = -1;
        BankServiceImpl bankService = new BankServiceImpl();
        do {
            System.out.println("Chon chuc nang theo so (de tiep tuc)\n" +
                    "1. Them moi\n"+
                    "2. Xoa\n" +
                    "3. Xem danh sach cac tai khoan ngan hang\n" +
                    "4. Tim kiem\n"+
                    "5. Thoat");
            System.out.println("Xin moi chon so: ");
            try{
                number = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Nhap lai");
            }
            switch (number){
                case 1:
                    bankService.addNewBank();
                    break;
                case 2:
                    System.out.println("Nhap id can xoa");
                    String id = sc.nextLine();
                    bankService.remove(id);
                    break;
                case 3:
                    bankService.display();
                    break;
                case 4:
                    System.out.println("Nhap id can tim");
                    String idSearch = sc.nextLine();
                    bankService.search(idSearch);
                    break;
                case 5:
                    System.out.println("The system is stopped.");
                    System.exit(0);
            }
        }while (number < 5);
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
