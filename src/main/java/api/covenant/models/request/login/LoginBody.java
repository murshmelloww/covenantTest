package test.api.covenant.models.request.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Builder;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class LoginBody{

	@JsonProperty("password")
	private String password;
	@JsonProperty("userName")
	private String userName;

	public static LoginBody getInstance(String userName, String password)
	{
		return LoginBody.builder()
				.password(password)
				.userName(userName)
				.build();
	}
}