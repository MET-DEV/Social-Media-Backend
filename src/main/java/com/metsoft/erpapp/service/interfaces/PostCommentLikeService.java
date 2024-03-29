package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.dto.SaveCommentLikeDto;
import com.metsoft.erpapp.model.dbModel.PostCommentLike;
import com.metsoft.erpapp.service.responseModel.Response;

public interface PostCommentLikeService {
    Response save(SaveCommentLikeDto saveCommentLikeDto);
    Response delete(int id);
    Response findAll();
    Response findById();
}
