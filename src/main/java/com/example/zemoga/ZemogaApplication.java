package com.example.zemoga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.zemoga.adapter.output.db.repository")
@SpringBootApplication
public class ZemogaApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZemogaApplication.class, args);
  }

}
