package org.zsh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zsh.springcloud.bean.Student;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private Student student;

    @GetMapping("/name")
    public String getStudentName(){
        return student.getName();
    }
}
