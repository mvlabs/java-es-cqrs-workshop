package it.mvlabs.cqrs.commands;

import javax.validation.constraints.Size;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class AddOrderCommand {
    
    @TargetAggregateIdentifier
    private final String pizzeriaId; 
    @Size(min=1)
    private final String pizzaTaste;
    @Size(min=1)
    private final String customerName;
    
    public AddOrderCommand(String pizzeriaId, 
            String pizzaTaste, 
            String customerName) { 
        this.pizzeriaId = pizzeriaId;
        this.pizzaTaste = pizzaTaste;
        this.customerName = customerName;
    }
    public String getPizzeriaId() {
        return pizzeriaId;
    }
    public String getPizzaTaste() {
        return pizzaTaste;
    }
    public String getCustomerName() {
        return customerName;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
        result = prime * result + ((pizzaTaste == null) ? 0 : pizzaTaste.hashCode());
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
        AddOrderCommand other = (AddOrderCommand) obj;
        if (customerName == null) {
            if (other.customerName != null)
                return false;
        } else if (!customerName.equals(other.customerName))
            return false;
        if (pizzaTaste == null) {
            if (other.pizzaTaste != null)
                return false;
        } else if (!pizzaTaste.equals(other.pizzaTaste))
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
        return "AddOrderCommand [pizzeriaId=" + pizzeriaId + ", pizzaTaste=" + pizzaTaste + ", customerName="
                + customerName + "]";
    }
}
