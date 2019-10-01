package com.cdpg.weerascal.HttpCacheService.service;

import org.springframework.stereotype.Service;

import com.cdpg.weerascal.HttpCacheService.persistence.model.HttpRequestModel;

@Service
public interface HttpRequestService {

	public HttpRequestModel createHttpRequest(HttpRequestModel httpRequest);

	public HttpRequestModel getHttpRequest(long id);
	
	public boolean keyExists(long key);
}
