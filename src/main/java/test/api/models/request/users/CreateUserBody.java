package test.api.models.request.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserBody {

	@JsonProperty("password")
	private String password;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("id")
	@JsonTypeId
	private int id;
	@JsonProperty("confirmPassword")
	private String confirmPassword;


	public static CreateUserBody getInstance(String userName, String password)
	{
		return CreateUserBody.builder()
				.id(builder().id)
				.password(password)
				.confirmPassword(password)
				.userName(userName)
				.build();
	}
}