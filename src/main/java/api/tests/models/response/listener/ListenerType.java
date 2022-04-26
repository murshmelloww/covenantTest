package api.tests.models.response.listener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListenerType{

	public ListenerType() {
		super();
	}

	@JsonProperty("name")
	String name;
	@JsonProperty("description")
	String description;
	@JsonProperty("id")
	int id;
}