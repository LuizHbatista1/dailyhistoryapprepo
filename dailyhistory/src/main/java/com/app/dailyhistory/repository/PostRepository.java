package com.app.dailyhistory.repository;

import com.app.dailyhistory.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post searchPostByTagType(String tagType);


}
