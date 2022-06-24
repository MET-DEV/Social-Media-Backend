package com.metsoft.erpapp.api.controller;

import com.metsoft.erpapp.model.dbModel.Post;
import com.metsoft.erpapp.service.interfaces.PostService;
import com.metsoft.erpapp.service.responseModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/posts/")
public class PostsController {
    private PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public Response findAll(){
        return postService.findAll();
    }
    @PostMapping("")
    public Response save(@RequestBody Post post){
        return postService.save(post);
    }
}
