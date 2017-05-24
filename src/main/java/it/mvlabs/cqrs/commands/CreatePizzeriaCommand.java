package it.mvlabs.cqrs.commands;

import javax.validation.constraints.Size;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreatePizzeriaCommand {

    @TargetAggregateIdentifier
    private final String pizzeriaId; 
    @Size(min=1)
    private final String name;
    
    public CreatePizzeriaCommand(String pizzeriaId, String name) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((pizzeriaId == null) ? 0 : pizzeriaId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreatePizzeriaCommand other = (CreatePizzeriaCommand) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pizzeriaId == null) {
            if (other.pizzeriaId != null)
                return false;
        } else if (!pizzeriaId.equals(other.pizzeriaId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CreatePizzeriaCommand [pizzeriaId=" + pizzeriaId + ", name=" + name + "]";
    }
}
