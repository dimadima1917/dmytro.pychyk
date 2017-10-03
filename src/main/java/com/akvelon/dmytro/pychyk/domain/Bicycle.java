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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bicycle bicycle = (Bicycle) o;

        if (productId != bicycle.productId) return false;
        if (Double.compare(bicycle.standardCost, standardCost) != 0) return false;
        if (name != null ? !name.equals(bicycle.name) : bicycle.name != null) return false;
        if (productNumber != null ? !productNumber.equals(bicycle.productNumber) : bicycle.productNumber != null)
            return false;
        if (color != null ? !color.equals(bicycle.color) : bicycle.color != null) return false;
        if (size != null ? !size.equals(bicycle.size) : bicycle.size != null) return false;
        return style != null ? style.equals(bicycle.style) : bicycle.style == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (productNumber != null ? productNumber.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(standardCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        return result;
    }
}
