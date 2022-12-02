package caseStudy.utils;

import caseStudy.models.Action.Facility;
import caseStudy.models.Action.House;
import caseStudy.models.Action.Room;
import caseStudy.models.Action.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityReadAndWriteFileCSV {
    // File villa path
    private static final String FILE_VILLA_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\villa.csv";
    // File room path
    private static final String FILE_ROOM_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\room.csv";
    // File house path
    private static final String FILE_HOUSE_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\house.csv";
    // Begin write read file section
    public static void writeVillaCSV(LinkedHashMap<Facility, Integer> facilityList)  {
        String data = "";
        for (Map.Entry<Facility,Integer> key : facilityList.entrySet()) {
            String temp = key.getKey().getClass().getSimpleName();
            if(temp.equals("Villa")){
                Villa tempVilla =  (Villa) key.getKey();
                String tempInfoVilla = tempVilla.getInfo() + "," + key.getValue() + "\n";
                data += tempInfoVilla;
            }
        }
        try {
            writeFile(FILE_VILLA_PATH,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeHouseCSV(LinkedHashMap<Facility,Integer> facilityList)  {
        String data = "";
        for (Map.Entry<Facility,Integer> key : facilityList.entrySet()) {
            String temp = key.getKey().getClass().getSimpleName();
            if(temp.equals("House")){
                House tempHouse = (House) key.getKey();
                String tempInfoHouse = tempHouse.getInfo() + "," + key.getValue() + "\n";
                data += tempInfoHouse;
            }
        }
        try {
            writeFile(FILE_HOUSE_PATH,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeRoomCSV(LinkedHashMap<Facility,Integer> facilityList)  {
        String data = "";
        for (Map.Entry<Facility,Integer> key : facilityList.entrySet()) {
            String temp = key.getKey().getClass().getSimpleName();
            if(temp.equals("Room")){
                Room tempRoom = (Room) key.getKey();
                String tempInfoRoom = tempRoom.getInfo() + "," + key.getValue() + "\n";
                data += tempInfoRoom;
            }
        }
        try {
            writeFile(FILE_ROOM_PATH,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(String path, String data) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    public static LinkedHashMap<Facility,Integer> readVillaFile() {
        LinkedHashMap<Facility,Integer> facilityVillaList = new LinkedHashMap<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FILE_VILLA_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        String temp[];
        Villa villa;
        while(true){
            try {
                if (!((line = bufferedReader.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            temp = line.split(",");
            String serviceName = temp[0];
            double usableArea = Double.parseDouble(temp[1]);
            double cost =  Double.parseDouble(temp[2]);
            int maximumMember = Integer.parseInt(temp[3]);
            String rentalType = temp[4];
            String serviceId = temp[5];
            String roomStandard = temp[6];
            double poolArea = Double.parseDouble(temp[7]);
            int floor = Integer.parseInt(temp[8]);
            int numberOfUses = Integer.parseInt(temp[9]);
            villa = new Villa(serviceName,usableArea,cost,maximumMember,rentalType,serviceId,roomStandard,poolArea,floor);
            facilityVillaList.put(villa,numberOfUses);
        }
        return facilityVillaList;
    }
    public static LinkedHashMap<Facility,Integer> readRoomFile() {
        LinkedHashMap<Facility,Integer> facilityRoomList = new LinkedHashMap<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FILE_ROOM_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        String temp[];
        Room room;
        while(true){
            try {
                if (!((line = bufferedReader.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            temp = line.split(",");
            String serviceName = temp[0];
            double usableArea = Double.parseDouble(temp[1]);
            double cost =  Double.parseDouble(temp[2]);
            int maximumMember = Integer.parseInt(temp[3]);
            String rentalType = temp[4];
            String serviceId = temp[5];
            String freeServices = temp[6];
            int numberOfUses = Integer.parseInt(temp[7]);
            room = new Room(serviceName,usableArea,cost,maximumMember,rentalType,serviceId,freeServices);
            facilityRoomList.put(room,numberOfUses);
        }
        return facilityRoomList;
    }
    public static LinkedHashMap<Facility,Integer> readHouseFile() {
        LinkedHashMap<Facility,Integer> facilityHouseList = new LinkedHashMap<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FILE_HOUSE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        String temp[];
        House house;
        while(true){
            try {
                if (!((line = bufferedReader.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            temp = line.split(",");
            String serviceName = temp[0];
            double usableArea = Double.parseDouble(temp[1]);
            double cost =  Double.parseDouble(temp[2]);
            int maximumMember = Integer.parseInt(temp[3]);
            String rentalType = temp[4];
            String serviceId = temp[5];
            String roomStandard = temp[6];
            int floor = Integer.parseInt(temp[7]);
            int numberOfUses = Integer.parseInt(temp[8]);
            house = new House(serviceName,usableArea,cost,maximumMember,rentalType,serviceId,roomStandard,floor);
            facilityHouseList.put(house,numberOfUses);
        }
        return facilityHouseList;
    }

    public static LinkedHashMap<Facility,Integer> readAllFile(){
        LinkedHashMap<Facility,Integer> villaList = readVillaFile();
        LinkedHashMap<Facility,Integer> roomList = readRoomFile();
        LinkedHashMap<Facility,Integer> houseList = readHouseFile();
        LinkedHashMap<Facility,Integer> allList = new LinkedHashMap<>();
        allList.putAll(villaList);
        allList.putAll(roomList);
        allList.putAll(houseList);
        return allList;
    }
    //End write read file section
}
