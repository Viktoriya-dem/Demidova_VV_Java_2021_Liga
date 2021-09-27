package digitalleagie.purchaseService.service;

import digitalleagie.purchaseService.domain.Order;
import digitalleagie.purchaseService.domain.User;

public class OrderService {
    public static void makeOrder(User user) {
        if (user.getBasket().getProductList().isEmpty()) System.out.println("Корзина пуста, добавьте товары");
        else {
            user.setMakeOrder(true);
            user.setOrder(new Order(user.getBasket()));
        }
    }

    public static void makeNewOrder(User user) {
        user.setMakeOrder(false);
        user.getBasket().clear();
        System.out.println("Сделайте следующий заказ!");
    }

    public static void showOrder(User user) {
        System.out.println(String.format("Заказ пользователя %s № %d, общая сумма %d", user.getName(), user.getOrder().getOrderNumber(), user.getOrder().getBasket().getTotalSum()));
    }
}
