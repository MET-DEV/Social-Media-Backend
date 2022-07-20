package com.metsoft.erpapp.dto;


import com.metsoft.erpapp.model.dbModel.PostImage;
import lombok.*;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPostDto {


    private int id;
    private String postMessage;
    private List<PostImage> postImage;
    private String userName;
    private String firstName;
    private String lastName;
    private int likeCount;
    private int commentCount;




}
