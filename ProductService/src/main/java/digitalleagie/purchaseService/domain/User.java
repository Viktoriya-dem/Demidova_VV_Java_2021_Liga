package digitalleagie.purchaseService.domain;

public class User {

    private String name;
    private String phone;
    private Basket basket;
    private Order order;
    private Boolean makeOrder;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.basket = new Basket();
        this.makeOrder = false;
        this.order = null;
    }

    public String getName() {
        return name;
    }

    public Basket getBasket() {
        return basket;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Boolean getMakeOrder() {
        return makeOrder;
    }

    public void setMakeOrder(Boolean makeOrder) {
        this.makeOrder = makeOrder;
    }

}
