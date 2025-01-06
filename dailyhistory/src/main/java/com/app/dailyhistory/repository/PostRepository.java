package com.app.dailyhistory.repository;

import com.app.dailyhistory.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post searchPostByTagType(String tagType);


}
