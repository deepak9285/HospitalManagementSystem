package com.deepakLearning.HMS.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Doctor {
    public Doctor(Long id, String name, String specialization, String email, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false,unique = true)
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department>departments=new HashSet<>();
}
