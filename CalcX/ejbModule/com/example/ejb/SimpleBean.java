package com.example.ejb;

import javax.ejb.Stateless;

@Stateless
public class SimpleBean implements SimpleBeanLocal {
    @Override
    public String sayHello() {
        return "Hello from EJB!";
    }
}
