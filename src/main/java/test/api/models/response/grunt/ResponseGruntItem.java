package test.api.models.response.grunt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseGruntItem{

	@JsonProperty("note")
	private String note;
	@JsonProperty("gruntNegotiatedSessionKey")
	private String gruntNegotiatedSessionKey;
	@JsonProperty("gruntCommands")
	private List<Object> gruntCommands;
	@JsonProperty("gruntRSAPublicKey")
	private String gruntRSAPublicKey;
	@JsonProperty("killDate")
	private String killDate;
	@JsonProperty("listener")
	private Object listener;
	@JsonProperty("dotNetVersion")
	private String dotNetVersion;
	@JsonProperty("userDomainName")
	private String userDomainName;
	@JsonProperty("powerShellImport")
	private String powerShellImport;
	@JsonProperty("operatingSystem")
	private String operatingSystem;
	@JsonProperty("gruntChallenge")
	private String gruntChallenge;
	@JsonProperty("smbPipeName")
	private String smbPipeName;
	@JsonProperty("integrity")
	private String integrity;
	@JsonProperty("hostname")
	private String hostname;
	@JsonProperty("children")
	private List<Object> children;
	@JsonProperty("originalServerGuid")
	private String originalServerGuid;
	@JsonProperty("id")
	private int id;
	@JsonProperty("lastCheckIn")
	private String lastCheckIn;
	@JsonProperty("activationTime")
	private String activationTime;
	@JsonProperty("implantTemplate")
	private ImplantTemplate implantTemplate;
	@JsonProperty("implantTemplateId")
	private int implantTemplateId;
	@JsonProperty("process")
	private String process;
	@JsonProperty("ipAddress")
	private String ipAddress;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("connectAttempts")
	private int connectAttempts;
	@JsonProperty("runtimeIdentifier")
	private String runtimeIdentifier;
	@JsonProperty("validateCert")
	private boolean validateCert;
	@JsonProperty("listenerId")
	private int listenerId;
	@JsonProperty("delay")
	private int delay;
	@JsonProperty("gruntSharedSecretPassword")
	private String gruntSharedSecretPassword;
	@JsonProperty("jitterPercent")
	private int jitterPercent;
	@JsonProperty("name")
	private String name;
	@JsonProperty("useCertPinning")
	private boolean useCertPinning;
	@JsonProperty("guid")
	private Object guid;
	@JsonProperty("status")
	private String status;

}