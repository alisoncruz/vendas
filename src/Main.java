import models.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual é a descrição você deseja dar ao novo produto: ");
        String descricao = scanner.nextLine();

        System.out.println("Qual ID você deseja dar ao novo produto: ");
        int id = scanner.nextInt();

        Produto produto = new Produto();git 
        produto.setId(1);
        produto.setDescricao("Celular");

        System.out.println("Produto criado com sucesso");
        System.out.println("----ID: "+ produto.getId());
        System.out.println("----DESCRIÇÃO: "+ produto.getDescricao());


    }
}
