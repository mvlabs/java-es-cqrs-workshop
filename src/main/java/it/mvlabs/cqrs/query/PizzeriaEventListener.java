package it.mvlabs.cqrs.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PizzeriaEventListener {
    
    private PizzeriaRepository repository;

    @Autowired
    public PizzeriaEventListener(PizzeriaRepository repository) {
        this.repository = repository;
    }

    //TODO add query projection for the events
    //HINT, see AxonFramework EventHandler
      
}