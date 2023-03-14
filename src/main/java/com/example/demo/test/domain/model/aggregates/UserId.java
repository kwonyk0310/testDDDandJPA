package com.example.demo.test.domain.model.aggregates;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Builder
public class UserId implements Serializable {

    @Column(name = "user_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userSeq;

    @Column(name = "user_id", nullable = false)
    private String userId;

}