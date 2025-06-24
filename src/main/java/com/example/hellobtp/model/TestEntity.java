package com.example.hellobtp.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "\"TEST\"", schema = "DBADMIN")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Use IDENTITY for HANA auto-increment
    private Long id;

    private LocalDate docdate;
    private String code;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public LocalDate getDocdate() {
        return docdate;
    }

    public void setDocdate(LocalDate docdate) {
        this.docdate = docdate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
