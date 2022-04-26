package api.tests.models.response.listener;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile{
	@JsonProperty("httpRequestHeaders")
	List<HttpRequestHeadersItem> httpRequestHeaders;
	@JsonProperty("httpPostRequest")
	String httpPostRequest;
	@JsonProperty("messageTransform")
	String messageTransform;
	@JsonProperty("httpPostResponse")
	String httpPostResponse;
	@JsonProperty("httpResponseHeaders")
	List<HttpResponseHeadersItem> httpResponseHeaders;
	@JsonProperty("name")
	String name;
	@JsonProperty("description")
	String description;
	@JsonProperty("httpGetResponse")
	String httpGetResponse;
	@JsonProperty("id")
	int id;
	@JsonProperty("type")
	String type;
	@JsonProperty("httpUrls")
	List<String> httpUrls;

	public Profile() {
		super();
	}
}