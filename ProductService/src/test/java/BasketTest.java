import digitalleagie.purchaseService.domain.Basket;
import org.junit.Assert;
import org.junit.Test;


public class BasketTest {

    private Basket basket = new Basket();

    @Test
    public void addTest() {
        Assert.assertEquals(0, basket.getProductList().size());
        basket.add(AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertEquals(1, basket.getProductList().size());
        Assert.assertTrue(basket.getProductList().containsKey(AvailableProducts.ROSE.getProduct()));
        Assert.assertTrue(basket.getProductList().containsValue(3));
        Assert.assertEquals(450L, (long) basket.getTotalSum());
        basket.add(AvailableProducts.PION.getProduct(), 7);
        Assert.assertEquals(2, basket.getProductList().size());
    }

    @Test
    public void deleteTest() {
        basket.add(AvailableProducts.ROSE.getProduct(), 3);
        basket.remove(AvailableProducts.ROSE.getProduct(), 3);
        Assert.assertEquals(0, basket.getProductList().size());
        basket.add(AvailableProducts.PION.getProduct(), 3);
        basket.remove(AvailableProducts.PION.getProduct(), 1);
        Assert.assertEquals(200L, (long) basket.getTotalSum());
    }

    @Test
    public void clearTest() {
        basket.add(AvailableProducts.ROSE.getProduct(), 3);
        basket.add(AvailableProducts.PION.getProduct(), 3);
        Assert.assertEquals(2, basket.getProductList().size());
        Assert.assertEquals(750L, (long) basket.getTotalSum());
        basket.clear();
        Assert.assertEquals(0, basket.getProductList().size());
        Assert.assertEquals(0, (long) basket.getTotalSum());
    }

}
