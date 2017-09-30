package com.akvelon.dmytro.pychyk.domain;


public class Bicycle {

    private int productId;

    private String name;

    private String productNumber;

    private String color;

    private double standartCost;

    private String size;

    private String style;


    public Bicycle(int productId, String name, String productNumber, String color, double standartCost, String size, String style) {
        this.productId = productId;
        this.name = name;
        this.productNumber = productNumber;
        this.color = color;
        this.standartCost = standartCost;
        this.size = size;
        this.style = style;
    }

    //constructor without parameters
    public Bicycle() {
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

    @Override
    public String toString() {
        return "Bicycle{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", color='" + color + '\'' +
                ", standartCost=" + standartCost +
                ", size='" + size + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
