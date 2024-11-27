import utils.InputUtils;
import controllers.ProductController;
import controllers.SaleController;
import services.CashRegisterService;
import models.Product;
import models.CashRegister;
import models.Sale;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Inicializa serviços e controllers
        CashRegisterService cashRegisterService = new CashRegisterService();
        ProductController productController = new ProductController();
        SaleController saleController = new SaleController();

        // Variável de controle do sistema
        boolean systemRunning = true;

        // Bem-vindo e inicialização do caixa
        System.out.println("Bem-vindo ao sistema de gestão do mercado!");
        System.out.println("Por favor, inicie o caixa para começar.");

        double initialCash = InputUtils.readDouble("Digite o valor inicial do caixa: ");
        CashRegister cashRegister = cashRegisterService.openCashRegister(initialCash);  // Cria o CashRegister

        // Lista de vendas (supondo que você tenha um método para obter todas as vendas)
        List<Sale> sales = saleController.getAllSales();

        // Loop principal do sistema
        while (systemRunning) {
            System.out.println("\n----- MENU PRINCIPAL -----");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Realizar Venda");
            System.out.println("3. Gerar Relatórios");
            System.out.println("4. Fechar Caixa e Encerrar");

            int option = InputUtils.readInt("Escolha uma opção: ");

            switch (option) {
                case 1: // Gerenciar produtos
                    productController.menu();  // Chama o menu de gerenciamento de produtos
                    break;

                case 2: // Realizar venda
                    saleController.menu();  // Chama o menu de vendas
                    break;

                case 3: // Gerar relatórios
                    List<Product> products = productController.getAllProducts();  // Recupera todos os produtos
                    productController.generateReports(products, cashRegister, sales);  // Passa os três parâmetros necessários
                    break;

                case 4: // Fechar caixa e encerrar
                    // Aqui você deve obter o valor final do caixa antes de fechar
                    double closingAmount = cashRegister.getCurrentCash();  // Supondo que o método getCurrentCash() exista
                    cashRegisterService.closeCashRegister(closingAmount);  // Passa o valor final do caixa
                    System.out.println("Sistema encerrado. Até logo!");
                    systemRunning = false;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
