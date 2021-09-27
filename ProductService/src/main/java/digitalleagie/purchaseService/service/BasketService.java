package digitalleagie.purchaseService.service;

import digitalleagie.purchaseService.domain.Product;
import digitalleagie.purchaseService.domain.User;

import java.util.Map;

public class BasketService {
    public static void addToBasket(User user, Product product, Integer quantity) {
        if (!user.getMakeOrder()) {
            if (!user.getBasket().getProductList().isEmpty()) {
                for (Map.Entry<Product, Integer> map : user.getBasket().getProductList().entrySet()) {
                    if (map.getKey().equals(product)) {
                        map.setValue(map.getValue() + quantity);
                        user.getBasket().setTotalSum(product.getPrice()*quantity);
                    } else user.getBasket().add(product, quantity);
                }
            } else user.getBasket().add(product, quantity);
        } else System.out.println("Заказ создан! Нельзя изменить корзину");
    }

    public static void deleteFromBasket(User user, Product product, Integer quantity) {
        if (!user.getMakeOrder()) {
            if (user.getBasket().getProductList().containsKey(product)) {
                user.getBasket().remove(product, quantity);
            }
        } else System.out.println("Заказ создан! Нельзя изменить корзину");
    }

    public static void clearBasket(User user) {
        if (!user.getMakeOrder()) {
            user.getBasket().clear();
        } else System.out.println("Заказ создан! Нельзя изменить корзину");
    }

    public static void showBasket(User user) {
        System.out.println(String.format("Список покупок в корзине пользователя %s:", user.getName()));
        user.getBasket().getProductList().forEach((k, v) -> System.out.println(String.format("%s, количество %d, цена за штуку: %d", k.getName(), v, k.getPrice())));
        System.out.println(String.format("Общая сумма в корзине %d", user.getBasket().getTotalSum()));
    }
}
