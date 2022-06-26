package com.metsoft.erpapp.service.impls;

import com.metsoft.erpapp.dto.SavePostCommentDto;

import com.metsoft.erpapp.model.dbModel.PostComment;

import com.metsoft.erpapp.repository.PostCommentRepository;
import com.metsoft.erpapp.service.interfaces.PostCommentService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService {
    private PostCommentRepository postCommentRepository;

    @Autowired
    public PostCommentServiceImpl(PostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }

    @Override
    public Response save(SavePostCommentDto savePostCommentDto) {
         PostComment  comment=savePostCommentDto.SavePostCommentDtoToPostComment(savePostCommentDto);
        postCommentRepository.save(comment);
        return new SuccessResponse(true,"Comment Added");
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response update(PostComment comment) {
        return null;
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<PostComment>>(true,"Comments Listed",postCommentRepository.findAll());
    }

    @Override
    public Response findById(int id) {
        return null;
    }
}
