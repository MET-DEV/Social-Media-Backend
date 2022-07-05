package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.dto.SavePostLikeDto;
import com.metsoft.erpapp.model.dbModel.PostLike;
import com.metsoft.erpapp.service.responseModel.Response;

public interface PostLikeService {
    Response save(SavePostLikeDto savePostLikeDto);
    Response delete(int id);
    Response update(PostLike postLike);
    Response findAll();
    Response findById();
    int getPostLikeByPostId(int postId);

}
