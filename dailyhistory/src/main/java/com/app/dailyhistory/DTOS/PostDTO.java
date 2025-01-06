package com.app.dailyhistory.DTOS;

import com.app.dailyhistory.domain.post.TagType;

public record PostDTO (String title , String description , Integer numberOfLikes , TagType tagType){
}
