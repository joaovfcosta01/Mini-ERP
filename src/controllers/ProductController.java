package controllers;

import models.Product;
import models.Sale;
import models.CashRegister;  // Importação da classe CashRegister
import services.ProductService;
import utils.ReportUtils;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private Scanner scanner;
    private ProductService productService = new ProductService();

    // Método para obter todos os produtos
    public List<Product> getAllProducts() {
        return productService.getAllProducts(); // Recupera os produtos do serviço
    }

    // Método para gerar todos os relatórios
    public void generateReports(List<Product> products, CashRegister cashRegister, List<Sale> sales) {
        // Chama o método centralizado da classe ReportUtils para gerar todos os relatórios
        ReportUtils.generateAllReports(products, cashRegister, sales);
    }

    public ProductController(ProductService productService) {
        this.productService = productService;
        this.scanner = new Scanner(System.in);
    }

    public ProductController() {
        // Construtor sem parâmetros, caso necessário
    }

    // Método para criar um novo produto
    public void createProduct() {
        System.out.println("\nCadastrar Novo Produto");

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Código: ");
        int code = scanner.nextInt();

        System.out.print("Preço: ");
        double price = scanner.nextDouble();

        System.out.print("Quantidade em Estoque: ");
        int stock = scanner.nextInt();

        System.out.print("Validade (em dias, ou 0 se não houver): ");
        int expirationDays = scanner.nextInt();
        Integer expirationDate = expirationDays > 0 ? expirationDays : null;

        System.out.print("Garantia (em meses, ou 0 se não houver): ");
        int warrantyMonths = scanner.nextInt();
        Integer warranty = warrantyMonths > 0 ? warrantyMonths : null;

        // Convertendo o código para String
        String codeStr = String.valueOf(code);

        // Chamando o serviço para criar o produto
        Product product = productService.createProduct(name, codeStr, price, stock, expirationDate, warranty);
        if (product != null) {
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Erro: Código do produto já existe.");
        }
    }


    // Método para exibir o menu de gerenciamento de produtos
    public void menu() {
        boolean running = true;

        // Inicializa a lista de produtos para evitar o erro de variável não inicializada
        List<Product> products = getAllProducts(); 

        while (running) {
            System.out.println("\n----- MENU DE GERENCIAMENTO DE PRODUTOS -----");
            System.out.println("1. Cadastrar Novo Produto");
            System.out.println("2. Listar Todos os Produtos");
            System.out.println("3. Gerar Relatórios");
            System.out.println("4. Voltar ao Menu Principal");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consome o "\n" restante após nextInt()

            switch (option) {
                case 1:
                    createProduct();  // Chama o método para cadastrar produto
                    break;
                case 2:
                    products = getAllProducts();  // Obtém todos os produtos
                    System.out.println("Lista de Produtos:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 3:
                    // Gerar relatórios (exemplo, você pode passar o histórico de vendas e o caixa)
                    List<Sale> sales = null;  // Aqui você deve passar as vendas reais
                    CashRegister cashRegister = null;  // Aqui você deve passar o caixa real
                    generateReports(products, cashRegister, sales);
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
