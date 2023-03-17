package com.example.demo.test.domain.model.aggregates.Board;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "reply")
public class Reply {

    @Id
    @Column(name = "reply_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replySeq;

    @Column(name = "reply_content", nullable = false)
    private String replyContent;

    @Column(name = "user_seq", nullable = false)
    private Long userSeq;

    @Column(name = "board_seq", nullable = false)
    private Long boardSeq;

    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate;

    @Column(name = "upd_date")
    private LocalDateTime updDate;

    @PrePersist
    public void createdAt() {
        this.regDate = LocalDateTime.now();
    }

    public void changeReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public void updateUpdDate() { this.updDate = LocalDateTime.now(); }
}