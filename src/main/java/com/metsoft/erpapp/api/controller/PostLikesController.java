package com.metsoft.erpapp.api.controller;

import com.metsoft.erpapp.dto.SavePostLikeDto;
import com.metsoft.erpapp.model.dbModel.PostLike;
import com.metsoft.erpapp.service.interfaces.PostLikeService;
import com.metsoft.erpapp.service.responseModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/postlikes")
public class PostLikesController {
    private PostLikeService postLikeService;

    @Autowired
    public PostLikesController(PostLikeService postLikeService) {
        this.postLikeService = postLikeService;
    }
    @GetMapping("")
    public Response findAll(){
        return postLikeService.findAll();
    }
    @PostMapping("")
    public Response save(@RequestBody SavePostLikeDto savePostLikeDto){
        return postLikeService.save(savePostLikeDto);
    }
}
