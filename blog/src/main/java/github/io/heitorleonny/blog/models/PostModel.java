package github.io.heitorleonny.blog.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_POST")
@Data
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID postId;
    @Column(name = "postTitle", nullable = false)
    String postTitle;
    @Column(name = "postDiscription")
    String postDescription;
    @Column(name = "postDate")
    LocalDate postDate = LocalDate.now();
    @Column(name = "postAuthor")
    String postAuthor;

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }


}
