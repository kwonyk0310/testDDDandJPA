package com.example.demo.test.domain.model.aggregates;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
//@IdClass(UserId.class) 해당 어노테이션은 양 쪽 필드에 같은 값이 존재할 경우 사용
@Table(name = "user_info", schema = "user_info")
public class User implements Serializable {

    @EmbeddedId
    private UserId id;

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