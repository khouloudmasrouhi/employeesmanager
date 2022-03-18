package com.example.employeesmanager.model;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Experience {
    private LocalDate startDate;
    private LocalDate endDate;
    private String post;
    private String society;

    public Experience(LocalDate startDate, LocalDate endDate, String post, String society) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.post = post;
        this.society = society;
    }
}
