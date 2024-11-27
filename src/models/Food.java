package models;

public class Food extends Product {
    private int validityDays;  // Variável para armazenar os dias de validade

    // Construtor da classe Food
    public Food(int id, String name, String code, double price, int stock, Integer expirationDate, Integer warrantyMonths, int validityDays) {
        super(id, name, code, price, stock, expirationDate, warrantyMonths);  // Chama o construtor da classe pai (Product)
        this.validityDays = validityDays;  // Atribui o valor de validade
    }

    // Getter para validityDays
    public int getValidityDays() {
        return validityDays;
    }

    // Setter para validityDays
    public void setValidityDays(int validityDays) {
        this.validityDays = validityDays;
    }

    @Override
    public void displayInfo() {
        // Exibe as informações específicas para Food
        System.out.println("Food: " + getName() + " | Code: " + getCode() + " | Price: $" + getPrice() + " | Validity: " + validityDays + " days");
    }
}
