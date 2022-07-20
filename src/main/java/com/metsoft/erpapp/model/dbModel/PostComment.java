package com.metsoft.erpapp.model.dbModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
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
    @JsonIgnore
    private Post post;

    @OneToMany(mappedBy = "comment")
    private List<PostCommentLike> postCommentLikes;

     @ManyToOne()
     @JoinColumn(name = "user_id")
     private User user;

}
