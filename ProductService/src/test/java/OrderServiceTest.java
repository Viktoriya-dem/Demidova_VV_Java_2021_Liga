import digitalleagie.purchaseService.domain.AvailableProducts;
import digitalleagie.purchaseService.domain.User;
import digitalleagie.purchaseService.service.BasketService;
import digitalleagie.purchaseService.service.OrderService;
import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class OrderServiceTest {

    User user = new User("Vika", "+79313012876");
    BasketService basketService=new BasketService();
    OrderService orderService = new OrderService();

    User user1=mock(User.class);

    @Test
    public void makeOrderNotNullTest() {
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertNull(user.getOrder());
        orderService.makeOrder(user);
        assertNotNull(user.getOrder());
    }

    @Test
    public void makeOrderBasketIsEmptyTest() {
        orderService.makeOrder(user);
        Assert.assertNull(user.getOrder());
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        orderService.makeOrder(user);
        assertNotNull(user.getOrder());
    }

    @Test
    public void makeNewOrderTest() {
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        orderService.makeOrder(user);
        int n = user.getOrder().getOrderNumber();
        orderService.makeNewOrder(user);
        basketService.addToBasket(user, AvailableProducts.PION.getProduct(), 3);
        orderService.makeOrder(user);
        assertNotEquals(n, (int) user.getOrder().getOrderNumber());
    }

    @Test
    public void showOrderTest() {
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        orderService.makeOrder(user);
        String message = orderService.showOrder(user);
        assertEquals(String.format("Заказ пользователя %s № %d, общая сумма %d", user.getName(), user.getOrder().getOrderNumber(), user.getOrder().getBasket().getTotalPrice()), message);
    }

}
