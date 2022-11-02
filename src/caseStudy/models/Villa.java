package caseStudy.models;

public class Villa extends Facility{
    private String roomStandard;
    private double poolArea;
    private int floor;

    public Villa() {

    }

    public Villa(String serviceName, double usableArea, double cost, int maximumMember, String rentalType, String roomStandard, double poolArea, int floor) {
        super(serviceName, usableArea, cost, maximumMember, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
