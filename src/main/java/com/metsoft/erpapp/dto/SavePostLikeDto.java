package com.metsoft.erpapp.dto;

import com.metsoft.erpapp.model.dbModel.Post;
import com.metsoft.erpapp.model.dbModel.PostLike;
import com.metsoft.erpapp.model.dbModel.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavePostLikeDto {

    private int  user_id;
    private int post_id;


    public PostLike savePostDtoToPostLike(SavePostLikeDto savePostLikeDto){
        PostLike postLike=new PostLike();
        Post post=new Post();
        User user=new User();
        user.setId(savePostLikeDto.getUser_id());
        post.setId(savePostLikeDto.getPost_id());
        postLike.setPost(post);
        postLike.setUser(user);
        return postLike;
    }

}
