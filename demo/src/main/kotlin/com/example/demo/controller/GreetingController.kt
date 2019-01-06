package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

//https://qiita.com/shinyay/items/38c5520ec5336be6de0f
//https://qiita.com/Yuki10/items/aef152f300a500b85725

@Controller
@RequestMapping("greeting")
class GreetingController {

    @GetMapping("/hello")
    fun hello(
            @RequestParam(value = "name", required = false, defaultValue = "world") name: String,
            model: Model): String {

        model.addAttribute("name", name)
        return "greeting"
    }
}