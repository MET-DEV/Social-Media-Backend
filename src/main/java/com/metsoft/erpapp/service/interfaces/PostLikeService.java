package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.model.dbModel.PostLike;
import com.metsoft.erpapp.service.responseModel.Response;

public interface PostLikeService {
    Response save(PostLike postLike);
    Response delete(int id);
    Response update(PostLike postLike);
    Response findAll();
    Response findById();

}
