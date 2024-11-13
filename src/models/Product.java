package models;

public abstract class Product {
    protected String name;
    protected String code;
    protected double price;
    protected boolean isActive;

    public Product(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.isActive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public abstract void displayInfo();
}



