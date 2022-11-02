package caseStudy.models;

public abstract class Facility {
    private String serviceName;
    private double usableArea;
    private double cost;
    private int maximumMember;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceName, double usableArea, double cost, int maximumMember, String rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.cost = cost;
        this.maximumMember = maximumMember;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaximumMember() {
        return maximumMember;
    }

    public void setMaximumMember(int maximumMember) {
        this.maximumMember = maximumMember;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }
}
