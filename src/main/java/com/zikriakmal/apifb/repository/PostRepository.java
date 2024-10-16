package com.zikriakmal.apifb.repository;

import com.zikriakmal.apifb.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByOrderByIdDesc();
    List<Post> findAllByUserId(Integer userId);

}
