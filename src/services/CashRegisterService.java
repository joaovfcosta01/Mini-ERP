package services;

import java.time.LocalDateTime;
import models.CashRegister;

public class CashRegisterService {
    private CashRegister currentCashRegister;

    public CashRegister openCashRegister(double openingAmount) {
        if (currentCashRegister != null && !currentCashRegister.isClosed()) {
            System.out.println("Um caixa já está aberto. Feche-o antes de abrir outro.");
            return currentCashRegister;
        }

        currentCashRegister = new CashRegister(openingAmount, LocalDateTime.now());
        System.out.println("Caixa aberto com R$ " + openingAmount);
        return currentCashRegister;
    }

    public void closeCashRegister(double closingAmount) {
        if (currentCashRegister == null || currentCashRegister.isClosed()) {
            System.out.println("Nenhum caixa aberto para ser fechado.");
            return;
        }

        currentCashRegister.close(closingAmount);
        System.out.println("Caixa fechado com R$ " + closingAmount);
    }

    public CashRegister getCurrentCashRegister() {
        return currentCashRegister;
    }
}
