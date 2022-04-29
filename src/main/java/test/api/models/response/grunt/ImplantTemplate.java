package test.api.models.response.grunt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImplantTemplate{
	@JsonProperty("compatibleDotNetVersions")
	private List<String> compatibleDotNetVersions;
	@JsonProperty("implantDirection")
	private String implantDirection;
	@JsonProperty("compatibleListenerTypes")
	private List<Object> compatibleListenerTypes;
	@JsonProperty("stagerCode")
	private String stagerCode;
	@JsonProperty("commType")
	private String commType;
	@JsonProperty("executorCode")
	private String executorCode;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("language")
	private String language;
	@JsonProperty("id")
	private int id;
}