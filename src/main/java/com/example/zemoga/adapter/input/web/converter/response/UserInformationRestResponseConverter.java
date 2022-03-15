package com.example.zemoga.adapter.input.web.converter.response;

import com.example.zemoga.adapter.model.UserInformationRestResponse;
import com.example.zemoga.adapter.model.UserTimeLineRestResponse;
import com.example.zemoga.entity.TwitterTimeLine;
import com.example.zemoga.entity.response.UserInformationResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserInformationRestResponseConverter implements Function<UserInformationResponse, UserInformationRestResponse> {

  private final Function<TwitterTimeLine, UserTimeLineRestResponse> userTimeLineRestResponseConverter;

  @Override
  public UserInformationRestResponse apply(UserInformationResponse userInformationResponse) {
    if (userInformationResponse == null) {
      return null;
    }
    return UserInformationRestResponse.builder()
      .name(userInformationResponse.getName())
      .description(userInformationResponse.getDescription())
      .userTwitter(userInformationResponse.getUserTwitter())
      .timeLineList(buildUserTimeLineRestResponseList(userInformationResponse.getTimeLineList()))
      .build();
  }

  private List<UserTimeLineRestResponse> buildUserTimeLineRestResponseList(List<TwitterTimeLine> twitterTimeLineList) {
    return twitterTimeLineList.stream().map(userTimeLineRestResponseConverter::apply)
      .collect(Collectors.toList());

  }
}
