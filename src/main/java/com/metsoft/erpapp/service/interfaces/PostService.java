package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.model.dbModel.Post;
import com.metsoft.erpapp.service.responseModel.Response;

public interface PostService {
    Response save(Post post);
    Response update(Post post);
    Response delete(int id);
    Response findAll();
    Response findById();


}
