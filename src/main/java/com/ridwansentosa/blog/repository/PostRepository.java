package com.ridwansentosa.blog.repository;

import com.ridwansentosa.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByCategoryId(Long categoryId);

}
