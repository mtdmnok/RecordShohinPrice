package com.example.demo.conf;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example.demo")
@EntityScan("com.example.demo.entity")
@EnableJpaRepositories("com.example.demo.repository")
public class SpringLoginApplication {

}
