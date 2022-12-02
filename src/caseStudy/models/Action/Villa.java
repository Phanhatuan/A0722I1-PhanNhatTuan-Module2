package caseStudy.models.Action;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floor;

    public Villa() {

    }

    public Villa(String serviceName, double usableArea, double cost, int maximumMember, String rentalType, String serviceId, String roomStandard, double poolArea, int floor) {
        super(serviceName, usableArea, cost, maximumMember, rentalType, serviceId);
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

    @Override
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",getServiceName(),getUsableArea(),getCost(),getMaximumMember(),getRentalType(),getServiceId(),getRoomStandard(),getPoolArea(),getFloor());
    }
    @Override
    public String toString() {
        return "Villa{" +
                "serviceName= " + getServiceName() +
                ", usableArea= " + getUsableArea() +
                ", cost= " + getCost() +
                ", maximumMember= " + getMaximumMember() +
                ", rentalType= " + getRentalType() +
                ", roomStandard= " + getRoomStandard() +
                ", serviceId= " + getServiceId() +
                ", poolArea= " + getPoolArea() +
                ", floor= " + getFloor() +
                '}';
    }
}
