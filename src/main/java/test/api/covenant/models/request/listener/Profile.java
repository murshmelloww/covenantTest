package test.api.covenant.models.request.listener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Profile{
	@JsonProperty("messageTransform")
	private String messageTransform;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("id")
	private int id;
	@JsonProperty("type")
	private String type;

	public static Profile getInstance() {
		return Profile.builder()
				.id(1)
				.name("DefaultHttpProfile")
				.description("DefaultHttpProfile")
				.type("HTTP")
				.messageTransform("public static class MessageTransform\\n{\\n    public static string Transform(byte[] bytes)\\n    {\\n        return System.Convert.ToBase64String(bytes);\\n    }\\n    public static byte[] Invert(string str) {\\n        return System.Convert.FromBase64String(str);\\n    }\\n}\\n")
				.build();
	}
}