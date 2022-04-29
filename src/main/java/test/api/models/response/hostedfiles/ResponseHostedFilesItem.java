package test.api.models.response.hostedfiles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHostedFilesItem{
	public ResponseHostedFilesItem() {
		super();
	}
	@JsonProperty("listenerId")
	private int listenerId;
	@JsonProperty("path")
	private String path;
	@JsonProperty("id")
	private int id;
	@JsonProperty("content")
	private String content;
}