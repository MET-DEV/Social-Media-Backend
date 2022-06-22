package com.metsoft.erpapp.repository;

import com.metsoft.erpapp.model.dbModel.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage,Integer> {

}
