package com.metsoft.erpapp.service.impls;

import com.google.common.reflect.TypeToken;
import com.metsoft.erpapp.dto.GetPostDetailDto;
import com.metsoft.erpapp.dto.GetPostDto;
import com.metsoft.erpapp.dto.SavePostDto;
import com.metsoft.erpapp.model.dbModel.Post;
import com.metsoft.erpapp.repository.PostRepository;
import com.metsoft.erpapp.service.interfaces.PostCommentService;
import com.metsoft.erpapp.service.interfaces.PostLikeService;
import com.metsoft.erpapp.service.interfaces.PostService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ModelMapper modelMapper;
    private PostCommentService postCommentService;
    private PostLikeService postLikeService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, PostCommentService postCommentService, PostLikeService postLikeService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.postCommentService = postCommentService;
        this.postLikeService = postLikeService;
    }


    @Override
    public Response save(SavePostDto savePostDto) {
        Post post=savePostDto.savePostDtoToPost(savePostDto);
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
        List<GetPostDto> postDtos=getAsPostDto(postRepository.findAll());
        List<GetPostDto> postDtoswithLikeAndCommentCount=setPostLikeCountAndCommentCount(postDtos);
        return new SuccessDataResponse<List<GetPostDto>>(true,"Posts Listed",postDtoswithLikeAndCommentCount);
    }

    @Override
    public Response findById(int id) {
        Post post=postRepository.getById(id);
        GetPostDetailDto postDto=postToGetPostDto(post);
        return new SuccessDataResponse<GetPostDetailDto>(true,"Post getted by id",postDto);
    }







    // ! Sub methods for this class
    // * -----------------------------------------------------







    private GetPostDetailDto postToGetPostDto(Post post){
        GetPostDetailDto postDto=modelMapper.map(post,GetPostDetailDto.class);
        return  postDto;
    }



    // ? This method for "Post" to "GetPostDto" mapping
    private List<GetPostDto> getAsPostDto(List<Post> posts){;
        Type listType=new TypeToken<List<GetPostDto>>(){}.getType();
        List<GetPostDto> postDtos=  modelMapper.map(posts,listType);
       return postDtos;
    }

    // ? For Post comment count and post comment like adding to "GetPostDto" list
    private List<GetPostDto> setPostLikeCountAndCommentCount(List<GetPostDto> getPostDtos){
       List<GetPostDto> result=getPostDtos.stream().map(getPostDto -> {
            getPostDto.setCommentCount(postCommentService.getPostCommentCount(getPostDto.getId()));
            getPostDto.setLikeCount(postLikeService.getPostLikeByPostId(getPostDto.getId()));
            return getPostDto;
        }).collect(Collectors.toList());
        return result;
    }

}
