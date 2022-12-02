package caseStudy.services.InputAndValidData;

import caseStudy.models.Action.Facility;
import caseStudy.models.Action.House;
import caseStudy.models.Action.Room;
import caseStudy.models.Action.Villa;
import caseStudy.utils.FacilityReadAndWriteFileCSV;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityInputAndValidData {
    private static LinkedHashMap<Facility,Integer> facilityList = new LinkedHashMap<>();
    // Begin add new facility
    public static Villa addNewVilla(){
        Scanner sc = new Scanner(System.in);
        //Input Name
        String name;
        do{
            System.out.println("The first letter muse be uppercase ");
            System.out.print("Input villa name: ");
            name = sc.nextLine();
            if(!checkValidName(name)){
                System.out.println(name + " is already exist");
            }
        }while (!FacilityConst.validServiceName.matcher(name).find() || !checkValidName(name));

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
            System.out.println("Input maximum member (>0 && <20): ");
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
        }while(!FacilityConst.validServiceName.matcher(standard).find());


        //Input service id
        String serviceId;
        do {
            System.out.println("Please follow the standard SVVL-xxxx");
            System.out.println("Input service id: ");
            serviceId = sc.nextLine();
            if(!checkValidServiceId(serviceId)){
                System.out.println(serviceId + " is already exist");
            }
        } while(!FacilityConst.validVillaId.matcher(serviceId).find() || !checkValidServiceId(serviceId));

        //Input pool area
        double poolArea;
        do{
            System.out.println("Input poor area (must be greater then 30m^2): ");
            poolArea = Double.parseDouble(sc.nextLine());
        }while (poolArea < 30);

        //Input floor
        int floor;
        do {
            System.out.println("Input floor (must be greater then 0): ");
            floor = Integer.parseInt(sc.nextLine());
        }while (floor <= 0);

        return new Villa(name, area ,cost, quantity, type,serviceId,standard, poolArea, floor);
    }
    public static Room addNewRoom(){
        Scanner sc = new Scanner(System.in);
        String name;
        do{
            System.out.println("The first letter muse be uppercase ");
            System.out.print("Input room name: ");
            name = sc.nextLine();
            if(!checkValidName(name)){
                System.out.println(name + "is already exist");
            }
        }while (!FacilityConst.validServiceName.matcher(name).find()||!checkValidName(name));

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
            System.out.println("Input maximum member (>0 && <20): ");
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
        } while(!FacilityConst.validRoomId.matcher(serviceId).find() || !checkValidServiceId(serviceId));

        System.out.println("Input free service: ");
        String service = sc.nextLine();
        return new Room(name, area ,cost, quantity, type, serviceId, service);
    }
    public static House addNewHouse(){
        Scanner sc = new Scanner(System.in);
        //Input name
        String name;
        do{
            System.out.println("The first letter muse be uppercase ");
            System.out.print("Input houses name: ");
            name = sc.nextLine();
            if(!checkValidName(name)){
                System.out.println(name + "is already exist");
            }
        }while (!FacilityConst.validServiceName.matcher(name).find() || !checkValidName(name));

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
            System.out.println("Input maximum member (>0 && <20): ");
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
        } while(!FacilityConst.validHouseId.matcher(serviceId).find() || !checkValidServiceId(serviceId));

        //Input standard
        String standard;
        do {
            System.out.println("The first letter muse be uppercase ");
            System.out.println("Input room standard: ");
            standard = sc.nextLine();
        }while(!FacilityConst.validServiceName.matcher(standard).find());

        //Input floor
        int floor;
        do {
            System.out.println("Input floor (must be greater then 0): ");
            floor = Integer.parseInt(sc.nextLine());
        }while (floor <= 0);
        return new House(name,area,cost,quantity,type,serviceId,standard,floor);
    }
    // End add new facility

    // Begin valid
    // Check if the name matches or not
    public static boolean checkValidName(String name){
        facilityList = FacilityReadAndWriteFileCSV.readAllFile();
        boolean check = true;
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getKey().getServiceName().equals(name)){
                check = false;
            }
        }
        return check;
    }
    // Check if the service id matches or not
    public static boolean checkValidServiceId(String id){
        facilityList = FacilityReadAndWriteFileCSV.readAllFile();
        boolean check = true;
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getKey().getServiceId().equals(id)){
                check = false;
            }
        }
        return check;
    }
    // Check valid date
    public static boolean checkValidDate(String day){
        DateValidatorImpl validator = new DateValidatorImpl();
        boolean check = validator.isValid(day);
        return check;
    }
    // End valid
}
