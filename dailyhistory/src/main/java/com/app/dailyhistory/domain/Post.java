package com.app.dailyhistory.domain;

import com.app.dailyhistory.DTOS.PostDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Table(name = "posts")
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private String description;
    private Integer numberOfLikes;
    @Enumerated(EnumType.STRING)
    private TagType tagType;

    public Post(){

    }

    public Post(Long id, String title, String description, Integer numberOfLikes, TagType tagType) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.numberOfLikes = numberOfLikes;
        this.tagType = tagType;
    }


    public Post (PostDTO data){

     this.title = data.title();
     this.description = data.description();
     this.numberOfLikes = data.numberOfLikes();
     this.tagType = data.tagType();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Integer numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public TagType getTagType() {
        return tagType;
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }
}
