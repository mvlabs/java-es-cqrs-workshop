package it.mvlabs.cqrs.query;

import java.util.List;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.mvlabs.cqrs.events.OrderAddedEvent;
import it.mvlabs.cqrs.events.PizzeriaCreatedEvent;
import it.mvlabs.hibernate.JSONBOrder;
import it.mvlabs.hibernate.JSONUtility;

@Component
public class PizzeriaEventListener {
    
    private PizzeriaRepository repository;

    @Autowired
    public PizzeriaEventListener(PizzeriaRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(PizzeriaCreatedEvent event) {
        repository.save(new PizzeriaEntry(
                event.getPizzeriaId(), 
                event.getName(),
                "[]"));
    }

    @EventHandler
    public void on(OrderAddedEvent event) {
        PizzeriaEntry pizzeria = repository.findOne(event.getPizzeriaId());
        
        JSONBOrder order = new JSONBOrder(
                event.getAt(), 
                event.getCustomerName(), 
                event.getPizzaTaste());  
        List<JSONBOrder> orders = JSONUtility.ordersFromJsonArray(pizzeria.getPizzas());
        orders.add(order);
        
        pizzeria.setPizzas(JSONUtility.serializeOrders(orders));
        repository.save(pizzeria);
    }
}