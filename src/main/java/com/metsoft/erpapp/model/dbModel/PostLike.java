package com.metsoft.erpapp.model.dbModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_likes")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToMany()
    @JoinColumn(name = "user_id")
    private List<User> user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "post_like_users_posts",
            joinColumns = @JoinColumn(name = "post_like_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Post post;
}
