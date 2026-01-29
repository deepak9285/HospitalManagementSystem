package com.deepakLearning.HMS.entity;

import com.deepakLearning.HMS.type.BloodGroupType;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name="patient",
        uniqueConstraints={
                @UniqueConstraint(name="unique_constraint",columnNames = {"email"}),
                @UniqueConstraint(name="unique_patient_name_birthDate",columnNames = {"name","birthDate"})
        },
        indexes = {
                @Index(name="idx_patient_birth_date",columnList = "birthDate")
        }
)
public class patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,length=40)
    private String name;


    private String birthDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BloodGroupType getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroupType bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Column(nullable = false,unique = true)
    private String email;

    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne
    @JoinColumn(name="patient_insurance_id")//owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "p")
    private List<Appointment> appointments;
}
