
package com.example.hellobtp.controller;

import com.example.hellobtp.model.TestEntity;
import com.example.hellobtp.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestRepository repository;

    @PostMapping
    public String insertRecord(@RequestParam String code) {
        TestEntity entity = new TestEntity();
        entity.setDocdate(LocalDate.now());
        entity.setCode(code);
        repository.save(entity);
        return "Inserted Data Into Hana DB Successfully!";
    }
}
