package api.tests.models.response.listener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpRequestHeadersItem{

	public HttpRequestHeadersItem() {
		super();
	}

	@JsonProperty("name")
	String name;
	@JsonProperty("value")
	String value;
}