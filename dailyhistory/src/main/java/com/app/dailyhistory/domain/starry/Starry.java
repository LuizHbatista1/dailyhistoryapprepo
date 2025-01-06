package com.app.dailyhistory.domain.starry;

import com.app.dailyhistory.DTOS.StarryDTO;
import com.app.dailyhistory.domain.post.Post;
import jakarta.persistence.*;

@Table(name = "starry")
@Entity(name = "starry")
public class Starry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    @JoinColumn(name = "post_id")
    private Post postId;

    public Starry (){

    }

    public Starry(Long id, Post postId) {
        this.id = id;
        this.postId = postId;
    }

    public Starry (StarryDTO data){

        this.postId = postId;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }
}
