package com.example.zemoga.adapter.output.db;

import com.example.zemoga.adapter.output.db.entity.BriefcaseEntity;
import com.example.zemoga.adapter.output.db.repository.BriefcaseRepository;
import com.example.zemoga.domain.port.output.PortfolioPort;
import com.example.zemoga.entity.UserInfo;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
@AllArgsConstructor
public class PortfolioPortImpl implements PortfolioPort {

  private final BriefcaseRepository briefcaseRepository;

  private final Function<BriefcaseEntity, UserInfo> userInfoConverter;

  @Override
  public Single<UserInfo> getPortfolioInformation(String userTwitter) {
    log.info("Starting PortfolioPortImpl.getPortfolioInformation method");
    return Single.fromCallable(() -> userInfoConverter.apply(briefcaseRepository
      .findByUserTwitter(userTwitter).orElseThrow()));
  }
}
