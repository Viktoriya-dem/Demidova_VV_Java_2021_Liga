import digitalleagie.purchaseService.domain.User;
import digitalleagie.purchaseService.service.BasketService;
import digitalleagie.purchaseService.service.OrderService;
import org.junit.Assert;
import org.junit.Test;

public class OrderServiceTest {

    User user = new User("Vika", "+79313012876");

    @Test
    public void makeOrderNotNullTest() {
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertNull(user.getOrder());
        OrderService.makeOrder(user);
        Assert.assertNotNull(user.getOrder());
    }

    @Test
    public void makeOrderBasketIsEmptyTest() {
        OrderService.makeOrder(user);
        Assert.assertNull(user.getOrder());
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        OrderService.makeOrder(user);
        Assert.assertNotNull(user.getOrder());
    }

    @Test
    public void makeNewOrderTest() {
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        OrderService.makeOrder(user);
        int n = user.getOrder().getOrderNumber();
        OrderService.makeNewOrder(user);
        BasketService.addToBasket(user, AvailableProducts.PION.getProduct(), 3);
        OrderService.makeOrder(user);
        Assert.assertNotEquals(n, (int) user.getOrder().getOrderNumber());
    }

}
