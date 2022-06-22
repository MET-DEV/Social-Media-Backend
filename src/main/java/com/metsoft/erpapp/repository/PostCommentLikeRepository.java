package com.metsoft.erpapp.repository;

import com.metsoft.erpapp.model.dbModel.PostCommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentLikeRepository extends JpaRepository<PostCommentLike,Integer> {
}
