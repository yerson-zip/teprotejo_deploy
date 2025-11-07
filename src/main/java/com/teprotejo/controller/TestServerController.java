package com.teprotejo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class TestServerController {


    @GetMapping
    public String getServer(){
        return " <img src=\"https://i.pinimg.com/736x/30/c3/73/30c373884d478ba2ce2bc91aaa81b3dc.jpg\" alt=\"jasjajs\" style=\"margin: 100px 400px;\">\n";
    }
}
