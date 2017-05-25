package it.mvlabs.cqrs.web;

import java.util.List;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;

import it.mvlabs.cqrs.query.PizzeriaEntry;
import it.mvlabs.cqrs.query.PizzeriaRepository;
import it.mvlabs.hibernate.JSONUtility;

@Controller
public class CQRSController {

    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CommandGateway commandGateway;
    private final PizzeriaRepository pizzeriaRepository;

    public CQRSController(CommandGateway commandGateway, PizzeriaRepository pizzeriaRepository) {
        this.commandGateway = commandGateway;
        this.pizzeriaRepository = pizzeriaRepository;
    }
     
    @RequestMapping("/pizzerias-list")
    @ResponseBody
    public List<PizzeriaEntry> loadAllPizzerias() {
        return pizzeriaRepository.findAll();
    } 
    
    @RequestMapping("/orders-list")
    @ResponseBody
    public String loadAllOrders() {
        List<PizzeriaEntry> entries = pizzeriaRepository.findAll();
        JsonArray orders = new JsonArray();
        entries.forEach(pizzeria -> 
        orders.addAll(JSONUtility.pizzeriaOrders(pizzeria.getPizzas(), pizzeria.getId(), pizzeria.getName())));
        return JSONUtility.arrayToString(orders);
    } 

    @SuppressWarnings("rawtypes")
    @RequestMapping("/create-pizzeria")
    public ResponseEntity createPizzeria(
            @RequestParam(value="name") String name) {
       //TODO here you have to send a command instance
      //HINT, see org.axonframework.commandhandling.gateway.CommandGateway
        return new ResponseEntity<String>("Implement Create Pizzeria End point!", HttpStatus.ACCEPTED);
    }  
    
    @SuppressWarnings("rawtypes")
    @RequestMapping("/add-order")
    public ResponseEntity addOrder(
            @RequestParam(value="pizzeriaId") String pizzeriaId,
            @RequestParam(value="pizzaTaste") String pizzaTaste,
            @RequestParam(value="customerName") String customerName) {
       //TODO to be implemented later in the workshop 
        return new ResponseEntity<String>("Introduce Add Order end point here!", HttpStatus.ACCEPTED);
    }
    
    @SuppressWarnings("rawtypes")
    @RequestMapping("/complete-order")
    public ResponseEntity completeOrder(
            @RequestParam(value="at") String at,
            @RequestParam(value="pizzeria") String pizzeriaId,
            @RequestParam(value="pizza") String pizzaTaste,
            @RequestParam(value="customer") String customer) {
        //TODO to be implemented later in the workshop.
        return new ResponseEntity<String>("Add Complete Order end point here!", HttpStatus.ACCEPTED);
    }  
}
