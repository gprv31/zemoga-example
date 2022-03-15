package com.example.zemoga.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TwitterTimeLine {
  private Long id;
  private LocalDateTime created;
  private String text;
  private String name;
  private String screenName;
  private String location;
  private String profileImageUrl;
  private String profileImageUrlHttps;

}
