public class Messages {
    public static void promptProductName() {
        System.out.print("Digite o nome do produto: ");
    }

    public static void promptProductCode() {
        System.out.print("Digite o código do produto: ");
    }

    public static void promptProductPrice() {
        System.out.print("Digite o preço do produto: ");
    }

    public static void promptProductQuantity() {
        System.out.print("Digite a quantidade do produto: ");
    }

    public static void promptProductExpirationDate() {
        System.out.print("Digite a validade do produto (em dias): ");
    }

    public static void promptProductWarranty() {
        System.out.print("Digite a garantia do produto (em meses): ");
    }

    public static void promptOpenCashRegisterAmount() {
        System.out.print("Digite o valor inicial para abrir o caixa: ");
    }

    public static void promptCloseCashRegisterAmount() {
        System.out.print("Digite o valor final para fechar o caixa: ");
    }

    public static void promptSearchProductByName() {
        System.out.print("Digite o nome do produto para pesquisar: ");
    }

    public static void promptRemoveProductFromSale() {
        System.out.print("Digite o código do produto para remover da venda: ");
    }

    public static void promptAddProductToSale() {
        System.out.print("Digite o código do produto para adicionar à venda: ");
    }

    // Mensagens de confirmação e sucesso
    public static void showProductAddedToSale(String productName) {
        System.out.println("Produto \"" + productName + "\" adicionado à venda com sucesso.");
    }

    public static void showProductRemovedFromSale(String productName) {
        System.out.println("Produto \"" + productName + "\" removido da venda com sucesso.");
    }

    public static void showCashRegisterOpened() {
        System.out.println("Caixa aberto com sucesso.");
    }

    public static void showCashRegisterClosed() {
        System.out.println("Caixa fechado com sucesso.");
    }

    public static void showProductRegistered(String productName) {
        System.out.println("Produto \"" + productName + "\" cadastrado com sucesso.");
    }

    public static void showProductDeactivated(String productName) {
        System.out.println("Produto \"" + productName + "\" desativado com sucesso.");
    }
}








