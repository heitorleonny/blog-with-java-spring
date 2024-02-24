package github.io.heitorleonny.blog.services;

import github.io.heitorleonny.blog.models.PostModel;
import github.io.heitorleonny.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostModel> findAll(){
        return postRepository.findAll();
    }

    public Optional<PostModel> findById(UUID id){
        return postRepository.findById(id);
    }

    public PostModel savePost(PostModel postModel){
        return postRepository.save(postModel);
    }

    public Optional<PostModel> getPostById(UUID postId) {
        return postRepository.findById(postId);
    }

}
