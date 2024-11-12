public class Messages {

    // Mensagens de erro
    public static void showInvalidOptionError() {
        System.out.println("Erro: Opção inválida. Por favor, selecione uma das opções disponíveis.");
    }

    public static void showInvalidInputError() {
        System.out.println("Erro: Entrada inválida. Por favor, insira um valor correto.");
    }

    public static void showInsufficientStockError(String productName) {
        System.out.println("Erro: Estoque insuficiente para o produto: " + productName);
    }

    public static void showProductNotFoundError(String productName) {
        System.out.println("Erro: Produto \"" + productName + "\" não encontrado.");
    }

    public static void showProductDeactivatedError(String productName) {
        System.out.println("Erro: Produto \"" + productName + "\" está desativado e não pode ser vendido.");
    }

    public static void showCashRegisterClosedError() {
        System.out.println("Erro: O caixa está fechado. Abra o caixa antes de realizar uma venda.");
    }

    public static void showCashRegisterAlreadyOpenError() {
        System.out.println("Erro: O caixa já está aberto.");
    }

    public static void showInsufficientFundsError() {
        System.out.println("Erro: Fundos insuficientes para fechar o caixa com o valor especificado.");
    }
}