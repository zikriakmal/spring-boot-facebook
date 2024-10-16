package com.zikriakmal.apifb.service;

import com.zikriakmal.apifb.dto.PostRequest;
import com.zikriakmal.apifb.dto.PostResponse;
import com.zikriakmal.apifb.dto.UserResponse;
import com.zikriakmal.apifb.entity.Post;
import com.zikriakmal.apifb.entity.User;
import com.zikriakmal.apifb.repository.PostRepository;
import com.zikriakmal.apifb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public PostResponse createPost(PostRequest postRequest, UserResponse userResponse) {
        User user = userRepository.findById(userResponse.getId());

        Post post = new Post();
        post.setUser(user);
        post.setPost(postRequest.getPost());
        post.setCreatedAt(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        post.setUpdatedAt(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        Post postResult = postRepository.save(post);

        return convertToPostResponse(postResult);
    }

    public List<PostResponse> getAllPost() {
        List<Post> allUserPost = postRepository.findAllByOrderByIdDesc();

        return allUserPost.stream()
                .map(this::convertToPostResponse)
                .collect(Collectors.toList());
    }

    public boolean deletePost(Integer postId, Integer authId) {

        Post findId = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
        if (Objects.equals(findId.getUser().getId(), authId)) {
            postRepository.deleteById(postId);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
        return true;
    }

    public List<PostResponse> getMyPosts(UserResponse userResponse) {
        List<Post> allUserPost = postRepository.findAllByUserId(userResponse.getId());
        return allUserPost.stream()
                .map(this::convertToPostResponse)
                .collect(Collectors.toList());
    }

    private PostResponse convertToPostResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .post(post.getPost())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .FormattedUpdatedAtDifference(post.getFormattedUpdatedAtDifference())
                .user(UserResponse.builder()
                        .id(post.getUser().getId())
                        .name(post.getUser().getName())
                        .username(post.getUser().getUsername())
                .build())
                .build();
    }
}
