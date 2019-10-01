package com.cdpg.weerascal.HttpCacheService.data;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "value" })

public class HttpRequestData
{
  @JsonProperty("id")
  private String id;

  @JsonProperty("value")
  private String value;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public Map<String, Object> getAdditionalProperties()
  {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties)
  {
    this.additionalProperties = additionalProperties;
  }

}
