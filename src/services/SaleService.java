package services;

import java.util.ArrayList;
import java.util.List;
import models.Product;
import models.Sale;

public class SaleService {

    private List<Sale> salesHistory;
    private ProductService productService;

    public SaleService(ProductService productService) {
        this.salesHistory = new ArrayList<>();
        this.productService = productService;
    }

    // Método para iniciar uma nova venda
    public Sale startNewSale() {
        return new Sale();
    }

    // Método para criar uma nova venda (alternativo, chamando startNewSale)
    public Sale createNewSale() {
        return startNewSale();
    }
    public List<Sale> getAllSales() {
        return new ArrayList<>(salesHistory); // Retorna uma cópia da lista para evitar alterações externas
    }
    // Método para adicionar um produto à venda
    public void addProductToSale(Sale sale, int productId, int quantity) {
        // Busca o produto pelo ID usando o ProductService
        Product product = productService.findProductById(productId);

        // Verifica se o produto foi encontrado e se há estoque suficiente
        if (product != null && product.getStock() >= quantity) {
            double productTotal = product.getPrice() * quantity;  // Calcula o valor total do produto na venda
            sale.addProduct(product, quantity, productTotal);  // Adiciona o produto à venda
            productService.updateStock(productId, product.getStock() - quantity);  // Atualiza o estoque
            System.out.println("Produto adicionado à venda: " + product.getName() + " x " + quantity);
        } else {
            System.out.println("Produto não encontrado ou estoque insuficiente.");
        }
    }

    // Método para calcular o subtotal da venda
    public double calculateSubtotal(Sale sale) {
        return sale.getTotalAmount();  // Retorna o total da venda (total acumulado de todos os produtos)
    }

    // Método para finalizar a venda
    public void finalizeSale(Sale sale) {
        // Adiciona a venda ao histórico de vendas
        salesHistory.add(sale);
        System.out.println("Venda finalizada com total de: R$ " + sale.getTotalAmount());
    }

    // Método para exibir o histórico de vendas
    public void listSalesHistory() {
        System.out.println("Histórico de Vendas:");
        // Itera sobre o histórico de vendas e imprime o total de cada venda
        for (Sale sale : salesHistory) {
            System.out.println("Venda com total de: R$ " + sale.getTotalAmount());
        }
    }
}
