import digitalleagie.purchaseService.domain.AvailableProducts;
import digitalleagie.purchaseService.domain.User;
import digitalleagie.purchaseService.service.BasketService;
import digitalleagie.purchaseService.service.OrderService;

public class Main {
    public static void main(String[] args) {
        User user = new User("Vika", "+79313012876");
        BasketService basketService=new BasketService();
        OrderService orderService=new OrderService();
        System.out.println(AvailableProducts.showAvailableProducts());
       orderService.makeOrder(user);
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        basketService.addToBasket(user, AvailableProducts.PION.getProduct(), 2);
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
       basketService.showBasket(user);
        orderService.makeOrder(user);
        System.out.println(orderService.showOrder(user));
        orderService.makeNewOrder(user);
        basketService.showBasket(user);
        basketService.addToBasket(user, AvailableProducts.ROSE.getProduct(), 3);
        basketService.showBasket(user);
        orderService.makeOrder(user);
       System.out.println(orderService.showOrder(user));
    }
}
