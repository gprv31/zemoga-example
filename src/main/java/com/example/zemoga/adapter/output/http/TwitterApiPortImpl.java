package com.example.zemoga.adapter.output.http;

import com.example.zemoga.application.properties.TwitterValuesProperties;
import com.example.zemoga.domain.port.output.TwitterApiPort;
import com.example.zemoga.entity.TwitterInfo;
import com.example.zemoga.entity.TwitterTimeLine;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class TwitterApiPortImpl implements TwitterApiPort {

  private final TwitterValuesProperties twitterValuesProperties;

  @Override
  public Single<TwitterInfo> getUserInformation() {
    log.info("Starting TwitterApiPortImpl.getUserInformation method");
    return Single.fromCallable(() -> {
      ConfigurationBuilder cb = new ConfigurationBuilder();
      String accessToken = twitterValuesProperties.getAccessToken();
      cb.setDebugEnabled(true)
        .setOAuthConsumerKey(twitterValuesProperties.getApiKey())
        .setOAuthConsumerSecret(twitterValuesProperties.getSecretKey())
        .setOAuthAccessToken(accessToken)
        .setOAuthAccessTokenSecret(twitterValuesProperties.getSecretToken());
      TwitterFactory tf = new TwitterFactory(cb.build());
      Twitter twitter = tf.getInstance();
      try {
        String userId = accessToken.split("-")[0];
        List<Status> statuses = twitter.getUserTimeline(Long.parseLong(userId));
        List<TwitterTimeLine> timeLineList = new ArrayList<>();
        statuses.forEach(status -> timeLineList.add(TwitterTimeLine.builder()
          .id(status.getId())
          .created(status.getCreatedAt().toInstant()
            .atZone(ZoneId.systemDefault()).toLocalDateTime())
          .location(status.getUser().getLocation())
          .name(status.getUser().getName())
          .profileImageUrl(status.getUser().getProfileImageURL())
          .profileImageUrlHttps(status.getUser().getProfileImageURLHttps())
          .screenName(status.getUser().getScreenName())
          .text(status.getText())
          .build()));
        return TwitterInfo.builder().timeLineList(timeLineList).build();
      } catch (TwitterException e) {
        log.error("An error ocurred on TwitterApiPortImpl.getUserInformation", e);
        throw new Exception("An error ocurred on TwitterApiPortImpl.getUserInformation");
      }
    });
  }
}
