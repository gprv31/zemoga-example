package com.example.zemoga.application.configuration;

import com.example.zemoga.adapter.input.web.converter.response.UserInformationRestResponseConverter;
import com.example.zemoga.adapter.input.web.converter.response.UserTimeLineRestResponseConverter;
import com.example.zemoga.adapter.model.UserInformationRestResponse;
import com.example.zemoga.adapter.model.UserTimeLineRestResponse;
import com.example.zemoga.domain.interactor.GetUserInformationUseCaseImpl;
import com.example.zemoga.domain.port.input.GetUserInformationUseCase;
import com.example.zemoga.domain.port.output.PortfolioPort;
import com.example.zemoga.domain.port.output.TwitterApiPort;
import com.example.zemoga.entity.TwitterTimeLine;
import com.example.zemoga.entity.response.UserInformationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class ControllerConfiguration {

  /* Response Converter Beans Injection */
  @Bean
  public Function<UserInformationResponse, UserInformationRestResponse> userInformationRestResponseConverter(
    Function<TwitterTimeLine, UserTimeLineRestResponse> userTimeLineRestResponseConverter) {
    return new UserInformationRestResponseConverter(userTimeLineRestResponseConverter);
  }

  @Bean
  public Function<TwitterTimeLine, UserTimeLineRestResponse> userTimeLineRestResponseConverter() {
    return new UserTimeLineRestResponseConverter();
  }

  /* UseCase Beans Injection */
  @Bean
  public GetUserInformationUseCase getUserInformationUseCase(PortfolioPort portfolioPort,
                                                             TwitterApiPort twitterApiPort) {
    return new GetUserInformationUseCaseImpl(portfolioPort, twitterApiPort);
  }
}
