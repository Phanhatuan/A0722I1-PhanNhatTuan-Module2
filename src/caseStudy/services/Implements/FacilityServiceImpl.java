package caseStudy.services.Implements;

import caseStudy.models.Action.Facility;
import caseStudy.models.Action.House;
import caseStudy.models.Action.Room;
import caseStudy.models.Action.Villa;
import caseStudy.services.Const.FacilityConst;
import caseStudy.services.Interfaces.FacilityService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService, FacilityConst {
    Scanner sc = new Scanner(System.in);
    // File villa path
    private static final String FILE_VILLA_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\villa.csv";
    // File room path
    private static final String FILE_ROOM_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\room.csv";
    // File house path
    private static final String FILE_HOUSE_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\house.csv";
    private static LinkedHashMap<Facility,Integer> facilityList = new LinkedHashMap<>();
    static {
        facilityList.put(new Villa("Villa", 1000,1000, 4,"Diamond","SVVL-1000", "Vip",1000,10),0);
        facilityList.put(new House("House", 1000,1000, 4,"Diamond", "SVHO-1000", "Vip",10),0);
        facilityList.put(new Room("Room", 1000,1000, 4,"Diamond", "SVRO-1000", "None"),0);
    }
    // Begin write read file section
    public void writeVillaCSV()  {
        String data = "";
        for (Facility key : facilityList.keySet()) {
            String temp = key.getClass().getSimpleName();
            if(temp.equals("Villa")){
                Villa tempVilla = (Villa) key;
                data += tempVilla.getInfo();
            }
        }
        try {
            writeFile(FILE_VILLA_PATH,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHouseCSV()  {
        String data = "";
        for (Facility key : facilityList.keySet()) {
            String temp = key.getClass().getSimpleName();
            if(temp.equals("House")){
                House tempVilla = (House) key;
                data += tempVilla.getInfo();
            }
        }
        try {
            writeFile(FILE_HOUSE_PATH,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeRoomCSV()  {
        String data = "";
        for (Facility key : facilityList.keySet()) {
            String temp = key.getClass().getSimpleName();
            if(temp.equals("Room")){
                Room tempVilla = (Room) key;
                data += tempVilla.getInfo();
            }
        }
        try {
            writeFile(FILE_ROOM_PATH,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(String path,String data) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    // Begin Add new facility
    @Override
    //Display the collection
    public void display() {
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            System.out.printf("%s - %s",item.getKey(),item.getValue());
            System.out.println();
        }
    }

    //Check if the name matches or not
    public boolean checkValidName(String name){
        boolean check = true;
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getKey().getServiceName().equals(name)){
                check = false;
            }
        }
        return check;
    }

    //Check if the service id matches or not
    public boolean checkValidServiceId(String id){
        boolean check = true;
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getKey().getServiceId().equals(id)){
                check = false;
            }
        }
        return check;
    }

    //Check valid date
    public boolean checkValidDate(String day){
        DateValidatorImpl validator = new DateValidatorImpl();
        boolean check = validator.isValid(day);
        return check;
    }

    //Return a villa object
    public Villa addNewVilla(){
        //Input Name
        String name;
        do{
            System.out.println("The first letter muse be uppercase ");
            System.out.print("Input villa name: ");
            name = sc.nextLine();
            if(!checkValidName(name)){
                System.out.println(name + " is already exist");
            }
        }while (!validServiceName.matcher(name).find() || !checkValidName(name));

        //Input area
        double area;
        do{
            System.out.println("Input usable area ( must be greater then 30m^2): ");
            area = Double.parseDouble(sc.nextLine());
        }while (area < 30);

        //Input cost
        double cost;
        do {
            System.out.println("Input cost: ");
            cost = Double.parseDouble(sc.nextLine());
        } while (cost <= 0);

        //Input member
        int quantity;
        do {
            System.out.println("Input maximum member: ");
            quantity = Integer.parseInt(sc.nextLine());
        }while (quantity<=0 || quantity >=20);

        //Input type of rent
        String type;
        do {
            System.out.println("Input rental type (\"dd/MM/yyyy\"): ");
            type = sc.nextLine();
        }while (!checkValidDate(type));

        //Input standard
        String standard;
        do {
            System.out.println("The first letter muse be uppercase ");
            System.out.println("Input room standard: ");
            standard = sc.nextLine();
        }while(!validServiceName.matcher(standard).find());


        //Input service id
        String serviceId;
        do {
            System.out.println("Please follow the standard SVVL-xxxx");
            System.out.println("Input service id: ");
            serviceId = sc.nextLine();
            if(!checkValidServiceId(serviceId)){
                System.out.println(serviceId + " is already exist");
            }
        } while(!validVillaId.matcher(serviceId).find() || !checkValidServiceId(serviceId));

        //Input pool area
        double poolArea;
        do{
            System.out.println("Input poor area: ");
            poolArea = Double.parseDouble(sc.nextLine());
        }while (poolArea < 30);

        //Input floor
        int floor;
        do {
            System.out.println("Input floor: ");
            floor = Integer.parseInt(sc.nextLine());
        }while (floor <= 0);

        return new Villa(name, area ,cost, quantity, type,serviceId,standard, poolArea, floor);
    }

    public Room addNewRoom(){
        String name;
        do{
            System.out.println("The first letter muse be uppercase ");
            System.out.print("Input room name: ");
            name = sc.nextLine();
            if(!checkValidName(name)){
                System.out.println(name + "is already exist");
            }
        }while (!validServiceName.matcher(name).find()||!checkValidName(name));

        double area;
        do{
            System.out.println("Input usable area ( must be greater then 30m^2): ");
            area = Double.parseDouble(sc.nextLine());
        }while (area < 30);

        double cost;
        do {
            System.out.println("Input cost: ");
            cost = Double.parseDouble(sc.nextLine());
        } while (cost <= 0);

        //Input member
        int quantity;
        do {
            System.out.println("Input maximum member: ");
            quantity = Integer.parseInt(sc.nextLine());
        }while (quantity<=0 || quantity >=20);

        //Input type of rent
        String type;
        do {
            System.out.println("Input rental type (\"dd/MM/yyyy\"): ");
            type = sc.nextLine();
        }while (!checkValidDate(type));

        //Input service id
        String serviceId;
        do {
            System.out.println("Please follow the standard SVRO-xxxx");
            System.out.println("Input service id: ");
            serviceId = sc.nextLine();
            if(!checkValidServiceId(serviceId)){
                System.out.println(serviceId + " is already exist");
            }
        } while(!validRoomId.matcher(serviceId).find() || !checkValidServiceId(serviceId));

        System.out.println("Input free service: ");
        String service = sc.nextLine();
        return new Room(name, area ,cost, quantity, type, serviceId, service);
    }

    public House addNewHouse(){
        //Input name
        String name;
        do{
            System.out.println("The first letter muse be uppercase ");
            System.out.print("Input houses name: ");
            name = sc.nextLine();
            if(!checkValidName(name)){
                System.out.println(name + "is already exist");
            }
        }while (!validServiceName.matcher(name).find() || !checkValidName(name));

        //Input area
        double area;
        do{
            System.out.println("Input usable area ( must be greater then 30m^2): ");
            area = Double.parseDouble(sc.nextLine());
        }while (area < 30);

        //Input cost
        double cost;
        do {
            System.out.println("Input cost: ");
            cost = Double.parseDouble(sc.nextLine());
        } while (cost <= 0);

        //Input member
        int quantity;
        do {
            System.out.println("Input maximum member: ");
            quantity = Integer.parseInt(sc.nextLine());
        }while (quantity<=0 || quantity >=20);

        //Input type of rent
        String type;
        do {
            System.out.println("Input rental type (\"dd/MM/yyyy\"): ");
            type = sc.nextLine();
        }while (!checkValidDate(type));

        //Input service Id
        String serviceId;
        do {
            System.out.println("Please follow the standard SVHO-xxxx");
            System.out.println("Input service id: ");
            serviceId = sc.nextLine();
            if(!checkValidServiceId(serviceId)){
                System.out.println(serviceId + " is already exist");
            }
        } while(!validHouseId.matcher(serviceId).find() || !checkValidServiceId(serviceId));

        //Input standard
        String standard;
        do {
            System.out.println("The first letter muse be uppercase ");
            System.out.println("Input room standard: ");
            standard = sc.nextLine();
        }while(!validServiceName.matcher(standard).find());

        //Input floor
        int floor;
        do {
            System.out.println("Input floor: ");
            floor = Integer.parseInt(sc.nextLine());
        }while (floor <= 0);
        return new House(name,area,cost,quantity,type,serviceId,standard,floor);
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

    @Override
    public void displayFacilityNeedRepair() {
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getValue() >= 5){
                System.out.printf("%s - %s",item.getKey(),item.getValue());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        FacilityServiceImpl a = new FacilityServiceImpl();
        a.writeRoomCSV();
        a.writeRoomCSV();
    }
}
