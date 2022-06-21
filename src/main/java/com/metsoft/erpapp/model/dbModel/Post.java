package com.metsoft.erpapp.model.dbModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "post_message")
    private String postMessage;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @OneToMany()
    private List<PostImage> postImages;
    @OneToMany()
    private List<PostLike> postLikes;
    @OneToMany
    private List<PostComment> postComments;


}
