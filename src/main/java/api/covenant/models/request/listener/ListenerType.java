package test.api.covenant.models.request.listener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class ListenerType{
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("id")
	private int id;

	public static ListenerType getInstance() {
		return ListenerType.builder()
				.id(1)
				.name("HTTP")
				.description("cxfgxdfbFDJYGK")
				.build();
	}
}