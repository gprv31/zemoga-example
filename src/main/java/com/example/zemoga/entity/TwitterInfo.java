package com.example.zemoga.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TwitterInfo {
  private List<TwitterTimeLine> timeLineList;
}
