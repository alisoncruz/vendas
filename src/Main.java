import db.*;
import models.*;
import validators.ValidadorPedidoVenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static ProdutoDB produtoDB = new ProdutoDB();
    static UsuarioDB usuarioDB = new UsuarioDB();
    static EstoquesDB estoquesDB = new EstoquesDB();
    static PedidoVendaDB pedidoVendaDB = new PedidoVendaDB();

    public static void main(String[] args) {


        System.out.println("---- PEDIDO DE VENDAS ----");

        Locale.setDefault(Locale.US);

        int option = 0;
        do {
            System.out.println("\n1 - Cadastrar produto");
            System.out.println("2 - Listar produtos cadastrados");
            System.out.println("3 - Cadastrar usuário ADMINISTRADOR");
            System.out.println("4 - Cadastrar usuário CLIENTE");
            System.out.println("5 - Listar usuários cadastrados");
            System.out.println("6 - Cadastro de estoque de produto");
            System.out.println("7 - Listar Estoques");
            System.out.println("8 - Criar Pedido de Venda");
            System.out.println("9 - Listar Pedidos de Venda");
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
                cadastrarProduto();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                cadastrarUsuario(TipoUsuario.ADMIN);
                break;
            case 4:
                cadastrarUsuario(TipoUsuario.CLIENTE);
                break;
            case 5:
                listarUsuarios();
                break;
            case 6:
                cadastrarEstoque();
                break;
            case 7:
                listarEstoques();
                break;
            case 8:
                cadastrarPedido();
                break;
            case 9:
                listarPedidos();
                break;
            case 0:
                System.out.println("Encerrando...");
                break;
            default:
                System.out.println("Opção inválida.");

        }


    }

    private static void listarPedidos() {

        List<PedidoVenda> listaPedidos = pedidoVendaDB.getPedidoVendas();

        listaPedidos.forEach(pedido -> {
            System.out.println("ID: " + pedido.getId());
            System.out.println("CLIENTE: " + pedido.getCliente());
            System.out.println("PRODUTO: " + pedido.getProduto());
            System.out.println("VALOR TOTAL : " + pedido.getValorTotal());
        });
    }

    private static void cadastrarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o ID do Cliente: ");
        int idCliente = scanner.nextInt();


        Cliente cliente = (Cliente) usuarioDB.getUsuarioPorId(idCliente);
        System.out.println("ID: " + cliente.getId());
        System.out.println("NOME: " + cliente.getNome());
        System.out.println("TIPO: " + cliente.getTipo());

        System.out.println("Informe o ID do Produto: ");
        int idProduto = scanner.nextInt();

        Produto produto = produtoDB.getProdutoByID(idProduto);
        Estoque estoque = estoquesDB.getEstoqueByProduto(produto);

        System.out.println("----ID: " + produto.getId());
        System.out.println("----DESCRIÇÃO: " + produto.getDescricao());
        System.out.println("----DATA DE VALIDADE: " + produto.getDataValidade());
        System.out.println("----PREÇO: " + produto.getPreco());

        System.out.println("Informe a quantidade: ");
        int quantidade = scanner.nextInt();

        PedidoVenda novoPedido = new PedidoVenda(cliente, produto, quantidade, estoque);

        ValidadorPedidoVenda validadorPedidoVenda = new ValidadorPedidoVenda(novoPedido);

        if (validadorPedidoVenda.ehValido()) {
            pedidoVendaDB.addNovoPedido(novoPedido);
            System.out.println("Pedido cadastrado com sucesso");
        } else {
            validadorPedidoVenda.getErros().stream().forEach(erro -> System.out.println(erro));
        }
    }

    public static void cadastrarProduto() {
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
        produto.setId(id);
        produto.setDescricao(descricao);
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

    public static void cadastrarUsuario(TipoUsuario tipoUsuario) {
        Usuario usuario;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        if (tipoUsuario.equals(TipoUsuario.CLIENTE)) {
            usuario = new Cliente(nome);
        } else {
            usuario = new Admin(nome);
        }

        usuarioDB.addUsuario(usuario);

        System.out.println("Usuário adicionado com sucesso");
    }

    private static void listarUsuarios() {
        List<Usuario> usuarios = usuarioDB.getUsuarios();

        for (Usuario usuario : usuarios) {
            System.out.println("----Nome: " + usuario.getNome());
            System.out.println("----Tipo: " + usuario.getTipo());
        }
    }

    private static void cadastrarEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual é o identificador do estoque");
        String id = scanner.next();

        System.out.println("Qual o produto que será adicionado ao estoque(Informe o ID): ");
        int produtoId = scanner.nextInt();

        Produto produto = produtoDB.getProdutoByID(produtoId);

        System.out.println("----PRODUTO ID: " + produto.getId());
        System.out.println("----PRODUTO DESCRIÇÃO: " + produto.getDescricao());
        System.out.println("----PRODUTO VALIDADE: " + produto.getDataValidade());

        System.out.println("Qual é quantidade de produtos a ser adicionada em estoque: ");
        int quantidade = scanner.nextInt();

        Estoque estoque = new Estoque(id, produto, quantidade);
        estoquesDB.addNovoEstoque(estoque);

        System.out.println("Estoque adicionado com sucesso");
    }

    public static void listarEstoques() {
        List<Estoque> estoqueList = estoquesDB.getEstoqueList();
        for (Estoque estoque : estoqueList) {
            System.out.println("---- ID: " + estoque.getId());
            System.out.println("---- PRODUTO: " + estoque.getProduto().getDescricao());
            System.out.println("---- PREÇO: " + estoque.getProduto().getPreco());
            System.out.println("---- QUANTIDADE: " + estoque.getQuantidade());
        }
    }

}
