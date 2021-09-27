import digitalleagie.purchaseService.domain.User;
import digitalleagie.purchaseService.service.BasketService;
import org.junit.Assert;
import org.junit.Test;

public class BasketServiceTest {

    User user = new User("Vika", "+79313012876");

    @Test
    public void addToBasketAddProductTest() {
        Assert.assertEquals(0, user.getBasket().getProductList().size());
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertEquals(1, user.getBasket().getProductList().size());
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertEquals(1, user.getBasket().getProductList().size());
        Assert.assertTrue(user.getBasket().getProductList().containsKey(AvailableProducts.ROSE.getProduct()));
        Assert.assertTrue(user.getBasket().getProductList().containsValue(6));
        System.out.println(user.getBasket().getTotalSum());
        Assert.assertEquals(900L, (long) user.getBasket().getTotalSum());
        BasketService.addToBasket(user, AvailableProducts.PION.getProduct(), 7);
        Assert.assertEquals(2, user.getBasket().getProductList().size());
    }

    @Test
    public void addToBasketNotChangeAfterOrderTest() {
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        user.setMakeOrder(true);
        BasketService.addToBasket(user, AvailableProducts.CHRYSANTHEMUM.getProduct(), 7);
        Assert.assertFalse(user.getBasket().getProductList().containsKey(AvailableProducts.CHRYSANTHEMUM.getProduct()));
        Assert.assertEquals(1, user.getBasket().getProductList().size());
    }

    @Test
    public void deleteFromBasketDeleteProductTest() {
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        BasketService.deleteFromBasket(user, AvailableProducts.ROSE.getProduct(), 2);
        Assert.assertEquals(150L, (long) user.getBasket().getTotalSum());
        BasketService.deleteFromBasket(user, AvailableProducts.ROSE.getProduct(), 1);
        Assert.assertEquals(0, (long) user.getBasket().getTotalSum());
        Assert.assertEquals(0, user.getBasket().getProductList().size());
    }

    @Test
    public void deleteFromBasketNotChangeAfterOrderTest() {
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        user.setMakeOrder(true);
        BasketService.deleteFromBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertTrue(user.getBasket().getProductList().containsKey(AvailableProducts.ROSE.getProduct()));
        Assert.assertEquals(1, user.getBasket().getProductList().size());
        Assert.assertEquals(450L, (long) user.getBasket().getTotalSum());
    }

    @Test
    public void clearBasketClearTest() {
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertEquals(1, user.getBasket().getProductList().size());
        BasketService.clearBasket(user);
        Assert.assertEquals(0, user.getBasket().getProductList().size());
    }

    @Test
    public void clearBasketNotClearAfterOrderTest() {
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertEquals(1, user.getBasket().getProductList().size());
        user.setMakeOrder(true);
        BasketService.clearBasket(user);
        Assert.assertEquals(1, user.getBasket().getProductList().size());
    }

}
