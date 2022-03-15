package com.example.zemoga.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInfo {
  private String name;
  private String lastName;
  private String pathImage;
  private String description;
  private String userTwitter;
}
