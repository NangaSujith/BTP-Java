
package com.example.hellobtp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloBtpApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBtpApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Hello from SAP BTP!";
    }
}
