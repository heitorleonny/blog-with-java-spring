package github.io.heitorleonny.blog.controllers;

import github.io.heitorleonny.blog.dtos.PostModelDTO;
import github.io.heitorleonny.blog.models.PostModel;
import github.io.heitorleonny.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostModel> findAll(){
        return postService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<PostModel> findById(@PathVariable(value = "id") UUID id){
        return postService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostModel savePost(@RequestBody PostModelDTO postRequest){
        PostModel postModel = new PostModel();
        postModel.setPostTitle(postRequest.getPostTitle());
        postModel.setPostDescription(postRequest.getPostDescription());
        postModel.setPostAuthor(postRequest.getPostAuthor());
        postService.savePost(postModel);
        return postModel;

    }

    @PutMapping(value = "/{postId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostModel> updatePost(@PathVariable UUID postId, @RequestBody PostModelDTO postRequest) {
        Optional<PostModel> existingPost = postService.getPostById(postId);

        if (existingPost.isPresent()) {
            PostModel updatedPost = existingPost.get();
            updatedPost.setPostTitle(postRequest.getPostTitle());
            updatedPost.setPostDescription(postRequest.getPostDescription());
            updatedPost.setPostAuthor(postRequest.getPostAuthor());

            postService.savePost(updatedPost);

            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
