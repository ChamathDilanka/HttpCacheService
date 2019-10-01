package com.cdpg.weerascal.HttpCacheService.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity class used in persist layer.
 */

@Entity
public class HttpRequestModel implements Serializable {

	private static final long serialVersionUID = 178294698246982762L;

	@Id
	private long id;
	private String jsonMessage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJsonMessage() {
		return jsonMessage;
	}

	public void setJsonMessage(String jsonMessage) {
		this.jsonMessage = jsonMessage;
	}

}
