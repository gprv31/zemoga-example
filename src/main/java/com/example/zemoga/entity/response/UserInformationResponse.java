package com.example.zemoga.entity.response;

import com.example.zemoga.entity.TwitterTimeLine;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserInformationResponse {
  private String name;
  private String lastName;
  private String description;
  private String userTwitter;
  private List<TwitterTimeLine> timeLineList;
}
