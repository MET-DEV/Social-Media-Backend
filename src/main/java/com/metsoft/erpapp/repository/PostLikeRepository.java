package com.metsoft.erpapp.repository;

import com.metsoft.erpapp.model.dbModel.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike,Integer> {
    @Query("select count(post.id) from PostLike where  post.id=?1")
    int getPostLikeCountByPostId(int postId);
    PostLike getPostLikeByPostIdAndUserId(int postId,int userId);
    List<PostLike> getByPostId(int postId);
}
