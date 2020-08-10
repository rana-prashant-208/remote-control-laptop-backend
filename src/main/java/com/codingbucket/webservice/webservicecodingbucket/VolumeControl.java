package com.codingbucket.webservice.webservicecodingbucket;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://192.168.0.104:4200"})

public class VolumeControl {
    private static String location="E:\\Rana\\Project\\VolumeControl\\SetVol.exe";
    @GetMapping(path = "/volume/{value}")
    public String getHelloBean(@PathVariable String value){
        try {
            Runtime.getRuntime().exec(location+" "+value).waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Failed "+e.getLocalizedMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Done";
//        return new HelloBean("Hi "+name)
//        throw new RuntimeException("hahahah");
    }
}
