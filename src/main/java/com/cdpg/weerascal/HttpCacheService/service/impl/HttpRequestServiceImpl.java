package com.cdpg.weerascal.HttpCacheService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdpg.weerascal.HttpCacheService.persistence.model.HttpRequestModel;
import com.cdpg.weerascal.HttpCacheService.persistence.repository.HttpRequestRepository;
import com.cdpg.weerascal.HttpCacheService.service.HttpRequestService;

@Service
public class HttpRequestServiceImpl implements HttpRequestService
{

  @Autowired
  HttpRequestRepository httpRequestRepository;

  @Override
  public HttpRequestModel createHttpRequest(HttpRequestModel httpRequest)
  {
    httpRequestRepository.save(httpRequest);
    return httpRequest;
  }

  @Override
  public HttpRequestModel getHttpRequest(long id)
  {
    return httpRequestRepository.findById(id);
  }

  @Override
  public boolean keyExists(long key)
  {
    return httpRequestRepository.existsById(key);
  }

}
