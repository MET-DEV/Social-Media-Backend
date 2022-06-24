package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.service.responseModel.Response;

public interface PostCommentLike {
    Response save(PostCommentLike postCommentLike);
    Response delete(int id);
    Response findAll();
    Response findById();
}
