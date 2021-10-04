package digitalleagie.purchaseService.domain;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Product, Integer> productMap;
    private Long totalPrice;

    public Basket() {
        this.productMap = new HashMap<Product, Integer>();
        this.totalPrice = 0L;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = this.totalPrice + totalPrice;
    }
}
