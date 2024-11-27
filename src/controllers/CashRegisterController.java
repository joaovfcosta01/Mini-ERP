package controllers;

import models.CashRegister;
import models.Sale;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CashRegisterController {
    private CashRegister cashRegister;
    private final List<Sale> dailySales;

    public CashRegisterController() {
        this.dailySales = new ArrayList<>();
    }

    // Método para abrir o caixa com validação de valor inicial
    public void openCashRegister(double initialAmount) {
        if (cashRegister == null || cashRegister.isClosed()) {
            if (initialAmount < 0) {
                System.out.println("Erro: Valor inicial inválido. O caixa não pode ser aberto com valores negativos.");
                return;
            }

            cashRegister = new CashRegister();
            cashRegister.setOpeningAmount(initialAmount);
            cashRegister.setOpeningTime(LocalDateTime.now());
            cashRegister.setClosed(false);

            System.out.println("Caixa aberto com sucesso! Valor inicial: R$ " + initialAmount);
        } else {
            System.out.println("Erro: O caixa já está aberto. Feche-o antes de abrir outro.");
        }
    }

    // Método para registrar uma venda
    public void addSale(Sale sale) {
        if (!isCashRegisterOperational("registrar vendas")) {
            return;
        }

        if (sale.getTotalAmount() <= 0) {
            System.out.println("Erro: Venda inválida. O valor deve ser maior que zero.");
            return;
        }

        dailySales.add(sale);
        cashRegister.addToTotalAmount(sale.getTotalAmount());
        System.out.println("Venda registrada: R$ " + sale.getTotalAmount());
    }

    // Método para fechar o caixa
    public void closeCashRegister(double finalAmount) {
        if (!isCashRegisterOperational("fechar o caixa")) {
            return;
        }

        if (finalAmount < cashRegister.getOpeningAmount()) {
            System.out.println("Erro: Valor de fechamento menor que o valor de abertura. Verifique os valores.");
            return;
        }

        cashRegister.setClosingAmount(finalAmount);
        cashRegister.setClosingTime(LocalDateTime.now());
        cashRegister.setClosed(true);

        System.out.println("Caixa fechado com sucesso.");
        generateDailyReport();
    }

    // Método privado para verificar se o caixa está operacional
    private boolean isCashRegisterOperational(String operation) {
        if (cashRegister == null || cashRegister.isClosed()) {
            System.out.println("Erro: Não é possível " + operation + ". O caixa está fechado ou não foi aberto.");
            return false;
        }
        return true;
    }

    // Método para gerar um relatório diário
    private void generateDailyReport() {
        System.out.println("\n========== Relatório do Dia ==========");
        System.out.println("Hora de abertura: " + cashRegister.getOpeningTime());
        System.out.println("Valor de abertura: R$ " + cashRegister.getOpeningAmount());
        System.out.println("Vendas realizadas:");

        double totalSales = 0.0;
        for (Sale sale : dailySales) {
            System.out.println("- Venda de R$ " + sale.getTotalAmount() + " registrada.");
            totalSales += sale.getTotalAmount();
        }

        System.out.println("Total de vendas: R$ " + totalSales);
        System.out.println("Hora de fechamento: " + cashRegister.getClosingTime());
        System.out.println("Valor de fechamento: R$ " + cashRegister.getClosingAmount());
        System.out.println("======================================\n");
    }

    // Método para verificar se o caixa está aberto
    public boolean isCashRegisterOpen() {
        return cashRegister != null && !cashRegister.isClosed();
    }

    // Método para obter o total de vendas do dia
    public double getTotalSales() {
        return dailySales.stream().mapToDouble(Sale::getTotalAmount).sum();
    }

    // Método para limpar as vendas diárias (para futuros reusos)
    public void resetDailySales() {
        dailySales.clear();
        System.out.println("As vendas do dia foram resetadas.");
    }
}
