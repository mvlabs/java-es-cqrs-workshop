package it.mvlabs.cqrs.events;

public class PizzeriaCreatedEvent {
    
    private final String pizzeriaId, name;
    
    public PizzeriaCreatedEvent(String pizzeriaId, String name) {
        super();
        this.pizzeriaId = pizzeriaId;
        this.name = name;
    }

    public String getPizzeriaId() {
        return pizzeriaId;
    }

    public String getName() {
        return name;
    }
}
