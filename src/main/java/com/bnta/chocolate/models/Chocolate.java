package com.bnta.chocolate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chocolates")
public class Chocolate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cocoa_percentage")
    private int cocoaPercentage;

    @OneToMany(mappedBy = "chocolate")
    @JsonIgnoreProperties({"chocolate"})
    private List<CocoaOrder> cocoaOrders;

    public Chocolate(String name, int cocoaPercentage) {
        this.name = name;
        this.cocoaPercentage = cocoaPercentage;
        this.cocoaOrders = new ArrayList<>();
    }

    public Chocolate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCocoaPercentage() {
        return cocoaPercentage;
    }

    public void setCocoaPercentage(int cocoaPercentage) {
        this.cocoaPercentage = cocoaPercentage;
    }

    public List<CocoaOrder> getCocoaOrders() {
        return cocoaOrders;
    }

    public void setCocoaOrders(List<CocoaOrder> cocoaOrders) {
        this.cocoaOrders = cocoaOrders;
    }

    public void addCocoaOrder(CocoaOrder cocoaOrder){
        this.cocoaOrders.add(cocoaOrder);
    }

    public void removeCocoaOrder(CocoaOrder cocoaOrder){
        this.cocoaOrders.remove(cocoaOrder);
    }

}
