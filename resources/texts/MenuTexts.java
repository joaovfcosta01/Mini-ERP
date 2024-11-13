public class Menu {

    public static void showMainMenu() {
        System.out.println("=== Sistema de Gestão de Mercado ===");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - PDV (Ponto de Venda)");
        System.out.println("2 - Gerenciar Produtos");
        System.out.println("3 - Relatórios");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
    }

    public static void showPDVMenu() {
        System.out.println("=== PDV ===");
        System.out.println("1 - Realizar Venda");
        System.out.println("2 - Fechar Caixa");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");
    }

    public static void showProductManagementMenu() {
        System.out.println("=== Gerenciamento de Produtos ===");
        System.out.println("1 - Cadastrar Novo Produto");
        System.out.println("2 - Alterar Produto");
        System.out.println("3 - Entrada de Produtos");
        System.out.println("4 - Desativar Produto");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");
    }

    public static void showReportsMenu() {
        System.out.println("=== Relatórios ===");
        System.out.println("1 - Produtos a Vencer");
        System.out.println("2 - Produtos com Baixa Quantidade");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");
    }
}




