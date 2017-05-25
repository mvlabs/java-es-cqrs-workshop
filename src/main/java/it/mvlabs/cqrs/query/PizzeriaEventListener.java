package it.mvlabs.cqrs.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.mvlabs.cqrs.events.PizzeriaCreatedEvent;

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
}