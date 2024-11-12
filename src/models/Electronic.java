package models;

public class Electronic extends Product {
    private int warrantyMonths;

    public Electronic(String name, String code, double price, int warrantyMonths) {
        super(name, code, price);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronic: " + name + " | Code: " + code + " | Price: $" + price + " | Warranty: " + warrantyMonths + " months");
    }
}
