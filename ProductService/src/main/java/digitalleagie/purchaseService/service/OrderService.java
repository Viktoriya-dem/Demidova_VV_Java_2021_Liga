package digitalleagie.purchaseService.service;

import digitalleagie.purchaseService.domain.Order;
import digitalleagie.purchaseService.domain.User;

public class OrderService {
    public void makeOrder(User user) {
        if (user.getBasket().getProductMap().size()==0) System.out.println("Корзина пуста, добавьте товары");
        else {
            user.setMakeOrder(true);
            user.setOrder(new Order(user.getBasket()));
        }
    }

    public void makeNewOrder(User user) {
        user.setMakeOrder(false);
        BasketService.clearBasket(user);
        System.out.println("Сделайте следующий заказ!");
    }

    public String showOrder(User user) {
        return String.format("Заказ пользователя %s № %d, общая сумма %d", user.getName(), user.getOrder().getOrderNumber(), user.getOrder().getBasket().getTotalPrice());
    }
}
