package com.metsoft.erpapp.model.dbModel;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "post_comment_likes")
public class PostCommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "comment_id")
    private PostComment comment;

  @ManyToOne()
  @JoinColumn(name = "user_id")
  private User user;
}
