package models;

public class Utensil extends Product {
    private int validityDays;

    // Chamando o construtor de Product com os parâmetros corretos
    public Utensil(int id, String name, String code, double price, int stock, int validityDays) {
        // Chamando o construtor de Product com todos os parâmetros necessários
        super(id, name, code, price, stock, null, null); // Passando null para expirationDate e warrantyMonths, pois não são necessários
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
        System.out.println("Utensil: " + getName() + " | Code: " + getCode() + " | Price: $" + getPrice() + " | Validity: " + validityDays + " days");
    }
}
