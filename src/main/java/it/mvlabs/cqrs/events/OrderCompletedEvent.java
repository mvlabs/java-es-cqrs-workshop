package it.mvlabs.cqrs.events;

public class OrderCompletedEvent {

    private final String pizzeriaId;
    private final String customerName;
    private final String pizzaTaste; 
    private final long at;
    
    public OrderCompletedEvent(
            String pizzeriaId, 
            String customerName, 
            String pizzaTaste, 
            long at) {
        this.pizzeriaId = pizzeriaId;
        this.customerName = customerName;
        this.pizzaTaste = pizzaTaste;
        this.at = at;
    }


    public String getPizzeriaId() {
        return pizzeriaId;
    }


    public String getCustomerName() {
        return customerName;
    }


    public String getPizzaTaste() {
        return pizzaTaste;
    }


    public long getAt() {
        return at;
    }
}
