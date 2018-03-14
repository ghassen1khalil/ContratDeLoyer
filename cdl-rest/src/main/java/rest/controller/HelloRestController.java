package rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class HelloRestController {


    @RequestMapping(value = "/dali", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World - Rest API";
    }


}
