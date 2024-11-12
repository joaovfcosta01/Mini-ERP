package models;

public class Food extends Product {
    private int validityDays;

    public Food(String name, String code, double price, int validityDays) {
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
        System.out.println("Food: " + name + " | Code: " + code + " | Price: $" + price + " | Validity: " + validityDays + " days");
    }
}
