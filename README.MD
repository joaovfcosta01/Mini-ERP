# **MarketManagementSystem**

## **Descrição**

O **MarketManagementSystem** é um sistema de gestão de mercado desenvolvido em Java, com funcionalidades para controle de produtos, gerenciamento de caixa e realização de vendas. O sistema é baseado em linha de comando (terminal) e não utiliza banco de dados, armazenando as informações em memória enquanto a aplicação está em execução. Ele permite o gerenciamento de produtos com diferentes características, como alimentos (com validade), utensílios (com validade) e eletrônicos (com garantia).

## **Funcionalidades**

- **Gerenciamento de Produtos**:
  - Cadastro, edição e desativação de produtos.
  - Diferenciação entre tipos de produtos (alimentos, utensílios e eletrônicos).
  - Controle de validade para alimentos e utensílios.
  - Garantia para eletrônicos.

- **Operações de Caixa**:
  - Abertura e fechamento de caixa com valor inicial e final.
  - Geração de relatórios diários de operações.

- **Gestão de Vendas**:
  - Adição e remoção de produtos em uma venda.
  - Exibição do subtotal a cada item adicionado.
  - Remoção de produtos em vendas não finalizadas.

- **Relatórios**:
  - Relatório de produtos próximos da validade.
  - Relatório de produtos com baixa quantidade em estoque.

## **Pré-requisitos**

- **Java 8** ou superior.

## **Estrutura do Projeto**

Abaixo está a estrutura das pastas e arquivos do projeto:

```
/MarketManagementSystem
│
├── src
│   ├── Main.java                         # Ponto de entrada do sistema
│   ├── models                            # Classes que representam objetos principais
│   │   ├── Product.java                  # Classe base para produtos
│   │   ├── Food.java                     # Subclasse de Produto com validade
│   │   ├── Utensil.java                  # Subclasse de Produto com validade
│   │   └── Electronic.java               # Subclasse de Produto com garantia
│   │
│   ├── services                          # Contém a lógica de negócios
│   │   ├── ProductService.java           # Métodos para gerenciar produtos
│   │   ├── CashRegisterService.java      # Métodos para abertura e fechamento de caixa
│   │   └── SaleService.java              # Métodos para gerenciamento de vendas
│   │
│   ├── utils                             # Utilitários e classes auxiliares
│   │   ├── InputUtils.java               # Métodos para entradas de usuário
│   │   └── ReportUtils.java              # Métodos para geração de relatórios
│   │
│   └── controllers                       # Gerenciam a interação entre usuário e serviços
│       ├── CashRegisterController.java   # Controla o caixa
│       ├── ProductController.java        # Controla operações de produtos
│       └── SaleController.java           # Controla operações de vendas
│
├── resources
│   └── texts                             # Textos exibidos no terminal
│       ├── menuTexts.txt                 # Textos dos menus
│       ├── errorTexts.txt                # Mensagens de erro
│       └── reportTexts.txt               # Textos para relatórios
│
└── README.md                             # Documentação do projeto
```

## **Instruções de Uso**

1. **Compilação**:
   - Navegue até a pasta `src` e compile os arquivos Java usando o seguinte comando:
     ```bash
     javac Main.java
     ```

2. **Execução**:
   - Após a compilação, execute o sistema com:
     ```bash
     java Main
     ```

3. **Navegação no Sistema**:
   - Ao iniciar, o sistema exibirá um menu com as opções de gerenciamento de produtos, caixa e vendas. Utilize as opções numéricas para navegar entre as funcionalidades.

## **Exemplo de Uso**

### **Gerenciamento de Produtos**

1. Selecione a opção para cadastrar um novo produto.
2. Escolha o tipo de produto (alimento, utensílio, eletrônico).
3. Insira os detalhes do produto, como nome, preço, quantidade, e atributos específicos (data de validade ou garantia, dependendo do tipo).

### **Abertura e Fechamento de Caixa**

1. No início do dia, selecione a opção para abrir o caixa e insira o valor inicial.
2. No final do dia, feche o caixa, insira o valor final e gere o relatório diário de operações.

### **Realização de Vendas**

1. Selecione a opção de vendas e adicione os produtos à venda.
2. A cada item adicionado, o sistema exibirá o subtotal.
3. Finalize a venda e verifique o resumo da compra.

### **Relatórios**

1. Acesse a opção de relatórios para ver produtos com validade próxima e produtos com baixa quantidade em estoque.
2. Gere relatórios específicos através das opções no menu.

## **Boas Práticas**

- **Separação de Responsabilidades**: Cada classe foi desenvolvida para ter uma única responsabilidade, facilitando manutenção e testes.
- **Modularidade**: Classes de controle (`controllers`), serviços (`services`) e modelos (`models`) estão bem separadas para organizar melhor o fluxo do sistema.
- **Textos Centralizados**: Todos os textos exibidos ao usuário estão no diretório `resources/texts`, permitindo fácil edição.

## **Contribuições**

Contribuições são bem-vindas! Caso queira melhorar o projeto, sinta-se à vontade para criar uma *pull request* ou abrir uma *issue* com sugestões.

## **Autor**

João Victor