package com.metsoft.erpapp.service.interfaces;


import com.metsoft.erpapp.model.dbModel.PostComment;
import com.metsoft.erpapp.service.responseModel.Response;

public interface PostCommentService {
    Response save(PostComment comment);
    Response delete(int id);
    Response update(PostComment comment);
    Response findAll();
    Response findById(int id);
}
