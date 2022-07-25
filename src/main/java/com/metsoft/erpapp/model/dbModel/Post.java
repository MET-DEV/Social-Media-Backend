package com.metsoft.erpapp.model.dbModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
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
