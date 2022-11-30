package caseStudy.models.Action;

import caseStudy.models.Action.Facility;

public class House extends Facility {
    private String roomStandard;
    private int floor;

    public House() {

    }

    public House(String serviceName, double usableArea, double cost, int maximumMember, String rentalType, String serviceId, String roomStandard, int floor) {
        super(serviceName, usableArea, cost, maximumMember, rentalType, serviceId);
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
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",getServiceName(),getUsableArea(),getCost(),getMaximumMember(),getRentalType(),getServiceId(),getRoomStandard(),getFloor());
    }
    @Override
    public String toString() {
        return "House{" +
                "serviceName='" + getServiceName() + '\'' +
                ", usableArea=" + getUsableArea() + '\'' +
                ", cost=" + getCost() + '\'' +
                ", maximumMember=" + getMaximumMember() + '\'' +
                ", rentalType='" + getRentalType() + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", floor=" + floor +
                '}';
    }
}
