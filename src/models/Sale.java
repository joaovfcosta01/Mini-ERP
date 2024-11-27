package models;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<Product> products;
    private double totalAmount;

    public Sale() {
        this.products = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.totalAmount += product.getPrice();
    }

    public void removeProduct(Product product) {
        if (this.products.remove(product)) {
            this.totalAmount -= product.getPrice();
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addProduct(Product product, int quantity, double productTotal) {
		// TODO Auto-generated method stub
		
	}
}



