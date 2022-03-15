package com.example.zemoga.adapter.input.web;

import com.example.zemoga.adapter.model.UserInformationRestResponse;
import com.example.zemoga.domain.port.input.GetUserInformationUseCase;
import com.example.zemoga.entity.response.UserInformationResponse;
import io.reactivex.rxjava3.core.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@Tag(name = "Users GET", description = "Users GET methods Controller")
public class PortfolioGetController {

  private final GetUserInformationUseCase getUserInformationUseCase;

  private final Function<UserInformationResponse, UserInformationRestResponse> userInformationRestResponseConverter;

  /**
   * Get all user information by filter.
   *
   * @param  {@link Object}
   * @return {@link Object}
   *
   */
  @GetMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
  @Operation(summary = "Get User info", description = "Get user information")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation",
      content = {@Content(schema = @Schema(implementation = Object.class))})
  })
  public Single<UserInformationRestResponse> getUserInformation(
      @RequestParam(name = "userTwitter", defaultValue = "unnamed")
      String userTwitter) {
    log.info("Starting PortfolioGetController.getUserInformation method");
    return getUserInformationUseCase.getUserInformation(userTwitter)
      .map(userInformationRestResponseConverter::apply)
      .doOnSuccess(i -> log.info("Finished PortfolioGetController.getUserInformation method"))
      .doOnError(e -> log.error("Finished PortfolioGetController.getUserInformation method with error", e));
  }
}
