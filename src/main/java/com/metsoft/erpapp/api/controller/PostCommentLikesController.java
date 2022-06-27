package com.metsoft.erpapp.api.controller;

import com.metsoft.erpapp.dto.SaveCommentLikeDto;
import com.metsoft.erpapp.service.interfaces.PostCommentLikeService;
import com.metsoft.erpapp.service.responseModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/postcommentlikes/")
public class PostCommentLikesController {
    private PostCommentLikeService postCommentLikeService;

    @Autowired
    public PostCommentLikesController(PostCommentLikeService postCommentLikeService) {
        this.postCommentLikeService = postCommentLikeService;
    }
    @GetMapping(name = "")
    public Response findAll(){
        return postCommentLikeService.findAll();
    }
    @PostMapping(name = "")
    public Response save(@RequestBody SaveCommentLikeDto commentLikeDto){
        return postCommentLikeService.save(commentLikeDto);
    }
}
