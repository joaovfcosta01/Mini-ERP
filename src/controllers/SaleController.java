package controllers;

import models.Sale;
import services.SaleService;
import java.util.List;
import java.util.Scanner;

public class SaleController {

    private Scanner scanner;
    private SaleService saleService;
    private List<Sale> sales;

    // Construtor que recebe o SaleService
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
        this.scanner = new Scanner(System.in);
        this.sales = saleService.getAllSales(); // Pega todas as vendas ao inicializar
    }

    public SaleController() {
		// TODO Auto-generated constructor stub
	}

	// Método para obter todas as vendas
    public List<Sale> getAllSales() {
        return sales;
    }

    // Método para iniciar uma nova venda
    public void createNewSale() {
        Sale sale = saleService.startNewSale();
        System.out.println("Nova venda iniciada.");
    }

    // Método para adicionar um produto à venda
    public void addProductToSale(Sale sale) {
        System.out.print("Informe o ID do produto: ");
        int productId = scanner.nextInt();
        System.out.print("Informe a quantidade: ");
        int quantity = scanner.nextInt();

        saleService.addProductToSale(sale, productId, quantity);
    }

    // Método para finalizar a venda
    public void finalizeSale(Sale sale) {
        saleService.finalizeSale(sale);
    }

    // Método para exibir o menu de vendas
    public void menu() {
        boolean running = true;
        Sale currentSale = null;

        while (running) {
            System.out.println("\n----- MENU DE VENDAS -----");
            System.out.println("1. Iniciar Nova Venda");
            System.out.println("2. Adicionar Produto à Venda");
            System.out.println("3. Finalizar Venda");
            System.out.println("4. Voltar ao Menu Principal");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    currentSale = saleService.startNewSale();  // Inicia uma nova venda
                    System.out.println("Venda iniciada.");
                    break;
                case 2:
                    if (currentSale == null) {
                        System.out.println("Nenhuma venda iniciada. Inicie uma venda primeiro.");
                    } else {
                        addProductToSale(currentSale);  // Adiciona produto à venda
                    }
                    break;
                case 3:
                    if (currentSale == null) {
                        System.out.println("Nenhuma venda iniciada. Inicie uma venda primeiro.");
                    } else {
                        finalizeSale(currentSale);  // Finaliza a venda
                        currentSale = null;  // Reseta a venda após finalizar
                    }
                    break;
                case 4:
                    running = false;  // Volta ao menu principal
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
