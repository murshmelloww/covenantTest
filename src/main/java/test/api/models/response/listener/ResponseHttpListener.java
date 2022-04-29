package test.api.models.response.listener;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHttpListener{
	@JsonProperty("bindPort")
	int bindPort;
	@JsonProperty("listenerType")
	ListenerType listenerType;
	@JsonProperty("covenantToken")
	String covenantToken;
	@JsonProperty("profile")
	Profile profile;
	@JsonProperty("description")
	String description;
	@JsonProperty("connectPort")
	int connectPort;
	@JsonProperty("bindAddress")
	String bindAddress;
	@JsonProperty("useSSL")
	boolean useSSL;
	@JsonProperty("urls")
	List<String> urls;
	@JsonProperty("sslCertificate")
	Object sslCertificate;
	@JsonProperty("sslCertHash")
	String sslCertHash;
	@JsonProperty("sslCertificatePassword")
	String sslCertificatePassword;
	@JsonProperty("profileId")
	int profileId;
	@JsonProperty("name")
	String name;
	@JsonProperty("guid")
	String guid;
	@JsonProperty("listenerTypeId")
	int listenerTypeId;
	@JsonProperty("covenantUrl")
	String covenantUrl;
	@JsonProperty("startTime")
	String startTime;
	@JsonProperty("id")
	int id;
	@JsonProperty("connectAddresses")
	List<String> connectAddresses;
	@JsonProperty("status")
	String status;

	public ResponseHttpListener() {
		super();
	}
}