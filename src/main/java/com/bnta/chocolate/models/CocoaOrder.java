package com.bnta.chocolate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "cocoa_orders")
public class CocoaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "chocolate_id")
    @JsonIgnoreProperties({"cocoaOrders"})
    private Chocolate chocolate;

    @ManyToOne
    @JoinColumn(name = "estate_id")
    @JsonIgnoreProperties({"cocoaOrders"})
    private Estate estate;

    @Column(name = "batch_number")
    private String batchNumber;

    @Column(name = "price_paid")
    private double pricePaid;

    public CocoaOrder(Chocolate chocolate, Estate estate, String batchNumber, double pricePaid){
        this.chocolate =chocolate;
        this.estate = estate;
        this.batchNumber = batchNumber;
        this.pricePaid = pricePaid;
    }

    public CocoaOrder(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
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
