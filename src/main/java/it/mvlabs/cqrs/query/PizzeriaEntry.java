package it.mvlabs.cqrs.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PizzeriaEntry {

    @Id
    private String id;
    private String name;
    @Column(length=5000)
    private String pizzas;

    public PizzeriaEntry() {}
    
    public PizzeriaEntry(String id, String name, String pizzas) {
        super();
        this.id = id;
        this.name = name;
        this.pizzas = pizzas;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPizzas() {
        return pizzas;
    }
    public void setPizzas(String pizzas) {
        this.pizzas = pizzas;
    }
}
