package com.example.zemoga.domain.port.input;

import com.example.zemoga.entity.response.UserInformationResponse;
import io.reactivex.rxjava3.core.Single;

public interface GetUserInformationUseCase {
  Single<UserInformationResponse> getUserInformation(String userTwitter);
}
