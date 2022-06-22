package com.metsoft.erpapp.repository;

import com.metsoft.erpapp.model.dbModel.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike,Integer> {
}
