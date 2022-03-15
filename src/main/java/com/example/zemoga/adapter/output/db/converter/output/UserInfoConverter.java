package com.example.zemoga.adapter.output.db.converter.output;

import com.example.zemoga.adapter.output.db.entity.BriefcaseEntity;
import com.example.zemoga.entity.UserInfo;

import java.util.function.Function;

public class UserInfoConverter implements Function<BriefcaseEntity, UserInfo> {

  @Override
  public UserInfo apply(BriefcaseEntity briefcaseEntity) {
    if (briefcaseEntity == null) {
      return null;
    }
    return UserInfo.builder()
      .name(briefcaseEntity.getName())
      .lastName(briefcaseEntity.getLastName())
      .description(briefcaseEntity.getDescription())
      .pathImage(briefcaseEntity.getPathImage())
      .userTwitter(briefcaseEntity.getUserTwitter()).build();
  }
}
