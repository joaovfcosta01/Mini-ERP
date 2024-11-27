package utils;

import models.Product;
import models.Food;
import models.Electronic;
import models.CashRegister;
import models.Sale;
import java.util.List;

public class ReportUtils {

    // Gera um relatório completo do estoque
    public static void generateStockReport(List<Product> products) {
        System.out.println("\n=== Relatório de Estoque ===");
        if (products.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            for (Product product : products) {
                System.out.println("ID: " + product.getId());
                System.out.println("Nome: " + product.getName());
                System.out.println("Código: " + product.getCode());
                System.out.println("Preço: R$ " + product.getPrice());
                System.out.println("Estoque: " + product.getStock());

                // Relatório de validade (para alimentos)
                if (product instanceof Food) {
                    Food food = (Food) product;
                    System.out.println("Validade: " + food.getValidityDays() + " dias restantes");
                } else {
                    System.out.println("Validade: N/A");
                }

                // Relatório de garantia (para eletrônicos)
                if (product instanceof Electronic) {
                    Electronic electronic = (Electronic) product;
                    System.out.println("Garantia: " + electronic.getWarrantyMonths() + " meses");
                } else {
                    System.out.println("Garantia: N/A");
                }

                System.out.println("----------------------------------");
            }
        }
    }

    // Gera um relatório de produtos com validade próxima
    public static void generateExpirationReport(List<Product> products) {
        System.out.println("\n=== Relatório de Validade Próxima ===");
        boolean hasExpiringProducts = false;

        for (Product product : products) {
            if (product instanceof Food) {
                Food food = (Food) product;
                if (food.getValidityDays() <= 7) { // 7 dias como exemplo
                    hasExpiringProducts = true;
                    System.out.println("ID: " + food.getId());
                    System.out.println("Nome: " + food.getName());
                    System.out.println("Validade: " + food.getValidityDays() + " dias restantes");
                    System.out.println("----------------------------------");
                }
            }
        }

        if (!hasExpiringProducts) {
            System.out.println("Nenhum produto próximo do vencimento encontrado.");
        }
    }

    // Gera um relatório de produtos com estoque baixo
    public static void generateLowStockReport(List<Product> products, int threshold) {
        System.out.println("\n=== Relatório de Baixo Estoque ===");
        boolean hasLowStock = false;

        for (Product product : products) {
            if (product.getStock() <= threshold) {
                hasLowStock = true;
                System.out.println("ID: " + product.getId());
                System.out.println("Nome: " + product.getName());
                System.out.println("Estoque: " + product.getStock());
                System.out.println("----------------------------------");
            }
        }

        if (!hasLowStock) {
            System.out.println("Nenhum produto com estoque abaixo de " + threshold + " unidades encontrado.");
        }
    }

    // Gera um relatório diário do caixa e vendas
    public static void generateDailyCashRegisterReport(CashRegister cashRegister, List<Sale> sales) {
        System.out.println("\n=== Relatório do Caixa do Dia ===");
        System.out.println("Valor de Abertura: R$ " + cashRegister.getOpeningAmount());
        System.out.println("Valor Final: R$ " + cashRegister.getClosingAmount());
        System.out.println("Total de Vendas: " + sales.size());

        double totalSalesAmount = sales.stream().mapToDouble(Sale::getTotalAmount).sum();
        System.out.println("Total Vendido: R$ " + totalSalesAmount);
        System.out.println("----------------------------------");

        if (!sales.isEmpty()) {
            System.out.println("Detalhes das Vendas:");
            for (Sale sale : sales) {
                System.out.println("- Venda ID: " + sale.getId() + ", Total: R$ " + sale.getTotalAmount());
            }
            System.out.println("----------------------------------");
        } else {
            System.out.println("Nenhuma venda registrada no dia.");
        }
    }

    // Método centralizado para gerar todos os relatórios
    public static void generateAllReports(List<Product> products, CashRegister cashRegister, List<Sale> sales) {
        generateStockReport(products);  // Relatório de Estoque
        generateExpirationReport(products);  // Relatório de Validade Próxima
        generateLowStockReport(products, 5);  // Relatório de Baixo Estoque (com limite de 5 unidades)
        generateDailyCashRegisterReport(cashRegister, sales);  // Relatório do Caixa do Dia
    }
}
