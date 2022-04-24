package api.tests.models.response.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseLogin {

	@JsonProperty("success")
	private boolean success;
	@JsonProperty("covenantToken")
	private String covenantToken;
}