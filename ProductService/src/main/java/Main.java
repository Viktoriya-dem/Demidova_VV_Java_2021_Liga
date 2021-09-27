import digitalleagie.purchaseService.domain.User;
import digitalleagie.purchaseService.service.BasketService;
import digitalleagie.purchaseService.service.OrderService;

public class Main {
    public static void main(String[] args) {
        User user = new User("Vika", "+79313012876");
        AvailableProducts.showAvailableProducts();
        OrderService.makeOrder(user);
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        BasketService.addToBasket(user, AvailableProducts.PION.getProduct(), 2);
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        BasketService.showBasket(user);
        OrderService.makeOrder(user);
        OrderService.showOrder(user);
        OrderService.makeNewOrder(user);
        BasketService.showBasket(user);
        BasketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        BasketService.showBasket(user);
        OrderService.makeOrder(user);
        OrderService.showOrder(user);
    }
}
