package test.api.models.response.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseLogin {

	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("covenantToken")
	private String covenantToken;

	public ResponseLogin() {
		super();
	}
}