package com.cdpg.weerascal.HttpCacheService.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdpg.weerascal.HttpCacheService.persistence.model.HttpRequestModel;

/**
 * JPA repository interface.
 */

@Repository
public interface HttpRequestRepository extends JpaRepository<HttpRequestModel, Long>
{
  public HttpRequestModel findById(long id);
}
