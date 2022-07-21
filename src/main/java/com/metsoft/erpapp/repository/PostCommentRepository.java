package com.metsoft.erpapp.repository;

import com.metsoft.erpapp.model.dbModel.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment,Integer> {
    @Query("select count(post.id) from PostComment where  post.id=?1")
    int countByPostId(int postId);

    List<PostComment> findByPostId(int id);
}
