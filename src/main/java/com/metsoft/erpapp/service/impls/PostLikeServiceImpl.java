package com.metsoft.erpapp.service.impls;

import com.metsoft.erpapp.dto.SavePostLikeDto;
import com.metsoft.erpapp.model.dbModel.PostLike;
import com.metsoft.erpapp.repository.PostLikeRepository;
import com.metsoft.erpapp.service.interfaces.PostLikeService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLikeServiceImpl implements PostLikeService {
    private PostLikeRepository postLikeRepository;

    @Autowired
    public PostLikeServiceImpl(PostLikeRepository postLikeRepository) {
        this.postLikeRepository = postLikeRepository;
    }

    @Override
    public Response save(SavePostLikeDto savePostLikeDto) {
        PostLike postLike=savePostLikeDto.savePostDtoToPostLike(savePostLikeDto);
        postLikeRepository.save(postLike);
        return new SuccessResponse(true,"Post Liked");
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response update(PostLike postLike) {
        return null;
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<PostLike>>(true,"Likes Listed",postLikeRepository.findAll());
    }

    @Override
    public Response findById() {
        return null;
    }
}
