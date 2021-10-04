import digitalleagie.purchaseService.domain.Product;

public enum AvailableProducts {
    ROSE(new Product("Роза", 150L)),
    PION(new Product("Пион", 100L)),
    GERBERA(new Product("Гербера", 200L)),
    CHRYSANTHEMUM(new Product("Хризантема", 80L)),
    LILY(new Product("Лилия", 120L));

    private Product product;

    AvailableProducts(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public static String showAvailableProducts() {
        String allProduct="";
        for (Enum<AvailableProducts> products : AvailableProducts.values()) {
            allProduct=allProduct +"\n" + products.toString();
        }
        return ("Доступные товары:" + allProduct);
    }

    @Override
    public String toString() {
        return String.format("Продукт %s, цена %d", getProduct().getName(), getProduct().getPrice());
    }
}
