package models;

public class Electronic extends Product {
    private Integer warrantyMonths;

    public Electronic(int id, String name, int code, double price, int stock, Integer warrantyMonths) {
        // Chamando o construtor da classe Product e passando null para o expirationDate
        super(name, code, price, stock, null, warrantyMonths); // Null para validade (sem validade)
        this.warrantyMonths = warrantyMonths;
    }

    public Integer getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(Integer warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Electronic: " + getName() +
            " | Code: " + getCode() +
            " | Price: $" + getPrice() +
            " | Stock: " + getStock() +
            " | Warranty: " + (warrantyMonths != null ? warrantyMonths + " months" : "N/A")
        );
    }
}
