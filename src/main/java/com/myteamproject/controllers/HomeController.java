
package com.myteamproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HomeController {   
    
    @RequestMapping
    public String hello(){
        return "index";
    }       
    
//    @RequestMapping("/customer")
//    public String listCustomers(Model theModels){
//        return "list-customers";
//    }
}
    

