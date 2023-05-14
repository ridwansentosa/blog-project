package com.ridwansentosa.blog.service;

import com.ridwansentosa.blog.payload.PostDto;
import com.ridwansentosa.blog.payload.PostResponse;

import java.util.*;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> getPostsByCategory(Long categoryId);
}
