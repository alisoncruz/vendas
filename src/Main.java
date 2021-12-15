import db.ProdutoDB;
import models.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static ProdutoDB produtoDB = new ProdutoDB();

    public static void main(String[] args) {


        System.out.println("---- PEDIDO DE VENDAS ----");

        Locale.setDefault(Locale.US);

        int option;
        do {
            System.out.println("\n1 - Cadastrar produto");
            System.out.println("2 - Listar produtos cadastrados");
            System.out.println("0 - Sair");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Escolha uma opção: ");
            option = scanner.nextInt();
            processOption(option);

        } while (option != 0);


    }

    public static void processOption(int option) {

        switch (option) {
            case 1:
                cadastrar();
                break;
            case 2:
                listarProdutos();
                break;
            case 0:
                System.out.println("Encerrando...");
                break;
            default:
                System.out.println("Opção inválida.");

        }


    }

    public static void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual é a descrição que você deseja dar ao novo produto: ");
        String descricao = scanner.nextLine();

        System.out.println("Qual é preço do novo produto: ");
        Double preco = scanner.nextDouble();

        System.out.println("Qual a data de validade do novo produto: ");
        String dataString = scanner.next();
        LocalDate dataValidade = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Qual ID você deseja dar ao novo produto: ");
        int id = scanner.nextInt();

        Produto produto = new Produto();
        produto.setId(1);
        produto.setDescricao("Celular");
        produto.setDataValidade(dataValidade);
        produto.setPreco(preco);

        produtoDB.addNovoProduto(produto);
        System.out.println("Produto criado com sucesso");
        
    }

    public static void listarProdutos() {

        List<Produto> produtos = produtoDB.getProdutosList();

        for (Produto produto : produtos) {

            System.out.println("----ID: " + produto.getId());
            System.out.println("----DESCRIÇÃO: " + produto.getDescricao());
            System.out.println("----DATA DE VALIDADE: " + produto.getDataValidade());
            System.out.println("----PREÇO: " + produto.getPreco());
        }
    }
}
