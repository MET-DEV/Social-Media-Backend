package com.metsoft.erpapp.dto;

import com.metsoft.erpapp.model.dbModel.Post;
import com.metsoft.erpapp.model.dbModel.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavePostDto {
    private String postMessage;
    private int userId;

    public Post savePostDtoToPost(SavePostDto savePostDto){
        Post post=new Post();
        User user=new User();
        post.setPostMessage(savePostDto.getPostMessage());
        post.setUser(user);
        post.getUser().setId(savePostDto.userId);
        return post;
    }
}
