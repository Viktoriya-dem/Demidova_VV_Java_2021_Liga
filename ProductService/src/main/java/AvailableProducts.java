import digitalleagie.purchaseService.domain.Product;

public enum AvailableProducts {
    ROSE(new Product("Роза", 150)),
    PION(new Product("Пион", 100)),
    GERBERA(new Product("Гербера", 200)),
    CHRYSANTHEMUM(new Product("Хризантема", 80)),
    LILY(new Product("Лилия", 120));

    private Product product;

    AvailableProducts(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public static void showAvailableProducts() {
        System.out.println("Доступные товары:");
        for (Enum<AvailableProducts> products : AvailableProducts.values()) {
            System.out.println(products.toString());
        }
    }

    @Override
    public String toString() {
        return String.format("Продукт %s, цена %d", getProduct().getName(), getProduct().getPrice());
    }
}
