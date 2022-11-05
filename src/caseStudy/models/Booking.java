package caseStudy.models;

import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private LocalDate beginDay;
    private LocalDate  endDay;
    private int customerId;
    private String serviceName;
    private String typeService;

    public Booking() {
    }

    public Booking(int bookingId, LocalDate  beginDay, LocalDate  endDay, int customerId, String serviceName, String typeService) {
        this.bookingId = bookingId;
        this.beginDay = beginDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.serviceName = serviceName;
        this.typeService = typeService;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate  getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(LocalDate  beginDay) {
        this.beginDay = beginDay;
    }

    public LocalDate  getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate  endDay) {
        this.endDay = endDay;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }
}
