package caseStudy.services;

import caseStudy.models.Facility;
import caseStudy.models.House;
import caseStudy.models.Room;
import caseStudy.models.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    Scanner sc = new Scanner(System.in);
    private static LinkedHashMap<Facility,Integer> facilityList = new LinkedHashMap<>();

    static {
        facilityList.put(new Villa("Villa", 1000,1000, 4, "Diamond", "Vip",1000,10),0);
        facilityList.put(new House("House", 1000,1000, 4, "Diamond", "Vip",10),0);
        facilityList.put(new Room("Room", 1000,1000, 4, "Diamond","Nothing"),0);

    }
    @Override
    public void display() {
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            System.out.printf("%s - %s",item.getKey(),item.getValue());
            System.out.println();
        }
    }

    public boolean checkValidName(String name){
        boolean check = true;
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getKey().getServiceName().equals(name)){
                check = false;
            }
        }
        return check;
    }

    public Villa addNewVilla(){
        String name;
        do{
            System.out.print("Input villa name: ");
            name = sc.nextLine();
        }while (!checkValidName(name));

        System.out.println("Input usable area: ");
        double area = Double.parseDouble(sc.nextLine());
        System.out.println("Input cost: ");
        double cost = Double.parseDouble(sc.nextLine());
        System.out.println("Input maximum member: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Input rental type: ");
        String type = sc.nextLine();
        System.out.println("Input room standard: ");
        String standard = sc.nextLine();
        System.out.println("Input poor area: ");
        double poolArea = Double.parseDouble(sc.nextLine());
        System.out.println("Input floor: ");
        int floor = Integer.parseInt(sc.nextLine());
        return new Villa(name, area ,cost, quantity, type, standard, poolArea, floor);
    }

    public Room addNewRoom(){
        String name;
        do{
            System.out.print("Input room name: ");
            name = sc.nextLine();
        }while (!checkValidName(name));

        System.out.println("Input usable area: ");
        double area = Double.parseDouble(sc.nextLine());
        System.out.println("Input cost: ");
        double cost = Double.parseDouble(sc.nextLine());
        System.out.println("Input maximum member: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Input rental type: ");
        String type = sc.nextLine();
        System.out.println("Input free service: ");
        String service = sc.nextLine();
        return new Room(name, area ,cost, quantity, type, service);
    }

    public House addNewHouse(){
        String name;
        do{
            System.out.print("Input room name: ");
            name = sc.nextLine();
        }while (!checkValidName(name));

        System.out.println("Input usable area: ");
        double area = Double.parseDouble(sc.nextLine());
        System.out.println("Input cost: ");
        double cost = Double.parseDouble(sc.nextLine());
        System.out.println("Input maximum member: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Input rental type: ");
        String type = sc.nextLine();
        System.out.println("Input room standard: ");
        String standard = sc.nextLine();
        System.out.println("Input floor: ");
        int floor = Integer.parseInt(sc.nextLine());
        return new House(name,area,cost,quantity,type,standard,floor);
    }
    @Override
    public void add() {
        int choice;
        do {
            System.out.println("1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to menu");
            System.out.println("input number:");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Villa tempVilla = addNewVilla();
                    facilityList.put(tempVilla,0);
                    break;
                case 2:
                    House tempHouse = addNewHouse();
                    facilityList.put(tempHouse,0);
                    break;
                case 3:
                    Room tempRoom = addNewRoom();
                    facilityList.put(tempRoom,0);
                    break;
                case 4:break;
            }
        } while (choice < 4);
    }

    public void booking(){
        System.out.println("Input name of service: ");
        String name = sc.nextLine();
            for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
                if(item.getKey().getServiceName().equals(name)){
                    int index = item.getValue();
                    index++;
                    //facilityList.replace(item,index);
                }
        }
    }
    public static void main(String[] args) {
        FacilityServiceImpl a= new FacilityServiceImpl();
        a.display();
        a.add();
        a.display();
    }
}
