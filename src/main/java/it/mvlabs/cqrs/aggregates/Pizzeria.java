package it.mvlabs.cqrs.aggregates;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

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
    
    //TODO implement both the command handler and event sourcing handler here
    /*
     * HINT
     * 1) see org.axonframework.commandhandling.model.AggregateLifecycle.apply for business logic application.
     * 2) see org.axonframework.commandhandling.CommandHandler for command handling
     * 3) see org.axonframework.eventsourcing.EventSourcing for event sourcing
     */

    //FOR EXAMPLE:
    
    /**
     * @CommandHandler
     * public Pizzeria(Command command) {
     *  apply(new Event( ... ));
     * }
     * 
     * @EventSourcingHandler
     *   public void on(Event event) {
     *   this.id = event.getId();
     *   this.name = event.getName();
     *   ...
     * }
     */
}