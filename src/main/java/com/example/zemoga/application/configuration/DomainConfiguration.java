package com.example.zemoga.application.configuration;

import com.example.zemoga.adapter.output.db.PortfolioPortImpl;
import com.example.zemoga.adapter.output.db.converter.output.UserInfoConverter;
import com.example.zemoga.adapter.output.db.entity.BriefcaseEntity;
import com.example.zemoga.adapter.output.db.repository.BriefcaseRepository;
import com.example.zemoga.adapter.output.http.TwitterApiPortImpl;
import com.example.zemoga.application.properties.TwitterValuesProperties;
import com.example.zemoga.domain.port.output.PortfolioPort;
import com.example.zemoga.domain.port.output.TwitterApiPort;
import com.example.zemoga.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;

@Slf4j
@Configuration
public class DomainConfiguration {


  /* Output Converter Beans Injection */

  @Bean
  public UserInfoConverter userInfoConverter() {
    return new UserInfoConverter();
  }

  /* Port Beans Injection */
  @Bean
  public PortfolioPort portfolioPort(BriefcaseRepository briefcaseRepository,
                                     Function<BriefcaseEntity, UserInfo> userInfoConverter) {
    return new PortfolioPortImpl(briefcaseRepository, userInfoConverter);
  }

  @Bean
  public TwitterApiPort twitterApiPort(TwitterValuesProperties twitterValuesProperties) {
    return new TwitterApiPortImpl(twitterValuesProperties);
  }
}
