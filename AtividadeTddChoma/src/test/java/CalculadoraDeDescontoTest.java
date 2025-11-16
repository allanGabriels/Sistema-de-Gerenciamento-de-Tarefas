import br.com.CalculadoraDeDesconto;
import br.com.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraDeDescontoTest {

    @Test
    public void deveEvitarDescontoEmComprasAbaixoDe100() {

        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();

        var carrinho = List.of(
                new Item("Action Figure Choma", 30.f, 1),
                new Item("Action Figure Choma - Pedreiro Version", 50.f, 1));

        var res = calculadora.calc(carrinho);

        assertEquals(0, res.desconto);
        assertEquals(80, res.valorfinal);
    }

    @Test
    public void deveAplicarDescontoDe5AoComprarEntre100E500() {
        CalculadoraDeDesconto Calculadora = new CalculadoraDeDesconto();

        var carrinho = List.of(
                new Item("Aoooow", 50.f, 4),
                new Item("Billie Eilish", 8.f, 10));

        var res = Calculadora.calc(carrinho);

        assertEquals(5, res.desconto);
        assertEquals(266, res.valorfinal);
    }

    @Test
    public void deveAplicarDescontoDe10AoComprarAcimaDe500() {
        CalculadoraDeDesconto Calculadora = new CalculadoraDeDesconto();

        var carrinho = List.of(
                new Item("Ps4", 2700f, 1));

        var res = Calculadora.calc(carrinho);

        assertEquals(10, res.desconto);
        assertEquals(2430, res.valorfinal);
    }

    @Test
    public void deveRetornarIllegalArgumentExceptionQuandoPrecoDoProdutoForMenorQue0() {

        assertThrows(IllegalArgumentException.class, () -> new
                Item("Objective C", -1500.f, 1));

    }
}
