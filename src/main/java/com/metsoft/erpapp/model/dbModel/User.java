package com.metsoft.erpapp.model.dbModel;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "user_name")
    private String  username;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String  password;


    @Column(name = "register_date")
    private LocalDateTime date;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private boolean isEnabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

   @OneToMany()
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private List<PostComment> postComments;

    @OneToMany()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Post> posts;


    @OneToMany()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<PostLike> postLikes;


    @OneToMany(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<PostCommentLike> postCommentLikes;



}