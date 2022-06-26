package com.metsoft.erpapp.dto;

import com.metsoft.erpapp.model.dbModel.Post;
import com.metsoft.erpapp.model.dbModel.PostComment;
import com.metsoft.erpapp.model.dbModel.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavePostCommentDto {
    private String commentMessage;
    private int userId;
    private int postId;


    public PostComment SavePostCommentDtoToPostComment(SavePostCommentDto postCommentDto){
        PostComment postComment=new PostComment();
        User user=new User();
        Post post=new Post();
        postComment.setPost(post);
        postComment.setUser(user);
        postComment.getPost().setId(postCommentDto.getPostId());
        postComment.getUser().setId(postCommentDto.getUserId());
        postComment.setCommentMessage(postCommentDto.getCommentMessage());
        return postComment;
    }

}
