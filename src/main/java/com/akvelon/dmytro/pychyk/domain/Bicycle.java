package com.akvelon.dmytro.pychyk.domain;


public class Bicycle {

    private int productId;

    private String name;

    private String productNumber;

    private String color;

    private double standardCost;

    private String size;

    private String style;



    //constructor without parameters
    public Bicycle() {
    }

    public Bicycle(int productId, String name, String productNumber, String color, double standardCost, String size, String style) {
        this.productId = productId;
        this.name = name;
        this.productNumber = productNumber;
        this.color = color;
        this.standardCost = standardCost;
        this.size = size;
        this.style = style;
    }

    //getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public double getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(double standardCost) {
        this.standardCost = standardCost;
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

    @Override
    public String toString() {
        return "Bicycle{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", color='" + color + '\'' +
                ", standardCost=" + standardCost +
                ", size='" + size + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
