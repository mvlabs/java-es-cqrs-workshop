package it.mvlabs.hibernate;

public class JSONBOrder {

    private long at;
    private String customer, pizza;
    
    public JSONBOrder() {
        super();
    }
    public JSONBOrder(long at, String customer, String pizza) {
        super();
        this.at = at;
        this.customer = customer;
        this.pizza = pizza;
    }
    public long getAt() {
        return at;
    }
    public void setAt(long at) {
        this.at = at;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public String getPizza() {
        return pizza;
    }
    public void setPizza(String pizza) {
        this.pizza = pizza;
    }
    @Override
    public String toString() {
        return "JSONBOrder [at=" + at + ", customer=" + customer + ", pizza=" + pizza + "]";
    }
}
