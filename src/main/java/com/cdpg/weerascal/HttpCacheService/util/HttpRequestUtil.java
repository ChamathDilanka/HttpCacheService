package com.cdpg.weerascal.HttpCacheService.util;

import org.springframework.web.client.RestTemplate;

import com.google.common.base.Strings;

/**
 * Utility class class.
 */

public class HttpRequestUtil
{
  /**
   * External service URL to fetch random IDs.
   */
  private static final String ID_GENERATOR_URL = "http://danielbayley.uk/nhs-number/api/NhsNumbers/GetNhsNumbers";

  private static final String SPLIT_CHARACTER = ",";

  private static final String SPACE = "\\s";

  private HttpRequestUtil()
  {
  }

  private static class HttpRequestUtilSingletonHolder
  {
    public static final HttpRequestUtil INSTANCE = new HttpRequestUtil();
  }

  public static HttpRequestUtil getInstance()
  {
    return HttpRequestUtilSingletonHolder.INSTANCE;
  }

  /**
   * Call external services and get set of random IDs.
   */
  String getNHSNumbers()
  {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(ID_GENERATOR_URL, String.class);
  }

  /**
   * Return a selected random number after removing spaces.
   */
  private String getRandomNHSNumber()
  {
    String result = getNHSNumbers();
    if (!Strings.isNullOrEmpty(result))
    {
      String refinedResutls = result.substring(1, (result.length() - 1));
      String[] ids = refinedResutls.split(SPLIT_CHARACTER);
      String refinedNHSNumber = ids[0].substring(1, (ids[0].length() - 1));
      return refinedNHSNumber.replaceAll(SPACE, "");
    }
    return null;
  }

  public String getNewID()
  {
    return getRandomNHSNumber();
  }
}
