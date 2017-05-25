package it.mvlabs.cqrs.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//TODO to work on later, this is the class implementing the Query projections
public class PizzeriaEventListener {
    
    private PizzeriaRepository repository;

    @Autowired
    public PizzeriaEventListener(PizzeriaRepository repository) {
        this.repository = repository;
    }  
}