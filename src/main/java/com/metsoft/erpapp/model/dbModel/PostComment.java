package com.metsoft.erpapp.model.dbModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_comments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "comment_message")
    private String commentMessage;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

}
