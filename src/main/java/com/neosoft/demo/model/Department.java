package com.neosoft.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Department
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long dptId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Employee> employees;
}
