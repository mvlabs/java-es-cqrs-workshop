package it.mvlabs.cqrs.values;

public class Order {

    private final long at;
    private final String customer, pizza;
  
    public Order(long at, String customer, String pizza) {
        this.at = at;
        this.customer = customer;
        this.pizza = pizza;
    }
    public long getAt() {
        return at;
    }
    
    public String getCustomer() {
        return customer;
    }
    
    public String getPizza() {
        return pizza;
    }
}
