import digitalleagie.purchaseService.domain.Basket;
import digitalleagie.purchaseService.domain.Product;
import digitalleagie.purchaseService.domain.User;
import digitalleagie.purchaseService.service.BasketService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    User user = new User("Vika", "+79313012876");

    BasketService basketService1=mock(BasketService.class);

    @InjectMocks
    private User user1;
    @Mock
    private Basket basket;

    Map<Product, Integer> map=new HashMap<>();

    BasketService basketService=new BasketService();


    @Test
    public void addToBasketAddProductTest() {
        assertEquals(0, user.getBasket().getProductMap().size());
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        assertEquals("Роза", AvailableProducts.ROSE.getProduct().getName());
        assertEquals(1, user.getBasket().getProductMap().size());
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        assertEquals(1, user.getBasket().getProductMap().size());
        Assert.assertTrue(user.getBasket().getProductMap().containsKey(AvailableProducts.ROSE.getProduct()));
        Assert.assertTrue(user.getBasket().getProductMap().containsValue(6));
        assertEquals(900L, (long) user.getBasket().getTotalPrice());
        basketService.addToBasket(user, AvailableProducts.PION.getProduct(), 7);
        assertEquals(2, user.getBasket().getProductMap().size());
    }

    @Test
    public void addToBasketNotChangeAfterOrderTest() {
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        user.setMakeOrder(true);
        basketService.addToBasket(user, AvailableProducts.CHRYSANTHEMUM.getProduct(), 7);
        Assert.assertFalse(user.getBasket().getProductMap().containsKey(AvailableProducts.CHRYSANTHEMUM.getProduct()));
        assertEquals(1, user.getBasket().getProductMap().size());
    }

    @Test
    public void deleteFromBasketDeleteProductTest() {
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        basketService.showBasket(user);
        basketService.deleteFromBasket(user, AvailableProducts.ROSE.getProduct(), 2);
        assertEquals(150L, (long) user.getBasket().getTotalPrice());
        basketService.deleteFromBasket(user, AvailableProducts.ROSE.getProduct(), 1);
        assertEquals(0, (long) user.getBasket().getTotalPrice());
        assertEquals(0, user.getBasket().getProductMap().size());
    }

    @Test
    public void deleteFromBasketNotChangeAfterOrderTest() {
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        user.setMakeOrder(true);
        basketService.deleteFromBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertTrue(user.getBasket().getProductMap().containsKey(AvailableProducts.ROSE.getProduct()));
        assertEquals(1, user.getBasket().getProductMap().size());
        assertEquals(450L, (long) user.getBasket().getTotalPrice());
    }

    @Test
    public void clearBasketClearTest() {
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        assertEquals(1, user.getBasket().getProductMap().size());
        BasketService.clearBasket(user);
        assertEquals(0, user.getBasket().getProductMap().size());
    }

    @Test
    public void clearBasketNotClearAfterOrderTest() {
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        assertEquals(1, user.getBasket().getProductMap().size());
        user.setMakeOrder(true);
        BasketService.clearBasket(user);
        assertEquals(1, user.getBasket().getProductMap().size());
    }

    @Test
    public void showBasketTest() {
        basketService1.addToBasket(user1, AvailableProducts.ROSE.getProduct(), 3);
        basketService1.showBasket(user1);
        verify(basketService1).showBasket(user1);
        verify(basketService1, Mockito.times(1)).showBasket(user1);
    }
}
