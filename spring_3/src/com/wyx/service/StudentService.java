package com.wyx.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller(value = "studentService")
public class StudentService {
    public void add() {
        System.out.println("add student...");
    }
}
