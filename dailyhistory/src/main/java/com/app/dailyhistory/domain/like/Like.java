package com.app.dailyhistory.domain.like;

import com.app.dailyhistory.DTOS.LikeDTO;
import com.app.dailyhistory.domain.post.Post;
import jakarta.persistence.*;

@Table(name = "likes")
@Entity(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    @JoinColumn(name = "post_id")
    private Post postId;

    public Like (){

    }

    public Like(Long id, Post postId) {
        this.id = id;
        this.postId = postId;
    }

    public Like(LikeDTO data){

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
