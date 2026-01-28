package com.deepakLearning.HMS.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

@Entity
@Table(
        name="patient",
        uniqueConstraints={
                @UniqueConstraint(name="unique_constraint",columnNames = {"email"}),
                @UniqueConstraint(name="unique_patient_name_birthDate",columnNames = {"name","birth_date"})
        },
        indexes = {
                @Index(name="idx_patient_birth_date",columnList = "birth_date")
        }
)
public class patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String birth_date;
    private String email;
    private String gender;
}
