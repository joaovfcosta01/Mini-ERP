package services;

import models.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    // Lista de produtos, que armazenará todos os produtos cadastrados
    private List<Product> productList;

    // Construtor que inicializa a lista de produtos
    public ProductService() {
        this.productList = new ArrayList<>();
    }

    // Método para criar um novo produto e adicionar à lista
    public Product createProduct(String name, String code, double price, int stock, Integer expirationDate, Integer warranty) {
        // Verifica se já existe um produto com o mesmo código
        for (Product product : productList) {
            if (product.getCode().equals(code)) {  // Comparando códigos como String
                return null;  // Se o código já existir, retorna null
            }
        }
        // Cria o produto e adiciona à lista
        Product product = new Product(0, name, code, price, stock, expirationDate, warranty);  // Passando 0 para o ID temporariamente
        productList.add(product);
        return product;
    }

    // Método para buscar um produto pelo código
    public Product findProductById(int productId) {
        for (Product product : productList) {
            if (product.getCode().equals(String.valueOf(productId))) {  // Comparando códigos como String
                return product;
            }
        }
        return null;  // Retorna null se o produto não for encontrado
    }

    // Método para atualizar o estoque de um produto
    public void updateStock(int productId, int newStock) {
        Product product = findProductById(productId);
        if (product != null) {
            product.setStock(newStock);
        }
    }

    // Método para obter todos os produtos
    public List<Product> getAllProducts() {
        return productList;  // Retorna a lista de todos os produtos
    }
}
