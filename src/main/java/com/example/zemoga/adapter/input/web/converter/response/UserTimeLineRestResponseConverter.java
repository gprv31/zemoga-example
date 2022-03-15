package com.example.zemoga.adapter.input.web.converter.response;

import com.example.zemoga.adapter.model.UserTimeLineRestResponse;
import com.example.zemoga.entity.TwitterTimeLine;

import java.util.function.Function;

public class UserTimeLineRestResponseConverter implements Function<TwitterTimeLine, UserTimeLineRestResponse> {

  @Override
  public UserTimeLineRestResponse apply(TwitterTimeLine twitterTimeLine) {
    if (twitterTimeLine == null) {
      return null;
    }
    return UserTimeLineRestResponse.builder()
      .id(twitterTimeLine.getId())
      .created(twitterTimeLine.getCreated())
      .location(twitterTimeLine.getLocation())
      .name(twitterTimeLine.getName())
      .profileImageUrl(twitterTimeLine.getProfileImageUrl())
      .profileImageUrlHttps(twitterTimeLine.getProfileImageUrlHttps())
      .screenName(twitterTimeLine.getScreenName())
      .text(twitterTimeLine.getText())
      .build();
  }
}
