package com.metsoft.erpapp.service.impls;

import com.metsoft.erpapp.model.dbModel.PostImage;
import com.metsoft.erpapp.repository.PostImageRepository;
import com.metsoft.erpapp.service.interfaces.PostImageService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImageServiceImpl implements PostImageService {
    private PostImageRepository postImageRepository;

    @Autowired
    public PostImageServiceImpl(PostImageRepository postImageRepository) {
        this.postImageRepository = postImageRepository;
    }


    @Override
    public Response save(PostImage image) {
        postImageRepository.save(image);
        return new SuccessResponse(true,"İmage added");
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response update(PostImage image) {
        return null;
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<PostImage>>(true,"Images Listed",postImageRepository.findAll());
    }

    @Override
    public Response findById() {
        return null;
    }
}
