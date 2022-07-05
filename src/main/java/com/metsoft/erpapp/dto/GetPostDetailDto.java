package com.metsoft.erpapp.dto;

import com.metsoft.erpapp.model.dbModel.PostComment;
import com.metsoft.erpapp.model.dbModel.PostImage;
import com.metsoft.erpapp.model.dbModel.PostLike;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetPostDetailDto {
    private int id;
    private List<PostComment> postComments;
    private LocalDateTime date;
    private String username;
    private List<PostLike> postLikes;
    private List<PostImage> postImage;
}
