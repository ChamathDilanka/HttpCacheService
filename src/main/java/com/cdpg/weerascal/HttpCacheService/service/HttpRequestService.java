package com.cdpg.weerascal.HttpCacheService.service;

import org.springframework.stereotype.Service;

import com.cdpg.weerascal.HttpCacheService.persistence.model.HttpRequestModel;

/**
 * Service class.
 */

@Service
public interface HttpRequestService {

  /**
   * Create data.
   */
	public HttpRequestModel createHttpRequest(HttpRequestModel httpRequest);

	/**
   * Fetch data.
   */
	public HttpRequestModel getHttpRequest(long id);
	
	/**
   * Check key is already in use. Return true if yes; else false.
   */
	public boolean keyExists(long key);
}
