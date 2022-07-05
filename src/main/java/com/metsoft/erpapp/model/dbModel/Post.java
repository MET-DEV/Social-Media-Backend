package com.metsoft.erpapp.model.dbModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

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



    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private  User user;

    @OneToMany(mappedBy = "post")
    private List<PostImage> postImages;
    @OneToMany(mappedBy = "post")
    private List<PostLike> postLikes;
    @OneToMany(mappedBy = "post")
    private List<PostComment> postComments;


}
