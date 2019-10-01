package com.cdpg.weerascal.HttpCacheService.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdpg.weerascal.HttpCacheService.data.HttpRequestData;
import com.cdpg.weerascal.HttpCacheService.persistence.model.HttpRequestModel;
import com.cdpg.weerascal.HttpCacheService.service.HttpRequestService;
import com.cdpg.weerascal.HttpCacheService.util.HttpRequestUtil;
import com.google.common.base.Strings;
import com.google.gson.Gson;

@RestController
public class HttpRequestController
{

  @Autowired
  private HttpRequestService httpRequestService;

  @GetMapping(value = "/httprequest")
  public ResponseEntity<HttpRequestData> getHttpRequest(@RequestParam(value = "identifier") String identifier)
  {
    if (!Strings.isNullOrEmpty(identifier))
    {
      HttpRequestModel httpRequestModel = httpRequestService.getHttpRequest(Long.parseLong(identifier));
      Gson gson = new Gson();
      HttpRequestData data = gson.fromJson(httpRequestModel.getJsonMessage(), HttpRequestData.class);
      HttpHeaders responseHeader = new HttpHeaders();
      responseHeader.set("ID", data.getId());
      return new ResponseEntity<>(data, responseHeader, HttpStatus.FOUND);
    }
    return null;
  }

  @PostMapping(value = "/httprequest")
  public ResponseEntity<HttpRequestData> createHttpRequest(@RequestBody HttpRequestData httpRequestData)
  {
    if (httpRequestData != null && Strings.isNullOrEmpty(httpRequestData.getId()))
    {
      long newID = Long.parseLong(HttpRequestUtil.getInstance().getNewID());
      if (!httpRequestService.keyExists(newID))
      {
        HttpRequestModel httpRequestModel = new HttpRequestModel();
        httpRequestModel.setId(newID);
        httpRequestData.setId(String.format ("%d", httpRequestModel.getId()));
        JSONObject exampleModelJSON = new JSONObject(httpRequestData);
        httpRequestModel.setJsonMessage(exampleModelJSON.toString());
        httpRequestService.createHttpRequest(httpRequestModel);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("ID", httpRequestData.getId());
        return new ResponseEntity<>(httpRequestData, responseHeader, HttpStatus.CREATED);
      }
    }
    return null;
  }
}
