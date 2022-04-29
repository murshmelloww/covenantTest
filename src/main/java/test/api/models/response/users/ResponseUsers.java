package test.api.models.response.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseUsers{
	@JsonProperty("emailConfirmed")
	private boolean emailConfirmed;
	@JsonProperty("normalizedUserName")
	private String normalizedUserName;
	@JsonProperty("lockoutEnabled")
	private boolean lockoutEnabled;
	@JsonProperty("themeId")
	private int themeId;
	@JsonProperty("normalizedEmail")
	private String normalizedEmail;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("passwordHash")
	private String passwordHash;
	@JsonProperty("phoneNumberConfirmed")
	private boolean phoneNumberConfirmed;
	@JsonProperty("twoFactorEnabled")
	private boolean twoFactorEnabled;
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	@JsonProperty("theme")
	private Object theme;
	@JsonProperty("id")
	private String id;
	@JsonProperty("accessFailedCount")
	private int accessFailedCount;
	@JsonProperty("concurrencyStamp")
	private String concurrencyStamp;
	@JsonProperty("email")
	private String email;
	@JsonProperty("securityStamp")
	private String securityStamp;
	@JsonProperty("lockoutEnd")
	private String lockoutEnd;

	public ResponseUsers() {
		super();
	}

}
