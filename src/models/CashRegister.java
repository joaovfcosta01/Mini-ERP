package models;

import java.time.LocalDateTime;

public class CashRegister {
    private double openingAmount;
    private LocalDateTime openingTime;
    private double closingAmount;
    private LocalDateTime closingTime;
    private boolean closed; // Indica se o caixa está fechado
    private double totalAmount; // Total acumulado das vendas
    private double currentAmount;

    // Construtor padrão
    public CashRegister() {
        this.totalAmount = 0.0;
        this.closed = false; // Caixa começa aberto
    }

    public CashRegister(double openingAmount2, LocalDateTime now) {
		// TODO Auto-generated constructor stub
	}

	// Getters
    public double getOpeningAmount() {
        return openingAmount;
    }
    public double getCurrentCash() {
        return currentAmount;
    }

    public LocalDateTime getOpeningTime() {
        return openingTime;
    }

    public double getClosingAmount() {
        return closingAmount;
    }

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public boolean isClosed() {
        return closed;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Setters
    public void setOpeningAmount(double openingAmount) {
        this.openingAmount = openingAmount;
    }

    public void setOpeningTime(LocalDateTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setClosingAmount(double closingAmount) {
        this.closingAmount = closingAmount;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }

    // Método para adicionar o total de vendas ao valor total do caixa
    public void addToTotalAmount(double amount) {
        if (amount > 0) {
            totalAmount += amount;
        } else {
            System.out.println("Erro: O valor da venda não pode ser negativo.");
        }
    }

    // Método para fechar o caixa
    public void close(double closingAmount) {
        this.closed = true;
        this.closingAmount = closingAmount;
        this.closingTime = LocalDateTime.now();
    }
}
