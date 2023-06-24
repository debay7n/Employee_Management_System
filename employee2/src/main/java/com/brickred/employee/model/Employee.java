package com.brickred.employee.model;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    private String name;

    private String mobile;

    private String email;

    private String city;

    private String state;

    private String country;
    private String pinCode;

    @Enumerated(EnumType.STRING)
    private Department department;



}
