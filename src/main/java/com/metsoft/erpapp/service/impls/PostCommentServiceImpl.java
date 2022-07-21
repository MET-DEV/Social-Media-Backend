package com.metsoft.erpapp.service.impls;

import com.metsoft.erpapp.dto.GetPostCommentDto;
import com.metsoft.erpapp.dto.SavePostCommentDto;

import com.metsoft.erpapp.model.dbModel.PostComment;

import com.metsoft.erpapp.repository.PostCommentRepository;
import com.metsoft.erpapp.service.interfaces.PostCommentService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostCommentServiceImpl implements PostCommentService {
    private PostCommentRepository postCommentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PostCommentServiceImpl(PostCommentRepository postCommentRepository, ModelMapper modelMapper) {
        this.postCommentRepository = postCommentRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public Response findByPostId(int id) {
        List<PostComment> comments=postCommentRepository.findByPostId(id);
        List<GetPostCommentDto>postComments=postCommentToPostCommentDto(comments);
        return new SuccessDataResponse<>(true,"Comment listed for id",postComments);
    }

    @Override
    public int getPostCommentCount(int postId) {
        return postCommentRepository.countByPostId(postId);
    }











    private List<GetPostCommentDto> postCommentToPostCommentDto(List<PostComment> postComments){
        List<GetPostCommentDto> postCommentDtos=postComments.stream().map(postComment ->modelMapper.map(postComment,GetPostCommentDto.class) ).collect(Collectors.toList());
        return postCommentDtos;

    }
}



