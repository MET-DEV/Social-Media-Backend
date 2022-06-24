package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.model.dbModel.PostImage;
import com.metsoft.erpapp.service.responseModel.Response;

public interface PostImageService {
    Response save(PostImage image);
    Response delete(int id);
    Response update(PostImage image);
    Response findAll();
    Response findById();
}
