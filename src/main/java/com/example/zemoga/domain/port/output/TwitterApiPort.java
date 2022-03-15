package com.example.zemoga.domain.port.output;

import com.example.zemoga.entity.TwitterInfo;
import io.reactivex.rxjava3.core.Single;

public interface TwitterApiPort {
  Single<TwitterInfo> getUserInformation();
}
