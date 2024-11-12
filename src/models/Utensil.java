package models;

public class Utensil extends Product {
    private int validityDays;

    public Utensil(String name, String code, double price, int validityDays) {
        super(name, code, price);
        this.validityDays = validityDays;
    }

    public int getValidityDays() {
        return validityDays;
    }

    public void setValidityDays(int validityDays) {
        this.validityDays = validityDays;
    }

    @Override
    public void displayInfo() {
        System.out.println("Utensil: " + name + " | Code: " + code + " | Price: $" + price + " | Validity: " + validityDays + " days");
    }
}
