package org.acme.getting.started;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class GreetingController {
 
    @GetMapping(produces=MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return "hola";
}   

    @GetMapping(value = "/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Greeting hello(@PathVariable(name = "name") String name) {
        return new Greeting("hola " + name);
    }

    public static class Greeting {
        private final String message;
 
        public Greeting(String message) {
            this.message = message;
        }
        
        public String getMessage(){
            return message;
        }
    }
}