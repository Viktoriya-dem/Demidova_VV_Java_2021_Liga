package digitalleagie.purchaseService.domain;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Product, Integer> productList;
    private Long totalSum;

    public Basket() {
        this.productList = new HashMap<Product, Integer>();
        this.totalSum = 0L;
    }

    public void setProductList(Map<Product, Integer> productList) {
        this.productList = productList;
    }

    public Map<Product, Integer> getProductList() {
        return productList;
    }

    public Long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = this.totalSum + totalSum;
    }

    public void add(Product product, Integer quantity) {
        this.getProductList().put(product, quantity);
        this.setTotalSum(quantity * product.getPrice());
    }

    public void remove(Product product, Integer quantity) {
        for (Map.Entry<Product, Integer> map : this.getProductList().entrySet()) {
            if (map.getKey().equals(product)) {
                if (quantity < map.getValue()) {
                    map.setValue(map.getValue() - quantity);
                    this.setTotalSum(-quantity * product.getPrice());
                } else {
                    this.setTotalSum(-product.getPrice() * map.getValue());
                    this.productList.remove(product);
                }
            }
        }
    }

    public void clear() {
        this.getProductList().clear();
        this.totalSum = 0L;
    }
}
