package com.metsoft.erpapp.api.controller;

import com.metsoft.erpapp.model.dbModel.PostComment;
import com.metsoft.erpapp.service.interfaces.PostCommentService;
import com.metsoft.erpapp.service.responseModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/postcomments/")
public class PostCommetsController {
    private PostCommentService postCommentService;

    @Autowired
    public PostCommetsController(PostCommentService postCommentService) {
        this.postCommentService = postCommentService;
    }

    @GetMapping("")
    public Response findAll(){
        return postCommentService.findAll();
    }
    @PostMapping
    public Response save(@RequestBody PostComment postComment){
        return postCommentService.save(postComment);
    }
}
