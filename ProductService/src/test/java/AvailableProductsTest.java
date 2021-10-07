import digitalleagie.purchaseService.domain.AvailableProducts;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AvailableProductsTest {

    @Test
    public void showAvailableProducts(){
        String message="Доступные товары:\nПродукт Роза, цена 150\nПродукт Пион, цена 100\nПродукт Гербера, цена 200\nПродукт Хризантема, цена 80\nПродукт Лилия, цена 120";
        assertEquals(AvailableProducts.showAvailableProducts(), message);
    }

}