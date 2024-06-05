package com.bnta.chocolate.models;

public class CocoaOrderDTO {

    private long chocolateId;
    private long estateId;
    private String batchNumber;
    private double pricePaid;

    public CocoaOrderDTO(long chocolateId, long estateId, String batchNumber, double pricePaid) {
        this.chocolateId = chocolateId;
        this.estateId = estateId;
        this.batchNumber = batchNumber;
        this.pricePaid = pricePaid;
    }

    public CocoaOrderDTO() {
    }

    public long getChocolateId() {
        return chocolateId;
    }

    public void setChocolateId(long chocolateId) {
        this.chocolateId = chocolateId;
    }

    public long getEstateId() {
        return estateId;
    }

    public void setEstateId(long estateId) {
        this.estateId = estateId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }
}
