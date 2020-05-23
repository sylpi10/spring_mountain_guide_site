package com.sylpi.mountainguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PicturesController {

    @GetMapping("/photos")
    public String stages(){
        return "photos/photos";
    }

}
