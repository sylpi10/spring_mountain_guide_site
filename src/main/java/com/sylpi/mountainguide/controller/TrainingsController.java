package com.sylpi.mountainguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class TrainingsController {

    @GetMapping("/stages")
    public String stages(){
        return "trainings/stages";
    }


    @GetMapping("/summer")
    public String summer(Model model){

        return "trainings/summer";
    }
}
