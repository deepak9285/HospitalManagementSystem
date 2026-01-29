package com.deepakLearning.HMS.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,unique = true)
    private String name;

    @OneToOne
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(name="my_dpt_doctors", joinColumns = @JoinColumn(name="dpt_id"))

    private Set<Doctor> doctors=new HashSet<>();
}
