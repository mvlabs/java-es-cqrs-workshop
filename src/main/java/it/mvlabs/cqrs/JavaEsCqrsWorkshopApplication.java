package it.mvlabs.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class JavaEsCqrsWorkshopApplication {
    
    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<String> loadAllPizzerias() {
        return new ResponseEntity<>("Please checkout 1-create-pizzeria branch!", HttpStatus.ACCEPTED);
    } 
    
	public static void main(String[] args) {
		SpringApplication.run(JavaEsCqrsWorkshopApplication.class, args);
	}
}
