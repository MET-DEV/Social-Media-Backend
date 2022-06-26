package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.dto.SavePostDto;
import com.metsoft.erpapp.model.dbModel.Post;
import com.metsoft.erpapp.service.responseModel.Response;

public interface PostService {
    Response save(SavePostDto savePostDto);
    Response update(Post post);
    Response delete(int id);
    Response findAll();
    Response findById();


}
