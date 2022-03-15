package com.example.zemoga.adapter.output.db.repository;

import com.example.zemoga.adapter.output.db.entity.BriefcaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BriefcaseRepository extends CrudRepository<BriefcaseEntity, Integer> {
  Optional<BriefcaseEntity> findByUserTwitter(String userTwitter);
}
