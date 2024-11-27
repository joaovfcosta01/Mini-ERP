package models;

public class Product {
    private int id;  // Adicionando o campo id
    private String name;
    private String code;
    private double price;
    private int stock;
    private Integer expirationDate;  // null se não houver validade
    private Integer warrantyMonths;  // null se não houver garantia

    // Construtor com id
    public Product(int id, String name, String code, double price, int stock, Integer expirationDate, Integer warrantyMonths) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.stock = stock;
        this.expirationDate = expirationDate;
        this.warrantyMonths = warrantyMonths;
    }

    public Product(String name2, int code2, double price2, int stock2, Integer integer, Object object) {
		// TODO Auto-generated constructor stub
	}

	// Getter para id
    public int getId() {
        return id;
    }

    // Métodos getter e setter
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(Integer warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    // Método para exibir informações básicas do produto
    public void displayInfo() {
        System.out.println("Product: " + name + " | Code: " + code + " | Price: $" + price);
    }
}
