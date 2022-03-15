package com.example.zemoga.domain.port.output;

import com.example.zemoga.entity.UserInfo;
import io.reactivex.rxjava3.core.Single;

public interface PortfolioPort {
  Single<UserInfo> getPortfolioInformation(String userTwitter);
}
