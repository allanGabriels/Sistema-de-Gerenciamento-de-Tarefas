import org.example.checkout.*;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CheckoutServiceTest {
    @Test
    public void deveCalcularBasicoSemDescontosEImpostoApenasNaoBook() {
        var couponSvc = new CouponService();
        var shipSvc = new ShippingService();
        var service = new CheckoutService(couponSvc, shipSvc);

        var itens = List.of(
                new Item("BOOK", 100.00, 1),
                new Item("ELETRONICO", 50.00, 2) // tributável
        );

        var res = service.checkout(
                itens,
                CustomerTier.BASIC,
                false,
                "SUL",
                3.0,
                null,
                LocalDate.now(),
                null
        );

        assertEquals(200.00, res.subtotal);          // 100 + (50*2)
        assertEquals(0.00, res.discountValue);
        // imposto 12% sobre parte tributável: 100 (eletrônicos)
        assertEquals(12.00, res.tax);
        // frete SUL com peso 3 → 35
        assertEquals(35.00, res.shipping);
        assertEquals(247.00, res.total);
    }

    @Test
    public void deveCalcularGoldComDescontoDe10ESemImposto(){
        var couponSvc = new CouponService();
        var shipSvc = new ShippingService();
        var service = new CheckoutService(couponSvc, shipSvc);

        var itens = List.of(
                new Item("MAKE", 100.0, 1)
        );

        var res = service.checkout(
                itens,
                CustomerTier.GOLD,
                true,
                "NORDESTE",
                5.0,
                "DESC10",
                LocalDate.now(),
                null
        );

        assertEquals(100.0, res.subtotal);
        assertEquals(25.0, res.discountValue);
        assertEquals(9.0, res.tax);
        assertEquals(40.0, res.shipping);
        assertEquals(124.0, res.total);
    }

    @Test
    public void deveCalcularSilverComDescontoDe20EComImposto(){
        var couponSvc = new CouponService();
        var shipSvc = new ShippingService();
        var service = new CheckoutService(couponSvc, shipSvc);

        var itens = List.of(
                new Item("Paçoca", 1.30, 30)
        );

        var res = service.checkout(
                itens,
                CustomerTier.SILVER,
                true,
                "NORTE",
                2.0,
                "DESC20",
                LocalDate.now(),
                LocalDate.of(2026, 05, 19)
        );

        assertEquals(39.0, res.subtotal);
        assertEquals(1.95, res.discountValue);
        assertEquals(4.45, res.tax);
        assertEquals(30.0, res.shipping);
        assertEquals(71.5, res.total);
    }

}
