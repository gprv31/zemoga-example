package com.example.zemoga.adapter.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserTimeLineRestResponse {

  @Schema(description = "User id", example = "87642398372872", type = "integer")
  private Long id;

  @Schema(description = "Created Date", example = "Wed Jan 22 12:15:04 COT 2020", type = "string")
  private LocalDateTime created;

  @Schema(description = "Tweet Text", example = "A simple tweet", type = "string")
  private String text;

  @Schema(description = "User Name", example = "John", type = "string")
  private String name;

  @Schema(description = "Screen Name", example = "John", type = "string")
  private String screenName;

  @Schema(description = "Location", example = "Canada", type = "string")
  private String location;

  @Schema(description = "Profile image url", example = "", type = "string")
  private String profileImageUrl;

  @Schema(description = "Profile image url https", example = "John", type = "string")
  private String profileImageUrlHttps;
}
