package test.api.models.response.listener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpResponseHeadersItem{

	public HttpResponseHeadersItem() {
		super();
	}

	@JsonProperty("name")
	String name;
	@JsonProperty("value")
	String value;
}