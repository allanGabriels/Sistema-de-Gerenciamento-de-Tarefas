package br.com;

import java.util.List;

public class CalculadoraDeDesconto {

    public CalculadoraDeDesconto() {

    }

    public Resposta calc(List<Item> carrinho) {
        float totalCompra = 0f;

        for (Item i : carrinho) {
            totalCompra += i.getPreco() * i.getQuant();
        }

        int descontoPercent = 0;
        int valorFinal;

        if (totalCompra < 100f) {
            valorFinal = Math.round(totalCompra);
        } else if (totalCompra <= 500f) {
            descontoPercent = 5;
            valorFinal = Math.round(totalCompra - (totalCompra * 0.05f));
        } else {
            descontoPercent = 10;
            valorFinal = Math.round(totalCompra - (totalCompra * 0.10f));
        }

        return new Resposta(descontoPercent, valorFinal);
    }

}
