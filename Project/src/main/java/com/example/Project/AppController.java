package com.example.Project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @GetMapping("")
    public String HomePage(){return "main";}

    @RequestMapping("/reg")
    public String Registration(){
        return "reg";
    }

    @RequestMapping("/log")
    public String Authorization(){
        return "log";
    }

//    @RequestMapping("/favorites")
//    public String Favorites(){
//        return "favorites";
//    }



}
