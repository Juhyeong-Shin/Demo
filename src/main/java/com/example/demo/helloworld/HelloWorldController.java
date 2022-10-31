package com.example.demo.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;
    //Get
    // /hello-world(endpoint)
    @GetMapping(path = "/hello-World")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-World-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean ("Hello World");
    }

    @GetMapping(path = "/hello-World-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean (String.format("Hello World, %s",name));
    }   //format = 2가지 매개변수 1문자형태 %s 가변데이터 저장하겠다.

    @GetMapping(path = "/hello-world-interationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
    return messageSource.getMessage("",null,locale);
    }
}
