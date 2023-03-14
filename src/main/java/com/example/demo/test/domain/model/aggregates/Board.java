package com.example.demo.test.domain.model.aggregates;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board", schema = "board")
public class Board {

    @Id
    @Column(name = "board_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardSeq;

    @Column(name = "board_title", nullable = false)
    private String boardTitle;

    @Column(name = "board_content", nullable = false)
    private String boardContent;

    @Column(name = "views")
    private Integer views;

    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate;

    @Column(name = "upd_date")
    private LocalDateTime updDate;

    @PrePersist
    public void createdAt() {
        this.regDate = LocalDateTime.now();
    }

    public void changeBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public void changeBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

}