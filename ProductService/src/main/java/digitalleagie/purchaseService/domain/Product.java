package digitalleagie.purchaseService.domain;

public class Product {
    private String productName;
    private Long price;

    public Product(String productName, Long price) {
        this.productName = productName;
        this.price = price;
    }

    public String getName() {
        return productName;
    }

    public Long getPrice() {
        return price;
    }
}
