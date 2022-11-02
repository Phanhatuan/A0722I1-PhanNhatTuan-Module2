package caseStudy.models;

public class Room extends Facility{
    private String freeServices;

    public Room() {
    }

    public Room(String serviceName, double usableArea, double cost, int maximumMember, String rentalType, String freeServices) {
        super(serviceName, usableArea, cost, maximumMember, rentalType);
        this.freeServices = freeServices;
    }
}
