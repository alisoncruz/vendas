package db;

import models.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoDB {

    private List<Produto> prosutosList = new ArrayList<>();

    public void addNovoProduto(Produto produto) {
        prosutosList.add(produto);
    }

    public List<Produto> getProdutosList() {
        return prosutosList;
    }
}
