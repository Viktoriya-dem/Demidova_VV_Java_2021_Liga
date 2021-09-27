package digitalleagie.purchaseService.domain;

public class Product {
    private String productName;
    private Integer price;

    public Product(String productName, Integer price) {
        this.productName = productName;
        this.price = price;
    }

    public String getName() {
        return productName;
    }

    public Integer getPrice() {
        return price;
    }
}
