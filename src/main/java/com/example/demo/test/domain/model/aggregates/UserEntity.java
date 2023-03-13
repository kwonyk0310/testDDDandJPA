package com.example.demo.test.domain.model.aggregates;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user_info", schema = "user_info")
public class UserEntity {

    @Id
    @Column(name = "user_seq", nullable = false)
    private Integer userSeq;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "age", nullable = false)
    private String age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

}