package it.mvlabs.cqrs.aggregates;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import it.mvlabs.cqrs.commands.AddOrderCommand;
import it.mvlabs.cqrs.commands.CreatePizzeriaCommand;
import it.mvlabs.cqrs.events.OrderAddedEvent;
import it.mvlabs.cqrs.events.PizzeriaCreatedEvent;
import it.mvlabs.cqrs.values.Order;

@Aggregate
public class Pizzeria {

    @AggregateIdentifier
    private String id;
    @SuppressWarnings("unused")
    private String name;
    private final List<Order> pizzas = new ArrayList<Order>();

    @SuppressWarnings("unused")
    private Pizzeria() {
    }

    @CommandHandler
    public Pizzeria(CreatePizzeriaCommand command) {
        apply(new PizzeriaCreatedEvent(
                command.getPizzeriaId(), 
                command.getName()));
    }

    @CommandHandler
    public void addOrder(AddOrderCommand command) {
        apply(new OrderAddedEvent(
                id, 
                command.getCustomerName(), 
                command.getPizzaTaste(),
                System.currentTimeMillis()));
    }

    //TODO add Complete Order Command Handler
    

    @EventSourcingHandler
    public void on(PizzeriaCreatedEvent event) {
        this.id = event.getPizzeriaId();
        this.name = event.getName();
    }

    @EventSourcingHandler
    public void on(OrderAddedEvent event) {
        pizzas.add(new Order(
                event.getAt(),
                event.getCustomerName(),
                event.getPizzaTaste()));
    }

    //TODO add Order Completed Event Sourcing Handler
}