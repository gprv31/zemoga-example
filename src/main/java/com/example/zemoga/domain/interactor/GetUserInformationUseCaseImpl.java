package com.example.zemoga.domain.interactor;

import com.example.zemoga.domain.port.input.GetUserInformationUseCase;
import com.example.zemoga.domain.port.output.PortfolioPort;
import com.example.zemoga.domain.port.output.TwitterApiPort;
import com.example.zemoga.entity.TwitterInfo;
import com.example.zemoga.entity.TwitterTimeLine;
import com.example.zemoga.entity.UserInfo;
import com.example.zemoga.entity.response.UserInformationResponse;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GetUserInformationUseCaseImpl implements GetUserInformationUseCase {

  private final PortfolioPort portfolioPort;
  private final TwitterApiPort twitterApiPort;

  @Override
  public Single<UserInformationResponse> getUserInformation(String userTwitter) {
    log.info("Starting GetUserInformationUseCaseImpl.getUserInformation method");
    return portfolioPort.getPortfolioInformation(userTwitter)
      .map(this::toUserInformationResponse)
      .flatMap(userInformationResponse -> twitterApiPort.getUserInformation().map(twitterInfo -> {
        userInformationResponse.setTimeLineList(this.toTwitterTimeLine(twitterInfo));
        return userInformationResponse;
     }));
  }

  private UserInformationResponse toUserInformationResponse(UserInfo userInfo) {
    return UserInformationResponse.builder()
      .name(userInfo.getName())
      .lastName(userInfo.getLastName())
      .userTwitter(userInfo.getUserTwitter())
      .description(userInfo.getDescription())
      .build();
  }

  private List<TwitterTimeLine> toTwitterTimeLine(TwitterInfo twitterInfo) {
    List<TwitterTimeLine> timeLineList = new ArrayList<>();
    twitterInfo.getTimeLineList().forEach(twitterTimeLine ->
      timeLineList.add(TwitterTimeLine.builder()
          .id(twitterTimeLine.getId())
          .text(twitterTimeLine.getText())
          .screenName(twitterTimeLine.getScreenName())
          .profileImageUrlHttps(twitterTimeLine.getProfileImageUrlHttps())
          .profileImageUrl(twitterTimeLine.getProfileImageUrl())
          .location(twitterTimeLine.getLocation())
          .name(twitterTimeLine.getName())
          .created(twitterTimeLine.getCreated())
        .build()));
    return timeLineList;
  }
}
