package com.metsoft.erpapp.service.impls;

import com.metsoft.erpapp.model.dbModel.Post;
import com.metsoft.erpapp.repository.PostRepository;
import com.metsoft.erpapp.service.interfaces.PostService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Response save(Post post) {
        postRepository.save(post);
        return new SuccessResponse(true,"Post Saved");
    }

    @Override
    public Response update(Post post) {
        return null;
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<Post>>(true,"Posts Listed",postRepository.findAll());
    }

    @Override
    public Response findById() {
        return null;
    }
}
