package caseStudy.models;

public class House extends Facility{
    private String roomStandard;
    private int floor;

    public House() {

    }

    public House(String serviceName, double usableArea, double cost, int maximumMember, String rentalType, String roomStandard, int floor) {
        super(serviceName, usableArea, cost, maximumMember, rentalType);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }



    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
