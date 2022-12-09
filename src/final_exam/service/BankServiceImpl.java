package final_exam.service;

import final_exam.model.BankAccount;
import final_exam.model.PayAccount;
import final_exam.model.SaveAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankServiceImpl {
    Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> bankList = new ArrayList<>();
    private static final String FILE_BANK_PATH = "D:\\CodeGym\\Module_2\\src\\final_exam\\data\\bank_accounts.csv";

    public SaveAccount inputSaveAccountInfo(){
        System.out.println("Nhap ma tai khoan: ");
        String maTk = sc.nextLine();
        System.out.println("Nhap ten chu tai khoan: ");
        String ten = sc.nextLine();
        System.out.println("Nhap ngay tao: ");
        String ngayTao = sc.nextLine();
        System.out.println("Nhap so tien tiet kiem: ");
        double tienGui = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap ngay gui tiet kiem: ");
        String ngayGui = sc.nextLine();
        System.out.println("Nhap lai suat: ");
        double laiSuat = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap ki han: ");
        int kiHan = Integer.parseInt(sc.nextLine());
        return new SaveAccount(maTk,ten,ngayTao,tienGui,ngayGui,laiSuat,kiHan);
    }
    public PayAccount inputPayAccountInfo(){
        System.out.println("Nhap ma tai khoan: ");
        String maTk = sc.nextLine();
        System.out.println("Nhap ten chu tai khoan: ");
        String ten = sc.nextLine();
        System.out.println("Nhap ngay tao: ");
        String ngayTao = sc.nextLine();
        System.out.println("Nhap so the: ");
        String soThe = sc.nextLine();
        System.out.println("Nhap so tien trong tai khoan");
        double soTien = Double.parseDouble(sc.nextLine());
        return new PayAccount(maTk,ten,ngayTao,soThe,soTien);
    }
    public void addNewBank(){
        bankList = readAll();
        int number;
        do {
        System.out.println("Nhap loai the muon them moi\n"+
                "1. The tiet kiem\n"+
                "2. The Thanh toan\n"+
                "3. Thoat");

            System.out.println("Nhap lua chon: ");
            number = Integer.parseInt(sc.nextLine());
            switch (number){
                case 1:
                    PayAccount tempPay = inputPayAccountInfo();
                    bankList.add(tempPay);
                    writeCSV(bankList);
                    break;
                case 2:
                    SaveAccount tempSave = inputSaveAccountInfo();
                    bankList.add(tempSave);
                    writeCSV(bankList);
                    break;
            }
        }while (number < 3);

    }
    public void remove(String id){
        bankList = readAll();
        for (int i = 0 ;i < bankList.size();i++){
            if(bankList.get(i).getMaTaiKhoan().equals(id)){
                bankList.remove(i);
                writeCSV(bankList);
            }
        }
    }
    public void display(){
        bankList = readAll();
        for(BankAccount bankAccount:bankList){
            System.out.println(bankAccount.toString());
        }
    }
    public void search(String id){
        bankList = readAll();
        boolean check =false;
        for (int i = 0 ;i < bankList.size();i++){
            if(bankList.get(i).getMaTaiKhoan().equals(id)){
                System.out.println(bankList.get(i).toString());
                check = true;
            }
        }
        if(check == false){
            System.out.println("khong ton tai");
        }
    }
    public void writeCSV(List<BankAccount> list){
        String data = "";
        for(BankAccount bankAccount: list){
            data += bankAccount.getInfo();
        }
        try {
            writeFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(String data) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_BANK_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    public ArrayList<BankAccount> readSaveFile(){
        ArrayList<BankAccount> bankSaveList = new ArrayList<>();
        FileReader fileReader = null;
        try {
             fileReader = new FileReader(FILE_BANK_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        String temp[];
        SaveAccount saveAccount;
        while (true){
            try {
                if (!((line = bufferedReader.readLine())!=null)) break;
            } catch (IOException e){
                e.printStackTrace();
            }

            temp = line.split(",");
            if (temp.length != 7 ){
                break;
            }
            String maTk = temp[0];
            String ten = temp[1];
            String ngayTao = temp[2];
            double tienGui = Double.parseDouble(temp[3]);
            String ngayGui = temp[4];
            double laiSuat = Double.parseDouble(temp[5]);
            int kiHan = Integer.parseInt(temp[6]);
            if(temp.length==7){
                saveAccount = new SaveAccount(maTk,ten,ngayTao,tienGui,ngayGui,laiSuat,kiHan);
                bankSaveList.add(saveAccount);
            }
        }
        return bankSaveList;
    }
    public ArrayList<BankAccount> readPayFile(){
        ArrayList<BankAccount> bankPayList = new ArrayList<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FILE_BANK_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        String temp[];
        PayAccount payAccount;
        while (true){
            try {
                if (!((line = bufferedReader.readLine())!=null)) break;
            } catch (IOException e){
                e.printStackTrace();
            }
            temp = line.split(",");
            if (temp.length !=5){
                break;
            }
            String maTk = temp[0];
            String ten = temp[1];
            String ngayTao = temp[2];
            String soThe = temp[3];
            Double soTienTrongTk =  Double.parseDouble(temp[4]);
            if(temp.length == 5){
                payAccount = new PayAccount(maTk,ten,ngayTao,soThe,soTienTrongTk);
                bankPayList.add(payAccount);
            }
        }
        return bankPayList;
    }
    public ArrayList<BankAccount> readAll(){
        ArrayList<BankAccount> bankSaveList = readSaveFile();
        ArrayList<BankAccount> bankPayList = readPayFile();
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        bankAccounts.addAll(bankSaveList);
        bankAccounts.addAll(bankPayList);
        return bankAccounts;
    }
    public static void main(String[] args) {
        BankServiceImpl a = new BankServiceImpl();
        a.addNewBank();
        //a.display();
    }
}
