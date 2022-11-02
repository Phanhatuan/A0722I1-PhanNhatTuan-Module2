package caseStudy.models;

public class Contract {
    private int numberContract;
    private String bookingId;
    private double depositMoney;
    private double totalCost;
    private String customerId;

    public Contract() {
    }

    public Contract(int numberContract, String bookingId, double depositMoney, double totalCost, String customerId) {
        this.numberContract = numberContract;
        this.bookingId = bookingId;
        this.depositMoney = depositMoney;
        this.totalCost = totalCost;
        this.customerId = customerId;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(double depositMoney) {
        this.depositMoney = depositMoney;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
