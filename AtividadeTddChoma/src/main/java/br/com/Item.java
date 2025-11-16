package br.com;

public class Item {

    private String nome;
    private Float preco;
    private Integer quant;

    public Item(String nome, Float preco, Integer quant) {

        if(preco<0){
            throw new IllegalArgumentException("O preço do item não pode ser negativo");
        }else{
            this.nome = nome;
            this.preco = preco;
            this.quant = quant;
        }

    }

    public Float getPreco() {
        return preco;
    }

    public Integer getQuant() {
        return quant;
    }
}
