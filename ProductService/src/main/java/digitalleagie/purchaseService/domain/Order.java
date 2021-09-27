package digitalleagie.purchaseService.domain;

public class Order {
    private Basket basket;
    private Integer orderNumber;

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Order(Basket basket) {
        this.basket = basket;
        this.orderNumber = Math.abs(31 * this.hashCode() + basket.hashCode());
    }

}
