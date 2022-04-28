package api.tests.models.request.listener;

import java.util.List;

import api.tests.models.request.login.LoginBody;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

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
	@JsonTypeId
	private int id;
	@JsonProperty("connectAddresses")
	private List<String> connectAddresses;
	@JsonProperty("status")
	private String status;

	public static HttpListenerBody getInstance(String covenantToken)
	{
		return HttpListenerBody.builder()
				.useSSL(false)
				.urls(List.of("http://192.168.1.69:80"))
				.id(builder().id)
				.name("testName")
				.guid("fdvzdvsdv")
				.description("testDescription")
				.bindAddress("0.0.0.0")
				.bindPort(81)
				.connectAddresses(List.of("192.168.1.69"))
				.connectPort(80)
				.profileId(1)
				.profile(Profile.getInstance())
				.listenerTypeId(1)
				.listenerType(ListenerType.getInstance())
				.status("active")
				.covenantUrl("https://localhost:7443")
				.covenantToken(covenantToken)
				.startTime("2022-04-24T14:33:08.216Z")
				.build();
	}
}