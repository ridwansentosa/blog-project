package com.ridwansentosa.blog.repository;

import com.ridwansentosa.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostId(long postId);
}
