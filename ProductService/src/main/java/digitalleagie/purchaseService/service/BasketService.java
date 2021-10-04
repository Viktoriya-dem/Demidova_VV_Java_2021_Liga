package digitalleagie.purchaseService.service;

import digitalleagie.purchaseService.domain.Product;
import digitalleagie.purchaseService.domain.User;

import java.util.Map;


public class BasketService {
    public void addToBasket(User user, Product product, Integer quantity) {
        if (!user.getMakeOrder()) {
            if (user.getBasket().getProductMap().size() != 0) {
                for (Map.Entry<Product, Integer> map : user.getBasket().getProductMap().entrySet()) {
                    if (map.getKey().equals(product)) {
                        map.setValue(map.getValue() + quantity);
                        user.getBasket().setTotalPrice(product.getPrice() * quantity);
                    } else {
                        user.getBasket().getProductMap().put(product, quantity);
                    }
                }
            } else {
                user.getBasket().getProductMap().put(product, quantity);
                user.getBasket().setTotalPrice(quantity * product.getPrice());
            }
        } else {
            System.out.println("Заказ создан! Нельзя изменить корзину");
        }
    }

    public void deleteFromBasket(User user, Product product, Integer quantity) {
        if (!user.getMakeOrder()) {
            if (user.getBasket().getProductMap().containsKey(product)) {
                for (Map.Entry<Product, Integer> map : user.getBasket().getProductMap().entrySet()) {
                    if (map.getKey().equals(product)) {
                        if (quantity < map.getValue()) {
                            map.setValue(map.getValue() - quantity);
                            user.getBasket().setTotalPrice(-quantity * product.getPrice());
                        } else {
                            user.getBasket().setTotalPrice(-product.getPrice() * map.getValue());
                            user.getBasket().getProductMap().remove(product);
                        }
                    }
                }
            }
        } else {
            System.out.println("Заказ создан! Нельзя изменить корзину");
        }
    }

    public static void clearBasket(User user) {
        if (!user.getMakeOrder()) {
            user.getBasket().getProductMap().clear();
            user.getBasket().setTotalPrice(-user.getBasket().getTotalPrice());
        } else {
            System.out.println("Заказ создан! Нельзя изменить корзину");
        }
    }

    public void showBasket(User user) {
        System.out.println(String.format("Список покупок в корзине пользователя %s:", user.getName()));
        user.getBasket().getProductMap().forEach((k, v) -> System.out.println(String.format("%s, количество %d, цена за штуку: %d", k.getName(), v, k.getPrice())));
        System.out.println(String.format("Общая сумма в корзине %d", user.getBasket().getTotalPrice()));
    }
}
