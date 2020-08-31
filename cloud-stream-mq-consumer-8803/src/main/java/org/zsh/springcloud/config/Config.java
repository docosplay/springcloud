package org.zsh.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zsh.springcloud.bean.Student;

@Configuration
public class Config {

    @Bean
    public Student myStudent(){
        return new Student("haha");
    }
}
