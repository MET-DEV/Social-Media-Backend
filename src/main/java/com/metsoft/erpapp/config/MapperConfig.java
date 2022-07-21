package com.metsoft.erpapp.config;

import com.metsoft.erpapp.dto.GetPostCommentDto;
import com.metsoft.erpapp.dto.GetPostDetailDto;
import com.metsoft.erpapp.dto.GetPostDto;
import com.metsoft.erpapp.model.dbModel.Post;
import com.metsoft.erpapp.model.dbModel.PostComment;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        modelMapper.addMappings(new PropertyMap<Post, GetPostDto>() {

            @Override
            protected void configure() {
                map().setPostImage(source.getPostImages());
                map().setUserName(source.getUser().getUsername());
                map().setId(source.getId());
                map().setCommentCount(12);
                map().setLikeCount(12);
                map().setFirstName(source.getUser().getFirstName());
                map().setLastName(source.getUser().getLastName());

            }
        }).validate();
        modelMapper.addMappings(new PropertyMap<Post, GetPostDetailDto>() {
            @Override
            protected void configure() {
                map().setPostImage(source.getPostImages());
                map().setUsername(source.getUser().getUsername());
                map().setId(source.getId());
                map().setPostComments(source.getPostComments());
                map().setPostLikes(source.getPostLikes());
                map().setDate(source.getCreationDate());
            }
        }).validate();

        modelMapper.addMappings(new PropertyMap<PostComment, GetPostCommentDto>() {
            @Override
            protected void configure() {
              map().setComment(source.getCommentMessage());
              map().setCommentLike(12);
              map().setPostId(source.getPost().getId());
              map().setDate(source.getDate());
              map().setUserName(source.getUser().getUsername());
              map().setFirstName(source.getUser().getFirstName());
              map().setLastName(source.getUser().getLastName());
            }
        }).validate();
        return modelMapper;
    }
}
