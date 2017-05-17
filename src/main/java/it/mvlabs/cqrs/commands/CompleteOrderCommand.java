package it.mvlabs.cqrs.commands;

import javax.validation.constraints.Size;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CompleteOrderCommand {
    @Size(min=1)
    private final String customerName;
    @TargetAggregateIdentifier
    private final String pizzeriaId; 
    @Size(min=1)
    private final String pizzaTaste;
    private final long at;
    
    public CompleteOrderCommand(String customerName,
            String pizzeriaId, 
            String pizzaTaste, 
            long at) { 
        this.customerName = customerName;
        this.pizzeriaId = pizzeriaId;
        this.pizzaTaste = pizzaTaste;
        this.at = at;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getPizzeriaId() {
        return pizzeriaId;
    }
    public String getPizzaTaste() {
        return pizzaTaste;
    }
    public long getAt() {
        return at;
    }
    
    @Override
    public String toString() {
        return "CompleteOrderCommand [customerName=" + customerName + ", pizzeriaId=" + pizzeriaId + ", pizzaTaste="
                + pizzaTaste + ", orderCreatedAt=" + at + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (at ^ (at >>> 32));
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
        CompleteOrderCommand other = (CompleteOrderCommand) obj;
        if (at != other.at)
            return false;
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
}
