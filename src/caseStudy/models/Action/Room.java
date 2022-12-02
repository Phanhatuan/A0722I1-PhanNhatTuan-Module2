package caseStudy.models.Action;

import caseStudy.models.Action.Facility;

public class Room extends Facility {
    private String freeServices;

    public Room() {
    }

    public Room(String serviceName, double usableArea, double cost, int maximumMember, String rentalType, String serviceId,String freeServices) {
        super(serviceName, usableArea, cost, maximumMember, rentalType, serviceId);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }
    @Override
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s,%s",getServiceName(),getUsableArea(),getCost(),getMaximumMember(),getRentalType(),getServiceId(),getFreeServices());
    }
    @Override
    public String toString() {
        return "Room{" +
                "serviceName= " + getServiceName() +
                ", usableArea= " + getUsableArea() +
                ", cost= " + getCost() +
                ", maximumMember= " + getMaximumMember() +
                ", rentalType= " + getRentalType() +
                ", serviceId= " + getServiceId() +
                ", freeServices= " + getServiceName() +
                '}';
    }
}
