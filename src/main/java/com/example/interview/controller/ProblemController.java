package com.example.interview.controller;

import com.example.interview.service.LogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class ProblemController {
    @Autowired
    private LogicService logicService;

    @GetMapping("/problem")
    public String showLoginPage() {
        return "problem";
    }

    @PostMapping("/problem1")
    @ResponseBody
    public long problem1() {
        return logicService.problem1();
    }

    @PostMapping("/problem2")
    @ResponseBody
    public String problem2() throws IOException {
        return logicService.problem2();
    }
}
