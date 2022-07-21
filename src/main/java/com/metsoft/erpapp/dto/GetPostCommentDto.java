package com.metsoft.erpapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPostCommentDto {
    private String userName;
    private String firstName;
    private String lastName;
    private int  commentLike;
    private String comment;
    private LocalDateTime date;
    private int postId;

}

