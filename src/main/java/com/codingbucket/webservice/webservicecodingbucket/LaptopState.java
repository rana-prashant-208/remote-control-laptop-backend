package com.codingbucket.webservice.webservicecodingbucket;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://192.168.0.104:4200"})
public class LaptopState {
    private static String sleepCommand="E:\\Rana\\Project\\PSTools\\psshutdown.exe -d -t 0 -accepteula";
    @GetMapping(path = "/state/{value}")
    public String getHelloBean(@PathVariable String value){
        if(value.equalsIgnoreCase("sleep")){
        new Thread(()->{
            try {
                Runtime.getRuntime().exec(sleepCommand).waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        return "Done";}
        else {
            return "Unknown Command";
        }
//        return new HelloBean("Hi "+name)
//        throw new RuntimeException("hahahah");
    }
}
