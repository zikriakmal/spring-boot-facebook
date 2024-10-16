package com.zikriakmal.apifb.controller;

import com.zikriakmal.apifb.dto.PostRequest;
import com.zikriakmal.apifb.dto.PostResponse;
import com.zikriakmal.apifb.dto.UserResponse;
import com.zikriakmal.apifb.dto.WebResponse;
import com.zikriakmal.apifb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(
            path = "/api/v1/posts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<PostResponse> createPost(@RequestBody PostRequest postRequest, UserResponse userResponse){
        PostResponse postResult =  postService.createPost(postRequest,userResponse);
        return WebResponse.<PostResponse>builder().data(postResult).build();
    }

    @DeleteMapping(
            path = "/api/v1/posts/{postId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Boolean> deletePost(@PathVariable Integer postId, UserResponse userResponse){
        boolean postDelete = postService.deletePost(postId,userResponse.getId());
        return WebResponse.<Boolean>builder().data(postDelete).build();
    }

    @GetMapping(
            path = "api/v1/posts",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<PostResponse>> getAllPost(UserResponse userResponse){
        List<PostResponse> allPostResult = postService.getAllPost();
        return WebResponse.<List<PostResponse>>builder().data(allPostResult).build();
    }

}
