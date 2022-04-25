package api.tests.models.request.listener;

import java.util.List;

import api.tests.models.request.login.LoginBody;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class HttpListenerBody{

	@JsonProperty("bindPort")
	private int bindPort;
	@JsonProperty("listenerType")
	private ListenerType listenerType;
	@JsonProperty("covenantToken")
	private String covenantToken;
	@JsonProperty("profile")
	private Profile profile;
	@JsonProperty("description")
	private String description;
	@JsonProperty("connectPort")
	private int connectPort;
	@JsonProperty("bindAddress")
	private String bindAddress;
	@JsonProperty("useSSL")
	private boolean useSSL;
	@JsonProperty("urls")
	private List<String> urls;
	@JsonProperty("profileId")
	private int profileId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("guid")
	private String guid;
	@JsonProperty("listenerTypeId")
	private int listenerTypeId;
	@JsonProperty("covenantUrl")
	private String covenantUrl;
	@JsonProperty("startTime")
	private String startTime;
	@JsonProperty("id")
	private int id;
	@JsonProperty("connectAddresses")
	private List<String> connectAddresses;
	@JsonProperty("status")
	private String status;

	public static HttpListenerBody getInstance()
	{
		return HttpListenerBody.builder()
				.useSSL(false)
				.urls(List.of("http://192.168.1.69:80"))
				.id(6)
				.name("testName")
				.guid("fdvzdvsdv")
				.description("testDescription")
				.bindAddress("0.0.0.0")
				.bindPort(80)
				.connectAddresses(List.of("192.168.1.69"))
				.connectPort(80)
				.profileId(1)
				.profile(Profile.getInstance())
				.listenerTypeId(1)
				.listenerType(ListenerType.getInstance())
				.status("uninitialized")
				.covenantUrl("https://localhost:7443")
				.covenantToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI1ZGVkYTc4Ny0wMDk4LWEyNDQtM2EwOC1jYjE2MTFmYTYyMzYiLCJqdGkiOiIxODYxNGZlOS1jNGRkLTI2MzItNDk1ZS04NjQwNmVmZTg1ZjkiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjExYmY1MGZlLWQxZDQtNDUyMS05M2Y0LTcwMTU3YzkxNTA5ZSIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6Ikxpc3RlbmVyIiwiZXhwIjoxODIzNjA5ODMwLCJpc3MiOiJDb3ZlbmFudCIsImF1ZCI6IkNvdmVuYW50In0._RTvkt3j1vowRl-_GrTy6BSwVwDahU632MB5sHYx9O8")
				.startTime("2022-04-24T14:33:08.216Z")
				.build();
	}
}