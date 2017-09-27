package com.akvelon.dmytro.pychyk.domain;


public class Bicycle {

    private int id;

    private String name;

    private String productNumber;

    private String color;

    private double standartCost;

    private String size;

    private String style;

    //constructor without parameters
    public Bicycle() {
    }

    //constructor with parameters
    public Bicycle(String name, String productNumber, String color, double standartCost, String size, String style) {
        this.name = name;
        this.productNumber = productNumber;
        this.color = color;
        this.standartCost = standartCost;
        this.size = size;
        this.style = style;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getStandartCost() {
        return standartCost;
    }

    public void setStandartCost(double standartCost) {
        this.standartCost = standartCost;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}