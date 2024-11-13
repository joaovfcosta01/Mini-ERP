package models;

import java.time.LocalDateTime;

public class CashRegister {
    private double openingAmount;
    private LocalDateTime openingTime;
    private double closingAmount;
    private LocalDateTime closingTime;

    public CashRegister(double openingAmount, LocalDateTime openingTime) {
        this.openingAmount = openingAmount;
        this.openingTime = openingTime;
    }

    public double getOpeningAmount() {
        return openingAmount;
    }

    public void setOpeningAmount(double openingAmount) {
        this.openingAmount = openingAmount;
    }

    public LocalDateTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalDateTime openingTime) {
        this.openingTime = openingTime;
    }

    public double getClosingAmount() {
        return closingAmount;
    }

    public void setClosingAmount(double closingAmount) {
        this.closingAmount = closingAmount;
    }

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }
}



