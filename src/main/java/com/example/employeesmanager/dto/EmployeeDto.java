package com.example.employeesmanager.dto;


import com.example.employeesmanager.model.Experience;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {
    private String id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private List<Experience> experiences;

//    public EmployeeDto(String name, String email, String jobTitle, String phone, String imageUrl, List<Experience> experiences) {
//        this.name = name;
//        this.email = email;
//        this.jobTitle = jobTitle;
//        this.phone = phone;
//        this.imageUrl = imageUrl;
//        this.experiences = experiences;
//    }
}
