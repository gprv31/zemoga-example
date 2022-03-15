package com.example.zemoga.adapter.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserInformationRestResponse {

  @Schema(description = "User Twitter", example = "unnamed", type = "string")
  private String userTwitter;

  @Schema(description = "Name", example = "John", type = "string")
  private String name;

  @Schema(description = "Description", example = "A description", type = "string")
  private String description;

  @Schema(description = "Time Line List")
  private List<UserTimeLineRestResponse> timeLineList;


}
