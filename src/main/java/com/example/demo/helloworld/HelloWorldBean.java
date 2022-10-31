package com.example.demo.helloworld;
//lombok

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //디폴트생성자 만들어진다.안에 매개변수가 없는.
public class HelloWorldBean {
    private String message;

}

/*
    public String getMessage(){
        return this.message();
    }
    public void setMessage(String msg){
        this.message = msg;
    }
    public HelloWorldBean(String message) {
      this.message = message;
    }
 */