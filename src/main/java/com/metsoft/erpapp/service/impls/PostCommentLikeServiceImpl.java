package com.metsoft.erpapp.service.impls;

import com.metsoft.erpapp.dto.SaveCommentLikeDto;
import com.metsoft.erpapp.model.dbModel.PostCommentLike;
import com.metsoft.erpapp.repository.PostCommentLikeRepository;
import com.metsoft.erpapp.service.interfaces.PostCommentLikeService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentLikeServiceImpl implements PostCommentLikeService {
    private PostCommentLikeRepository postCommentLikeRepository;


    @Autowired
    public PostCommentLikeServiceImpl(PostCommentLikeRepository postCommentLikeRepository) {
        this.postCommentLikeRepository = postCommentLikeRepository;
    }


    @Override
    public Response save(SaveCommentLikeDto saveCommentLikeDto) {
        PostCommentLike postCommentLike=saveCommentLikeDto.saveCommentLikeDtoToPostCommentLike(saveCommentLikeDto);
         postCommentLikeRepository.save(postCommentLike);
        return new SuccessResponse(true,"Comment Liked");
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<PostCommentLike>>(true,"Listed Comment Like",postCommentLikeRepository.findAll());
    }

    @Override
    public Response findById() {
        return null;
    }
}
