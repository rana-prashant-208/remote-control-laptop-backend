package com.codingbucket.webservice.webservicecodingbucket;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://192.168.0.103:4200/"})
public class HelloWorld {
    @GetMapping(path = "/hi")public String getHello(){
        return "Hell0 "+new Date().toString();
    }
    @GetMapping(path = "/hi-bean")
    public HelloBean getHelloBean(){
        return new HelloBean("Hi");
    }
    @GetMapping(path = "/hi-bean/{name}")
    public HelloBean getHelloBean(@PathVariable String name){
//        return new HelloBean("Hi "+name)
        throw new RuntimeException("hahahah");
    }
    @GetMapping(path = "/error")
    public String getError(){
        return "Error bro";
    }
}
