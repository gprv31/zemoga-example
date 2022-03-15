package com.example.zemoga.application.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "zemoga.twitter-configuration")
@Getter
@Setter
public class TwitterValuesProperties {
  private String apiKey;
  private String secretKey;
  private String accessToken;
  private String secretToken;
}
