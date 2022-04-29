package test.api.models.response.launcher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseLauncher{
	@JsonProperty("implantTemplateId")
	private int implantTemplateId;
	@JsonProperty("killDate")
	private String killDate;
	@JsonProperty("launcherString")
	private String launcherString;
	@JsonProperty("dotNetVersion")
	private String dotNetVersion;
	@JsonProperty("description")
	private String description;
	@JsonProperty("type")
	private String type;
	@JsonProperty("runtimeIdentifier")
	private String runtimeIdentifier;
	@JsonProperty("connectAttempts")
	private int connectAttempts;
	@JsonProperty("validateCert")
	private boolean validateCert;
	@JsonProperty("listenerId")
	private int listenerId;
	@JsonProperty("smbPipeName")
	private String smbPipeName;
	@JsonProperty("delay")
	private int delay;
	@JsonProperty("jitterPercent")
	private int jitterPercent;
	@JsonProperty("stagerCode")
	private String stagerCode;
	@JsonProperty("compressStager")
	private boolean compressStager;
	@JsonProperty("name")
	private String name;
	@JsonProperty("useCertPinning")
	private boolean useCertPinning;
	@JsonProperty("id")
	private int id;
	@JsonProperty("outputKind")
	private String outputKind;

}
