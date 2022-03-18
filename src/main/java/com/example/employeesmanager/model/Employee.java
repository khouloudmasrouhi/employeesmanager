package com.example.employeesmanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import java.util.List;

@Document
@Data
public class Employee implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private List<Experience> experiences;

//    public Employee(String name, String email, String jobTitle, String phone, String imageUrl, List<Experience> experiences) {
//        this.name = name;
//        this.email = email;
//        this.jobTitle = jobTitle;
//        this.phone = phone;
//        this.imageUrl = imageUrl;
//        this.experiences = experiences;
//    }
}
