package com.example.demo.test.domain.model.aggregates;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user_info", uniqueConstraints = {@UniqueConstraint(columnNames = "user_id")})
public class User {

    @Id
    @Column(name = "user_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @PrePersist
    public void createdAt() {
        this.registrationDate = LocalDateTime.now();
    }

    public void changeUserName(String userName) {
        this.userName = userName;
    }

}