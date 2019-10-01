package com.cdpg.weerascal.HttpCacheService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdpg.weerascal.HttpCacheService.persistence.model.HttpRequestModel;
import com.cdpg.weerascal.HttpCacheService.persistence.repository.HttpRequestRepository;
import com.cdpg.weerascal.HttpCacheService.service.HttpRequestService;

/**
 * Service Impl class.
 */

@Service
public class HttpRequestServiceImpl implements HttpRequestService
{

  @Autowired
  HttpRequestRepository httpRequestRepository;

  /**
   * Create data.
   */
  @Override
  public HttpRequestModel createHttpRequest(HttpRequestModel httpRequest)
  {
    httpRequestRepository.save(httpRequest);
    return httpRequest;
  }

  /**
   * Fetch data.
   */
  @Override
  public HttpRequestModel getHttpRequest(long id)
  {
    return httpRequestRepository.findById(id);
  }

  /**
   * Check key is already in use. Return true if yes; else false.
   */
  @Override
  public boolean keyExists(long key)
  {
    return httpRequestRepository.existsById(key);
  }

}
