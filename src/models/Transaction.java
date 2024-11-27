package models;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime timestamp; // Data e hora da transação
    private String description;      // Descrição da transação
    private double amount;           // Valor envolvido na transação (positivo ou negativo)

    // Construtor
    public Transaction(String description, double amount) {
        this.timestamp = LocalDateTime.now(); // Registra o momento da transação automaticamente
        this.description = description;
        this.amount = amount;
    }

    // Getters e Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Método para exibir informações da transação
    @Override
    public String toString() {
        return "Transaction{" +
                "timestamp=" + timestamp +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
